package com.lixuan;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class NormalTest {

    public static void main(String[] args){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<EventNotificationAlert version=\"2.0\" xmlns=\"http://www.hikvision.com/ver20/XMLSchema\">\n" +
                "    <ipAddress>192.168.1.70</ipAddress>\n" +
                "    <portNo>9088</portNo>\n" +
                "    <protocol>HTTP</protocol>\n" +
                "    <macAddress>08:54:11:ed:6d:90</macAddress>\n" +
                "    <channelID>1</channelID>\n" +
                "    <dateTime>2023-10-10T18:21:01+08:00</dateTime>\n" +
                "    <activePostCount>1</activePostCount>\n" +
                "    <eventType>ANPR</eventType>\n" +
                "    <eventState>active</eventState>\n" +
                "    <eventDescription>ANPR</eventDescription>\n" +
                "    <channelName>Camera 01</channelName>\n" +
                "    <ANPR>\n" +
                "        <licensePlate>蓝皖A7XG66</licensePlate>\n" +
                "        <line>1</line>\n" +
                "        <direction>reverse</direction>\n" +
                "        <confidenceLevel>97</confidenceLevel>\n" +
                "        <plateType>92TypeCivil</plateType>\n" +
                "        <plateColor>blue</plateColor>\n" +
                "        <licenseBright>0</licenseBright>\n" +
                "        <twoWheelVehicle>no</twoWheelVehicle>\n" +
                "        <threeWheelVehicle>no</threeWheelVehicle>\n" +
                "        <plateCharBelieve>98,99,99,99,99,99,99</plateCharBelieve>\n" +
                "        <vehicleType>van</vehicleType>\n" +
                "        <detectDir>1</detectDir>\n" +
                "        <detectType>0</detectType>\n" +
                "        <alarmDataType>0</alarmDataType>\n" +
                "        <vehicleInfo>\n" +
                "            <index>16776</index>\n" +
                "            <colorDepth>0</colorDepth>\n" +
                "            <color>gray</color>\n" +
                "            <length>0</length>\n" +
                "            <vehicleLogoRecog>1621</vehicleLogoRecog>\n" +
                "            <vehileSubLogoRecog>7</vehileSubLogoRecog>\n" +
                "            <vehileModel>131</vehileModel>\n" +
                "        </vehicleInfo>\n" +
                "        <pictureInfoList>\n" +
                "            <pictureInfo>\n" +
                "                <fileName>licensePlatePicture.jpg</fileName>\n" +
                "                <type>licensePlatePicture</type>\n" +
                "                <dataType>0</dataType>\n" +
                "                <picRecogMode>1</picRecogMode>\n" +
                "                <absTime>20231010182101925</absTime>\n" +
                "                <pId>2023101018210222200OLW1SaDY2NwI8</pId>\n" +
                "            </pictureInfo>\n" +
                "            <pictureInfo>\n" +
                "                <fileName>detectionPicture.jpg</fileName>\n" +
                "                <type>detectionPicture</type>\n" +
                "                <dataType>0</dataType>\n" +
                "                <picRecogMode>1</picRecogMode>\n" +
                "                <absTime>20231010182101925</absTime>\n" +
                "                <plateRect>\n" +
                "                    <X>568</X>\n" +
                "                    <Y>534</Y>\n" +
                "                    <width>41</width>\n" +
                "                    <height>26</height>\n" +
                "                </plateRect>\n" +
                "                <pId>2023101018210222200XP8rtdZteyIuP</pId>\n" +
                "            </pictureInfo>\n" +
                "        </pictureInfoList>\n" +
                "    </ANPR>\n" +
                "    <UUID>2023101018210222000oRLpp0ytu5g9UNTt1bKXHkZGgdLWXQcHpB8zLCACGwOO</UUID>\n" +
                "    <picNum>2</picNum>\n" +
                "    <monitoringSiteID></monitoringSiteID>\n" +
                "    <isDataRetransmission>false</isDataRetransmission>\n" +
                "    <DeviceGPSInfo>\n" +
                "        <longitudeType>E</longitudeType>\n" +
                "        <latitudeType>N</latitudeType>\n" +
                "        <Longitude>\n" +
                "            <degree>0</degree>\n" +
                "            <minute>0</minute>\n" +
                "            <sec>0.000000</sec>\n" +
                "        </Longitude>\n" +
                "        <Latitude>\n" +
                "            <degree>0</degree>\n" +
                "            <minute>0</minute>\n" +
                "            <sec>0.000000</sec>\n" +
                "        </Latitude>\n" +
                "    </DeviceGPSInfo>\n" +
                "    <detectionBackgroundImageResolution>\n" +
                "        <height>1264</height>\n" +
                "        <width>1920</width>\n" +
                "    </detectionBackgroundImageResolution>\n" +
                "</EventNotificationAlert>");
        JSONObject json = JSONUtil.parseFromXml(buffer.toString());
        json = json.getJSONObject("EventNotificationAlert");
        String ipAddress = json.getStr("ipAddress");
        String portNo = json.getStr("portNo");
        String protocol = json.getStr("protocol");
        String macAddress = json.getStr("macAddress");
        String eventType = json.getStr("eventType");
        String licensePlate = json.getJSONObject("ANPR").getStr("licensePlate");
        System.out.println(json.toString());
    }
}
