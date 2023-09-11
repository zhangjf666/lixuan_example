package com.lixuan.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.lixuan.util.HttpClientUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HikCameraController {

    @PostMapping("/sendCommand")
    public void sendCommand(@RequestBody String commandJson) throws URISyntaxException {
        log.info("发送命令参数:" + commandJson);
        Dict command = JSON.parseObject(commandJson, Dict.class);
        String ip = command.getStr("ip");
        String port = command.getStr("port");
        String userName = command.getStr("userName");
        String password = command.getStr("password");
        String url = command.getStr("url");
        Boolean useHttps = command.getBool("useHttps");
        String method = command.getStr("method");

        String address = StrUtil.format("http://{}:{}{}", ip, port, url);

        //发送命令
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        // 创建CredentialsProvider对象，设置用户名和密码
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));
        // 创建AuthCache对象
        AuthCache authCache = new BasicAuthCache();
        DigestScheme digestScheme = new DigestScheme();
        authCache.put(HttpHost.create("example.com"), digestScheme);
        // 创建HttpClientContext对象，设置凭据提供程序和AuthCache
        HttpClientContext httpClientContext = HttpClientContext.create();
        httpClientContext.setCredentialsProvider(credentialsProvider);
        httpClientContext.setAuthCache(authCache);
        // 设置请求的认证参数
        RequestConfig requestConfig = RequestConfig.custom()
                .setAuthenticationEnabled(true)
                .build();
        HttpRequestBase request = null;
        if(method.equalsIgnoreCase("GET")){
            request = new HttpGet(address);
        } else if(method.equalsIgnoreCase("POST")){
            request = new HttpPost(address);
        }
        request.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request, httpClientContext);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                //打印接受到的消息
                log.info("发送命令成功,返回信息:" + result);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            request.releaseConnection();
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @PostMapping("/listenMessage")
    public void receiveAlarm(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String method = request.getMethod();
        if(HttpMethod.POST.matches(method)){
            //Read stream
            byte[] buffer=new byte[50*1024];
            DataInputStream dataInputStream = new DataInputStream(request.getInputStream());
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            dataInputStream.close();

            String contentType = request.getContentType();
            //打印监听事件内容
            log.info("收到监听事件内容:" + output.toString());

            response.setStatus(HttpStatus.OK.value());
            response.getWriter().append("Date: ").append(DateUtil.formatDate(new Date())).append("Connection: close");
            response.getWriter().flush();
        }
    }
}
