package com.lixuan.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.lixuan.util.HttpClientUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HikCameraController {

    @Autowired
    private Environment env;

    @PostMapping("/sendCommand")
    public void sendCommand(@RequestBody String commandJson) throws URISyntaxException, UnsupportedEncodingException {
        log.info("发送命令参数:" + commandJson);
        Dict command = JSON.parseObject(commandJson, Dict.class);
        String ip = command.getStr("ip");
        String port = command.getStr("port");
        String userName = command.getStr("userName");
        String password = command.getStr("password");
        String url = command.getStr("url");
        Boolean useHttps = command.getBool("useHttps");
        String contentType = command.getStr("contentType");
        String parameterName = command.getStr("parameterName");
        String method = command.getStr("method");

        //获取参数
        String params = command.getStr("params");
        Dict paraMap = Dict.create();
        if(StringUtils.isNotBlank(params)){
            String[] param = params.split("\\|");
            for (String p: param) {
                if(StringUtils.isNotBlank(p)){
                    String[] comple = p.split("=");
                    if(comple.length == 2){
                        paraMap.set(comple[0], comple[1]);
                    }
                }
            }
        }

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
            String address = createGetUrl(useHttps, ip, port, url, contentType, paraMap);
            log.info("发送命令url:" + address);
            request = new HttpGet(address);
        } else if(method.equalsIgnoreCase("POST")){
            String address = createUrl(useHttps, ip, port, url, contentType);
            log.info("发送命令url:" + address);
            request = new HttpPost(address);
            String requestStr = "";
            JSONObject jb = new JSONObject();
            JSONObject jbs = new JSONObject();
            if(!paraMap.isEmpty()){
                for (Map.Entry p: paraMap.entrySet()) {
                    jbs.set(p.getKey().toString(), p.getValue());
                }
                jb.set(parameterName, jbs);

            }
            if(StringUtils.equalsIgnoreCase(contentType, "json")){
                requestStr = jb.toString();
            } else if (StringUtils.equalsIgnoreCase(contentType, "xml")) {
                requestStr = JSONUtil.toXmlStr(jb);
            }
            log.info("发送的内容:" + requestStr);
            StringEntity entity = new StringEntity(requestStr);
            ((HttpPost)request).setEntity(entity);
            entity.setContentEncoding("utf-8");
        } else if(method.equalsIgnoreCase("PUT")){
            String address = createUrl(useHttps, ip, port, url, contentType);
            log.info("发送命令url:" + address);
            request = new HttpPut(address);
            String requestStr = "";
            JSONObject jb = new JSONObject();
            JSONObject jbs = new JSONObject();
            if(!paraMap.isEmpty()){
                for (Map.Entry p: paraMap.entrySet()) {
                    jbs.set(p.getKey().toString(), p.getValue());
                }
                jb.set(parameterName, jbs);

            }
            if(StringUtils.equalsIgnoreCase(contentType, "json")){
                requestStr = jb.toString();
            } else if (StringUtils.equalsIgnoreCase(contentType, "xml")) {
                requestStr = JSONUtil.toXmlStr(jb);
            }
            log.info("发送的内容:" + requestStr);
            StringEntity entity = new StringEntity(requestStr);
            ((HttpPut)request).setEntity(entity);
            entity.setContentEncoding("utf-8");
        }
        request.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        String result = "";
        try {
            response = httpClient.execute(request, httpClientContext);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
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

    @PostMapping(value = {"/test"})
    public void receiveMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("接收test事件.");
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Enumeration<String> parameterNames = multipartHttpServletRequest.getParameterNames();
        log.info("parameterNames begin");
        if(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            log.info("parameter name={}", name);
        }
        log.info("parameterNames end");

        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        log.info("fileNames begin");
        if(fileNames.hasNext()){
            String name = fileNames.next();
            log.info("name={}", name);
            List<MultipartFile> files = multipartHttpServletRequest.getFiles(name);
            for (MultipartFile file: files) {
                log.info("file size:{}", file.getSize());
                log.info("file content_type:{}", file.getContentType());
                String output = "";
                try {
                    byte[] bytes = file.getBytes();
                    output = new String(bytes, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
                log.info("file content:{}",output);
            }
        }
        log.info("fileNames end");

        log.info("接收test事件完成.");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().append("Date: ").append(DateUtil.formatDate(new Date())).append("Connection: close");
        response.getWriter().flush();
    }

    @PostMapping(value = {"/listenMessage","/alarm"})
    public void receiveAlarm(HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.info("收到监听事件");
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(factory);
        try {
            if (!ServletFileUpload.isMultipartContent(request)) {
                log.info(request.getContentType());
                throw new Exception("no multipartContent");
            }else {
                List<FileItem> formData = sf.parseRequest(request);
                log.info("formData Size:{}", formData.size());
                for (FileItem fi : formData) {
                    if (fi.isFormField()) {
                        log.info("content-type:{}",fi.getContentType());
                        log.info("field_name:" + fi.getFieldName() + ":" + fi.getString("UTF-8"));
                        switch (fi.getFieldName()) {
                            case "event_log":
                                log.info("receive name");
                                break;
                            default:
                                log.info("unknow data");
                        }
                    } else {
                        String image_name = fi.getName();
                        log.info("image_name:" + image_name);
                        log.info("content-type:{}",fi.getContentType());
                        log.info("size:{}",fi.getSize());
                        if (!"".equals(image_name)) {
                            String image_dir_path = request.getServletContext().getRealPath("/images/");
                            File image_dir = new File(image_dir_path);
                            if (!image_dir.exists()) {
                                image_dir.mkdir();
                            }
                            String file_name = UUID.randomUUID().toString();
                            String suffix = image_name.substring(fi.getName().lastIndexOf("."));
                            log.info("image_dir_path:" + image_dir_path);
                            log.info("file_name:" + file_name);
                            log.info("suffix:" + suffix);
                            // 图片保存
                            fi.write(new File(image_dir_path, file_name + suffix));
                        } else {
                            throw new Exception("no file receive");
                        }
                    }
                }
                log.info("监听事件结束.");
                response.setStatus(HttpStatus.OK.value());
                response.getWriter().append("Date: ").append(DateUtil.formatDate(new Date())).append("Connection: close");
                response.getWriter().flush();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            response.getWriter().write("false");
        }
    }

    private ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        }
        return pairs;
    }

    private String createGetUrl(boolean useHttps, String ip, String port, String url, String contentType, Dict params){
        StringBuffer buffer = new StringBuffer(createUrl(useHttps, ip, port, url, contentType));
        if(!params.isEmpty()){
            if(buffer.indexOf("?") > 0){
                buffer.append("&");
            } else {
                buffer.append("?");
            }
            for (Map.Entry entry:params.entrySet()) {
                buffer.append(StrUtil.format("{}={}&", entry.getKey(), entry.getValue()));
            }
            return buffer.substring(0, buffer.length() - 1);
        }
        return buffer.toString();
    }

    private String createUrl(boolean useHttps, String ip, String port, String url, String contentType){
        StringBuffer buffer = new StringBuffer();
        buffer.append(useHttps ? "https://" : "http://");
        buffer.append(ip);
        buffer.append(":");
        buffer.append(port);
        buffer.append(url);
        if(StringUtils.equalsIgnoreCase(contentType, "json")){
            buffer.append("?format=json");
        }
        return buffer.toString();
    }
}
