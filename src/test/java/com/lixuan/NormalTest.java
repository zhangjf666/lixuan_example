package com.lixuan;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class NormalTest {

    public static void main(String[] args){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><EventNotificationAlert xmlns=\"http://www.isapi.org/ver20/XMLSchema\" version=\"2.0\">\n" +
                "  <!--ro, req, object, 车牌结果, attr:version{opt, string, 协议版本}-->\n" +
                "  <ipAddress>\n" +
                "    <!--ro, req, string, 报警设备IPv4地址-->172.6.64.7\n" +
                "  </ipAddress>\n" +
                "  <ipv6Address>\n" +
                "    <!--ro, opt, string, 报警设备IPv6地址-->1080:0:0:0:8:800:200C:417A\n" +
                "  </ipv6Address>\n" +
                "  <portNo>\n" +
                "    <!--ro, opt, int, 报警设备端口号-->80\n" +
                "  </portNo>\n" +
                "  <protocol>\n" +
                "    <!--ro, req, enum, 协议类型, subType:string, [HTTP#HTTP协议,HTTPS#HTTPS协议,EHome#EHome协议], desc:传输通信协议HTTP/HTTPS/EHome（萤石透传ISAPI 的时候赋值HTTP； ISUP透传ISAPI 的时候赋值 EHome）-->HTTP\n" +
                "  </protocol>\n" +
                "  <macAddress>\n" +
                "    <!--ro, opt, string, MAC地址-->01:17:24:45:D9:F4\n" +
                "  </macAddress>\n" +
                "  <dynChannelID>\n" +
                "    <!--ro, opt, string, 数字通道号-->test\n" +
                "  </dynChannelID>\n" +
                "  <channelID>\n" +
                "    <!--ro, opt, int, 触发报警的设备通道号, desc:触发的视频通道号-->1\n" +
                "  </channelID>\n" +
                "  <releatedChannelList>\n" +
                "    <!--ro, opt, string, 报警关联(同源)通道列表(与channelID在同一个相机上的通道), desc:用于平台收到报警时展示预览或回放,多个通道号用逗号隔开-->1,2,3\n" +
                "  </releatedChannelList>\n" +
                "  <dateTime>\n" +
                "    <!--ro, req, datetime, 报警触发时间-->1970-01-01T00:00:00+08:00\n" +
                "  </dateTime>\n" +
                "  <activePostCount>\n" +
                "    <!--ro, opt, int, 同一个报警已经上传的次数, desc:事件触发频次-->1\n" +
                "  </activePostCount>\n" +
                "  <eventType>\n" +
                "    <!--ro, req, enum, 事件类型, subType:string, [ANPR#车牌识别]-->ANPR\n" +
                "  </eventType>\n" +
                "  <eventState>\n" +
                "    <!--ro, req, enum, 持续性时间状态, subType:string, [active#有效事件,inactive#无效事件], desc:针对持续性事件-->active\n" +
                "  </eventState>\n" +
                "  <eventDescription>\n" +
                "    <!--ro, req, enum, 事件描述, subType:string, [ANPR#车牌识别]-->ANPR\n" +
                "  </eventDescription>\n" +
                "  <channelName>\n" +
                "    <!--ro, opt, string, 通道名称, range:[1,64]-->test\n" +
                "  </channelName>\n" +
                "  <deviceID>\n" +
                "    <!--ro, opt, string, 设备ID, desc:EHome报警中需返回，例如test0123（EHome2.0、EHome4.0、ISUP5.0）-->12345\n" +
                "  </deviceID>\n" +
                "  <ANPR>\n" +
                "    <!--ro, opt, object, 车牌识别报警信息-->\n" +
                "    <region>\n" +
                "      <!--ro, opt, enum, 区域（地区）, subType:string, [ER#俄语区域（Russian Region）,EU#欧洲（Europe Region）,EUandCIS#欧洲&俄罗斯（EU&CIS）,ME#中东（Middle East）,other#其他（other）,APAC#亚太区 Asia-Pacific Region,AFandAM#非美 Africa and America,THAandLA#泰国老挝区Thailand and Laos,HKandMO#港澳区 Hong Kong and Macao,All#所有区域（All Region）]-->ER\n" +
                "    </region>\n" +
                "    <country>\n" +
                "      <!--ro, opt, enum, 国家, subType:int, [253#invalid （字段无效,70#Philippines菲律宾,17#United Kingdom英国 之前叫Great Britain,23#Macedonia马其顿共和国  2018年改为North Macedonia,188#Dominican多米尼加,227#Australia澳大利亚,60#Bahrain巴林,95#Burma/Myanmar缅甸,228#New Zealand 新西兰,28#Azerbaijan阿塞拜疆共和国(亚洲),131#Gambia冈比亚,132#Mali马里,159#Saint Helena圣赫勒拿（英国海外省）,133#Burkina Faso布基纳法索,134#Guinea几内亚,135#Guinea-Bissau几内亚比绍,136#Cape Verde佛得角,137#Sierra Leone塞拉利昂,138#Liberia利比里亚,139#Ivory Coast科特迪瓦,140#Ghana加纳,141#Togo多哥,142#Benin贝宁,143#Niger尼日尔,144#Zambia赞比亚,145#Angola安哥拉,146#Zimbabwe津巴布韦,147#Malawi马拉维,148#Mozambique莫桑比克,149#Botswana博茨瓦纳,150#Namibia纳米比亚,151#South Africa南非,152#Swaziland斯威士兰,153#Lesotho莱索托,154#Madagasca马达加斯加,155#Comoros科摩罗,156#Mauritius毛里求斯,157#Nigeria尼日利亚,158#South Sudan南苏丹,160#Mayotte马约特（法国海外省）,161#Reunion留尼旺（法国海外省）,162#Canary Islands加那利群岛（西班牙海外领土）,163#AZORES亚速尔群岛（北大西洋非洲西海岸（葡萄牙））,164#Madeira马德拉群岛（北大西洋非洲西海岸（葡萄牙））,165#Reserved保留字段,166#Reserved保留字段,167#Reserved保留字段,168#Reserved保留字段,169#Canada加拿大,170#Greenland Nuuk格陵兰（丹麦王国的海外自治领土）,171#Pierre and Miquelon圣皮埃尔和密克隆（法国海外领土）,172#United State美国,173#Bermuda百慕大（英国海外领土）,174#Mexico墨西哥,175#Guatemala危地马拉,176#Belize伯利兹,177#El Salvador萨尔瓦多,178#Honduras洪都拉斯,179#Nicaragua尼加拉瓜,180#Costa Rica哥斯达黎加,181#Panama巴拿马,182#Bahamas巴哈马,183#Turks and  Caicos Islands特克斯群岛和凯科斯群岛（英国海外领土）,184#Cuba古巴,185#Jamaica牙买加,186#Cayman Islands开曼群岛（英国海外领土）,187#Haiti海地,189#Puerto Rico波多黎各（美国海外领土）,190#United States Virgin Islands美属维尔京群岛,191#British Virgin Islands英属维尔京群岛,192#Anguilla安圭拉（英国海外领土）,193#Antigua and Barbuda安提瓜和巴布达,194#Collectivité de Saint-Martin法属圣马丁（法国海外领土）,195#Autonomous country荷属圣马丁（荷兰王国的自治国）,196#Saint-Barthélemy圣巴泰勒米岛（法国海外领土）,197#Saint Kitts and Nevis圣基茨和尼维斯,198#Montserrat蒙特塞拉特（英国海外领土）,199#Guadeloupe瓜德罗普（法国海外领土）,200#Dominica多米尼克,201#Martinique马提尼克（法国海外领土）,202#St. Lucia圣卢西亚,203#Saint Vincent and the Grenadines圣文森特和格林纳丁斯,204#Grenada格林纳达,205#Barbados巴巴多斯,206#Trinidad and Tobago特立尼达和多巴哥,207#Cura?ao库拉索（荷兰王国的一个自治国）,0#Unsupported算法库不支持牌识国家,1#Czech Republic捷克共和国,2#France法国,3#Germany德国,4#Spain西班牙,5#Italy意大利,6#Netherlands荷兰,7#Poland波兰,8#Slovakia斯洛伐克,9#Belarus白俄罗斯,10#Moldova摩尔多瓦,11#Russia俄罗斯,12#Ukraine乌克兰,13#Belgium比利时,14#Bulgaria保加利亚,15#Denmark丹麦,16#Finland芬兰,18#Greece希腊,19#Croatia克罗地亚,20#Hungary匈牙利,21#Israel以色列(亚洲),22#Luxembourg卢森堡,24#Norway挪威,25#Portuga葡萄牙,26#Romania罗马尼亚,27#Serbia塞尔维亚,29#Georgia格鲁吉亚(亚洲),30#Kazakhstan哈萨克斯坦(亚洲),31#Lithuania立陶宛共和国,32#Turkmenistan土库曼斯坦(亚洲),33#Uzbekistan乌兹别克斯坦(亚洲),34#Latvia拉脱维亚,35#Estonia爱沙尼亚,36#Albania阿尔巴尼亚,37#Austria奥地利,38#Bosnia and Herzegovina波斯尼亚和黑塞哥维那,39#Ireland爱尔兰,40#Iceland冰岛,41#Vatican梵蒂冈,42#Malta马耳他,43#Sweden瑞典,44#Switzerland瑞士,45#Cyprus塞浦路斯,46#Turkey土耳其,47#Slovenia斯洛文尼亚,48#Montenegro黑山共和国,49#Kosovo科索沃,50#Andorra安道尔,51#Armenia亚美尼亚(亚洲),52#Monaco摩纳哥,53#Liechtenstein列支敦士登,54#San Marino圣马力诺,55#Reserved保留字段,56#Reserved保留字段,90#Iraq伊拉克,57#Reserved保留字段,58#Reserved保留字段,59#China中国,91#Vietnam越南,61#South Korea韩国,62#Lebanon黎巴嫩,63#Nepal尼泊尔,64#Thailand泰国,65#Pakistan巴基斯坦,66#United Arab Emirates阿拉伯联合酋长国,67#Bhutan不丹,68#Oman阿曼,69#North Korea朝鲜,71#Cambodia柬埔寨,72#Qatar卡塔尔,73#Kyrgyzstan吉尔吉斯斯坦,74#Maldives马尔代夫,75#Malaysia马来西亚,76#Mongolia蒙古,77#Saudi Arabia沙特阿拉伯,78#Brunei文莱,79#Laos老挝,80#Japan日本,81#Turkey土耳其,82#Palestinian巴勒斯坦国,83#Tajikistan塔吉克斯坦,84#Kuwait科威特,85#Syria叙利亚,86#India印度,87#Indonesia印度尼西亚,88#Afghanistan阿富汗,89#Sri Lanka斯里兰卡,92#Iran伊朗,93#Yemen也门,94#Jordan约旦,96#Sikkim锡金,97#Bangladesh孟加拉国,98#Singapore新加坡,99#Democratic Republic of Timor-Leste东帝汶（已宣布独立,100#Reserved保留字段,101#Reserved保留字段,102#Reserved保留字段,103#Reserved保留字段,104#Egypt埃及,105#Libya利比亚,106#Sudan苏丹,107#Tunisia突尼斯,108#Algeria阿尔及利亚,109#Morocco摩洛哥,110#Ethiopia埃塞俄比亚,111#Eritrea厄立特里亚,112#Somalia Democratic索马里,113#Djibouti吉布提,114#Kenya肯尼亚,115#Tanzania坦桑尼亚,116#Uganda乌干达,117#Rwanda卢旺达,118#Burundi布隆迪,119#Seychelles塞舌尔,120#Chad乍得,121#Central African中非,122#Cameroon喀麦隆,123#Equatorial Guinea赤道几内亚,124#Gabon加蓬,125#Congo刚果共和国（即：刚果（布））,126#Democratic Republic of the Congo刚果民主共和国（即：刚果（金））,127#Sao Tome and Principe圣多美和普林西比,128#Mauritania毛里塔尼亚,129#Western Sahara西撒哈拉（撒拉威）,130#Senegal塞内加尔,208#Aruba阿鲁巴（荷兰王国的一个自治国）,209#Netherlands Antilles荷属安的列斯,210#Colombia哥伦比亚,211#Venezuela委内瑞拉,212#Guyana圭亚那,213#Suriname苏里南,214#Guyane Francaise法属圭亚那,215#Ecuador厄瓜多尔,216#Peru秘鲁,217#Bolivia玻利维亚,218#Paraguay巴拉圭,219#Chile智利,220#Brazil巴西,221#Uruguay乌拉圭,222#Argentina阿根廷,223#Reserved保留字段,224#Reserved保留字段,225#Reserved保留字段,226#Reserved保留字段,229#Papua New Guinea巴布亚新几内亚,230#Salomonen所罗门群岛,231#Vanuatu瓦努阿图,232#New Caledonia新喀里多尼亚（法国的海外属地）,233#Palau帕劳,234#Federated States of Micronesia密克罗尼西亚联邦,235#Marshall Island马绍尔群岛,236#Northern Mariana Islands北马里亚纳群岛（美国的海外属地）,237#Guam关岛（美国的海外属地）,238#Nauru瑙鲁,239#Kiribati基里巴斯,240#Fidschi斐济群岛,241#Tonga汤加,242#Tuvalu图瓦卢,243#Wallis et Futuna瓦利斯和富图纳（法国的海外属地）,244#Samoa萨摩亚,245#Eastern Samoa美属萨摩亚,246#Tokelau托克劳（新西兰）,247#Niue纽埃（新西兰）,248#Cook Islands库克群岛（新西兰）,249#French Polynesia法属波利尼西亚,250#Pitcairn Islands皮特凯恩群岛（英国的海外属地）,251#Hawaii State夏威夷（美国的海外属地）,252#Reserved保留字段,254#Unrecognized无法识别,255#ALL全部]-->253\n" +
                "    </country>\n" +
                "    <area>\n" +
                "      <!--ro, opt, enum, 阿拉伯联合酋长国区域, subType:string, [FJR#富查伊哈,AD#阿布扎比,unknown#未知,UMW#乌姆盖万,other#其他,AM#阿治曼,RAK#哈伊马角,DB#迪拜,SJ#沙迦]-->FJR\n" +
                "    </area>\n" +
                "    <licensePlate>\n" +
                "      <!--ro, req, string, 车牌号码, range:[1,32], desc:noPlate-表示识别出无车牌车辆；unknown-表示未识别出车牌；具体车牌号字符串-例如，中文车牌蓝浙AX2P12 （需要带车牌颜色），海外车牌A283KY77（不需要带上车牌颜色）-->A283KY77\n" +
                "    </licensePlate>\n" +
                "    <cameraNo>\n" +
                "      <!--ro, opt, string, 设备编号, range:[1,48], desc:对应/ISAPI/System/Video/inputs/channels/<ID>/cameraInfo中cameraNum字段，部分交通设备使用/ISAPI/Traffic/channels/<channelID>/cameraInfo中的<cameraNum>字段，该协议为交通抢球设备自定义协议后移交协议集成组，两条协议信息同步，集成平台和设备开发需注意兼容处理，新设备建议统一使用/ISAPI/System/Video/inputs/channels/<ID>/cameraInfo-->test\n" +
                "    </cameraNo>\n" +
                "    <line>\n" +
                "      <!--ro, req, int, 识别车道号-->1\n" +
                "    </line>\n" +
                "    <direction>\n" +
                "      <!--ro, opt, enum, 目标方向, subType:string, [reverse#反向,forward#正向,unknown#未知]-->reverse\n" +
                "    </direction>\n" +
                "    <confidenceLevel>\n" +
                "      <!--ro, req, int, 置信度等级, range:[0,100]-->50\n" +
                "    </confidenceLevel>\n" +
                "    <plateType>\n" +
                "      <!--ro, opt, enum, 车牌类型, subType:string, [unknown#未知,92TypeCivil#92式民用车,arm#警车,upDownMilitay#上下军车,92TypeArm#92式武警车,leftRightMilitay#左右军车,02TypePersonalized#02式个性化车,yellowTwoLine#黄色双行尾牌,04NewMilitay#04式新军车,embassy#使馆车,oneLineArm#一行结构的新武警车,twoLineArm#两行结构的新武警车,yellow1225FarmVehicle#黄色1225农用车,green1325FarmVehicle#绿色1325农用车,yellow1325FarmVehicle#黄色1325结构农用车,motorola#摩托车,coach#教练车,tempTravl#临时行驶车,trailer#挂车,consulate#领馆汽车,hongKongMacao#港澳入出车,tempEntry#临时入境车,civilAviation#民航车牌,newEnergy#新能源车牌,92FarmVehicle#民用车双行尾牌（补录）,emergency#应急车牌,oneLineArmHeadquarters#一行结构武警总部车牌,twoLineArmHeadquarters#两行结构武警总部车牌,twoWheelVehicle#二轮车]-->unknown\n" +
                "    </plateType>\n" +
                "    <plateColor>\n" +
                "      <!--ro, opt, enum, 车牌颜色, subType:string, [black#黑色,blue#蓝色,golden#金色,orange#橙色,red#红色,yellow#黄色,white#白色,unknown#未知,other#其他颜色,newEnergyYellowGreen#新能源黄绿色,civilAviationBlack#民航黑色,civilAviationGreen#民航绿色,green#绿色,mixedColor#花底,newEnergyGreen#新能源绿色,brown#棕色]-->black\n" +
                "    </plateColor>\n" +
                "    <licenseBright>\n" +
                "      <!--ro, opt, int, 车牌亮度值[0~255], range:[0,255]-->50\n" +
                "    </licenseBright>\n" +
                "    <Rect>\n" +
                "      <!--ro, opt, object, 匹配图片车牌子图坐标, desc:后端超脑使用,后续不再扩展，屏幕左上角为坐标原点-->\n" +
                "      <height>\n" +
                "        <!--ro, req, float, 高度, range:[0.000,1.000]-->1.000\n" +
                "      </height>\n" +
                "      <width>\n" +
                "        <!--ro, req, float, 宽度, range:[0.000,1.000]-->1.000\n" +
                "      </width>\n" +
                "      <x>\n" +
                "        <!--ro, req, float, 左上角原点, range:[0.000,1.000]-->1.000\n" +
                "      </x>\n" +
                "      <y>\n" +
                "        <!--ro, req, float, 左上角原点, range:[0.000,1.000]-->1.000\n" +
                "      </y>\n" +
                "    </Rect>\n" +
                "    <pilotsafebelt>\n" +
                "      <!--ro, opt, enum, 检测主驾驶安全带, subType:string, [unknown#未知,yes#带,no#不带]-->unknown\n" +
                "    </pilotsafebelt>\n" +
                "    <vicepilotsafebelt>\n" +
                "      <!--ro, opt, enum, 检测副驾驶安全带, subType:string, [unknown#unknown,yes#yes,no#no]-->unknown\n" +
                "    </vicepilotsafebelt>\n" +
                "    <pilotsunvisor>\n" +
                "      <!--ro, opt, enum, 主驾驶检测遮阳板, subType:string, [unknown#unknown,yes#yes,no#no]-->unknown\n" +
                "    </pilotsunvisor>\n" +
                "    <vicepilotsunvisor>\n" +
                "      <!--ro, opt, enum, 副驾驶检测遮阳板, subType:string, [unknown#unknown,yes#yes,no#no]-->unknown\n" +
                "    </vicepilotsunvisor>\n" +
                "    <envprosign>\n" +
                "      <!--ro, opt, enum, 黄标车, subType:string, [unknown#未知,green#绿标,yellow#黄标,yes#yes,no#no]-->unknown\n" +
                "    </envprosign>\n" +
                "    <dangmark>\n" +
                "      <!--ro, opt, enum, 危险品车, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "    </dangmark>\n" +
                "    <uphone>\n" +
                "      <!--ro, opt, enum, 是否打电话, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "    </uphone>\n" +
                "    <pendant>\n" +
                "      <!--ro, opt, enum, 是否有挂件, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "    </pendant>\n" +
                "    <tissueBox>\n" +
                "      <!--ro, opt, enum, 是否有纸巾盒, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "    </tissueBox>\n" +
                "    <frontChild>\n" +
                "      <!--ro, opt, enum, 副驾驶是否怀抱婴儿/儿童是否单独乘坐副驾, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "    </frontChild>\n" +
                "    <label>\n" +
                "      <!--ro, opt, enum, 是否有贴标, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "    </label>\n" +
                "    <decoration>\n" +
                "      <!--ro, opt, enum, 是否有摆件, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "    </decoration>\n" +
                "    <smoking>\n" +
                "      <!--ro, opt, enum, 吸烟, subType:string, [yes#吸烟,no#未吸烟,unknown#未知]-->yes\n" +
                "    </smoking>\n" +
                "    <perfumeBox>\n" +
                "      <!--ro, opt, enum, 香水盒检测, subType:string, [unknown#未知,yes#有,no#无]-->unknown\n" +
                "    </perfumeBox>\n" +
                "    <pdvs>\n" +
                "      <!--ro, opt, enum, 天窗是否站人, subType:string, [unknown#未知,yes#是,no#否], desc:可通过/ISAPI/ITC/carFeatureParam中CarBodyFeature进行配置-->unknown\n" +
                "    </pdvs>\n" +
                "    <helmet>\n" +
                "      <!--ro, opt, enum, 非机动车驾驶员戴头盔, subType:string, [no#否,unknown#未知,yes#是]-->no\n" +
                "    </helmet>\n" +
                "    <twoWheelVehicle>\n" +
                "      <!--ro, opt, enum, unknown, subType:string, [unknown#未知,yes#是,no#不是]-->unknown\n" +
                "    </twoWheelVehicle>\n" +
                "    <threeWheelVehicle>\n" +
                "      <!--ro, opt, enum, 三轮车检测, subType:string, [unknown#未知,yes#是,no#不是]-->unknown\n" +
                "    </threeWheelVehicle>\n" +
                "    <blackness>\n" +
                "      <!--ro, opt, int, 林格曼黑度值, desc:林格曼黑度值,用于冒黑烟检测-->2\n" +
                "    </blackness>\n" +
                "    <plateCharBelieve>\n" +
                "      <!--ro, opt, string, 各个识别字符的置信度, desc:各个识别字符的置信度,如检测到车牌\"A12345\",置信度为10,20,30,40,50,60,70,则表示\"浙\"字正确的可能性只有10%,\"A\"字的正确的可能性是20%-->test\n" +
                "    </plateCharBelieve>\n" +
                "    <speedLimit>\n" +
                "      <!--ro, opt, int, 限速上限, desc:限速上限,超速时有效-->50\n" +
                "    </speedLimit>\n" +
                "    <illegalInfo>\n" +
                "      <!--ro, opt, object, 车辆交通违章信息, \n" +
                "desc:1.在没有自定义违法信息的情况下，设备违法信息默认为“全国交通违章代码”，illegalCode返回值参考：\n" +
                "             https://www.chajiaotong.com/weizhangdaimachaxun\n" +
                "      2.用户可对设备已有的违章代码做自定义的增、删、改，illegalCode可通过下面接口进行导入或者配置：\n" +
                "             自定义违法代码配置接口：/ISAPI/ITC/illegalDictionary\n" +
                "             导入自定义违法代码文件：/ISAPI/ITC/illegalCodeData-->\n" +
                "      <illegalCode>\n" +
                "        <!--ro, req, string, 违法代码, range:[0,64]-->1301\n" +
                "      </illegalCode>\n" +
                "      <illegalName>\n" +
                "        <!--ro, req, string, 违法名称, range:[0,128]-->逆行\n" +
                "      </illegalName>\n" +
                "      <illegalDescription>\n" +
                "        <!--ro, opt, string, 违法描述, range:[0,256]-->车辆逆行\n" +
                "      </illegalDescription>\n" +
                "    </illegalInfo>\n" +
                "    <vehicleType>\n" +
                "      <!--ro, req, enum, 车辆类型, subType:string, [nonmotorVehicle#非机动车（平台转成：三轮车）,smallCar#小型轿车（平台转成：轿车）,miniCar#微型轿车（平台转成：轿车）,pickupTruck#皮卡车（平台转成：小货车）,unknown#未知,largeBus#大型客车,truck#货车,vehicle#轿车,van#面包车,buggy#小货车,pedestrian#行人,twoWheelVehicle#二轮车,threeWheelVehicle#三轮车,SUVMPV#SUV/MPV,mediumBus#中型客车,motorVehicle#机动车（平台转成：轿车）,crane#吊车,minibus#小型客车,coupe#轿跑,concreteMixer#混凝土搅拌车,slagTruck#渣土车,minitruck#微卡,containerTruck#集装箱卡车,platformTrailer#平板拖车,oilTankTruck#油罐车,hatchback#两厢轿车,saloon#三厢轿车,bus#客车,lightTruck#轻微货车,mediumHeavyTruck#中重型货车]-->nonmotorVehicle\n" +
                "    </vehicleType>\n" +
                "    <postPicFileName>\n" +
                "      <!--ro, opt, string, 违章时取哪张图片作为卡口图, desc:违章时取哪张图片作为卡口图,none-表示不取-->test\n" +
                "    </postPicFileName>\n" +
                "    <featurePicFileName>\n" +
                "      <!--ro, opt, string, 闯红灯电警, desc:闯红灯电警,取哪图作为特写图,none-表示不取-->test\n" +
                "    </featurePicFileName>\n" +
                "    <detectDir>\n" +
                "      <!--ro, opt, enum, 检测方向, subType:int, [1#上行,2#下行,3#双向,4#由东向西,5#由南向北,6#由西向东,7#由北向南,8#其它], desc:这个是相机安装架设的监控角度方向,一个相机只能配一种方向。用户通过触发模式中进行配置。同时还是用于OSD叠加,即是上报字符叠加里面配置的值-->1\n" +
                "    </detectDir>\n" +
                "    <detectType>\n" +
                "      <!--ro, opt, enum, 检测方式, subType:int, [0#车辆检测,1#地感触发,2#视频触发,3#多帧识别,4#雷达触发,5#混行检测]-->1\n" +
                "    </detectType>\n" +
                "    <barrierGateCtrlType>\n" +
                "      <!--ro, opt, enum, 历时数据开闸标志, subType:int, [0#已经开启,1#未开启]-->0\n" +
                "    </barrierGateCtrlType>\n" +
                "    <alarmDataType>\n" +
                "      <!--ro, opt, enum, 实时or历史数据, subType:int, [1#历史数据,0#实时数据]-->0\n" +
                "    </alarmDataType>\n" +
                "    <dwIllegalTime>\n" +
                "      <!--ro, opt, int, 违法持续时间（ms）, unit:ms, unitType:时间, desc:违法持续时间（ms）=抓拍最后一张图片的时间-抓拍第一张图片的时间-->100\n" +
                "    </dwIllegalTime>\n" +
                "    <vehicleInfo>\n" +
                "      <!--ro, opt, object, 车辆信息-->\n" +
                "      <index>\n" +
                "        <!--ro, req, int, 车辆序号-->1\n" +
                "      </index>\n" +
                "      <vehicleType>\n" +
                "        <!--ro, opt, enum, 车辆类型, subType:int, [0#其它车型,1#小型车,2#大型车,3#行人触发,4#二轮车触发,5#三轮车触发,6#机动车触发], desc:老车辆类型，支持基本车辆类型返回，本字段和vehicleInfo字段平级的vehicleType字段同时只需要返回一个-->0\n" +
                "      </vehicleType>\n" +
                "      <colorDepth>\n" +
                "        <!--ro, req, enum, 车身颜色深浅, subType:int, [0#深色,1#浅色,2#未知]-->0\n" +
                "      </colorDepth>\n" +
                "      <color>\n" +
                "        <!--ro, req, enum, 车辆颜色, subType:string, [green#绿,brown#棕,pink#粉,purple#紫,deepGray#深灰,cyan#青,orange#橙,unknown#未知,white#白,silver#银,gray#灰,black#黑,red#红,deepBlue#深蓝,blue#蓝,yellow#黄]-->green\n" +
                "      </color>\n" +
                "      <speed>\n" +
                "        <!--ro, opt, int, 目标速度, unit:km/h, unitType:速度-->1\n" +
                "      </speed>\n" +
                "      <length>\n" +
                "        <!--ro, req, int, 前一辆车的车身长度, unit:dm, unitType:长度-->10\n" +
                "      </length>\n" +
                "      <vehicleLogoRecog>\n" +
                "        <!--ro, req, int, 车辆主品牌-->1\n" +
                "      </vehicleLogoRecog>\n" +
                "      <vehileSubLogoRecog>\n" +
                "        <!--ro, opt, int, 车辆子品牌-->1\n" +
                "      </vehileSubLogoRecog>\n" +
                "      <vehileModel>\n" +
                "        <!--ro, opt, int, 车辆子品牌年款-->1\n" +
                "      </vehileModel>\n" +
                "      <vehicleTypeByWeight>\n" +
                "        <!--ro, opt, enum, 按车重车辆类型, subType:int, [1#客车:7座及7座以下、货车:2吨以下,2#客车:8-19座、货车:载重2吨-5吨(含),3#客车:20-39座、货车:载重5吨-10吨(含),4#客车:40座以上\"货车:10吨-15吨(含),5#五类车(货车载重15吨以上),6#六类车(货车载重15吨以上)]-->4\n" +
                "      </vehicleTypeByWeight>\n" +
                "      <tollRoadVehicleSeries>\n" +
                "        <!--ro, opt, enum, 收费公路车辆系列, subType:int, [1#客车,2#货车,3#专项作业车], desc:按《JT-T 489-2019 收费公路车辆通行费车型分类》,需与tollRoadVehicleType组合使用-->2\n" +
                "      </tollRoadVehicleSeries>\n" +
                "      <tollRoadVehicleType>\n" +
                "        <!--ro, opt, enum, 收费公路车辆类型, subType:int, [1#1类,2#2类,3#3类,4#4类,5#5类,6#6类], desc:按《JT-T 489-2019 收费公路车辆通行费车型分类》,需与tollRoadVehicleSeries组合使用-->4\n" +
                "      </tollRoadVehicleType>\n" +
                "      <CarWindowFeature>\n" +
                "        <!--ro, opt, object, 车窗特征, desc:通过/ISAPI/ITC/carFeatureParam中CarWindowFeature进行配置-->\n" +
                "        <tempPlate>\n" +
                "          <!--ro, opt, enum, 是否有临牌, subType:string, [unknown#未知,yes#是,no#否], desc:开启检测车窗上是否存在临牌-->unknown\n" +
                "        </tempPlate>\n" +
                "        <passCard>\n" +
                "          <!--ro, opt, enum, 是否有出入证, subType:string, [unknown#未知,yes#是,no#否], desc:车窗上是否存在出入证-->unknown\n" +
                "        </passCard>\n" +
                "        <carCard>\n" +
                "          <!--ro, opt, enum, 是否有卡片, subType:string, [unknown#未知,yes#是,no#否], desc:车窗上是否存在卡片(如插入名片、传单等)-->unknown\n" +
                "        </carCard>\n" +
                "      </CarWindowFeature>\n" +
                "      <CarBodyFeature>\n" +
                "        <!--ro, opt, object, 车身属性, desc:通过/ISAPI/ITC/carFeatureParam中CarBodyFeature进行配置-->\n" +
                "        <sparetire>\n" +
                "          <!--ro, opt, enum, 是否有备胎, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "        </sparetire>\n" +
                "        <rack>\n" +
                "          <!--ro, opt, enum, 是否有行李架, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "        </rack>\n" +
                "        <sunRoof>\n" +
                "          <!--ro, opt, enum, 是否有天窗, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "        </sunRoof>\n" +
                "        <words>\n" +
                "          <!--ro, opt, enum, 是否有车身喷字, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "        </words>\n" +
                "        <slagTruckCoverPlate>\n" +
                "          <!--ro, opt, enum, 是否渣土车盖板, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "        </slagTruckCoverPlate>\n" +
                "      </CarBodyFeature>\n" +
                "      <vehicleUseType>\n" +
                "        <!--ro, opt, enum, 车辆用途类型, subType:string, [taxi#出租车,ambulance#救护车,bus#公交车,schoolBus#校车,coach#长途客车,unknown#未知], desc:通过/ISAPI/ITC/carFeatureParam中vehicleUseEnable进行配置-->taxi\n" +
                "      </vehicleUseType>\n" +
                "      <carWindowInfo>\n" +
                "        <!--ro, opt, object, 车窗信息, desc:通过/ISAPI/ITC/TriggerMode/HOVLaneDetection?format=json进行配置-->\n" +
                "        <carWindowNum>\n" +
                "          <!--ro, opt, int, 车窗数, desc:开启检测车窗上是否存在临牌-->4\n" +
                "        </carWindowNum>\n" +
                "        <carWindowStatusList>\n" +
                "          <!--ro, opt, object, 车窗状态列表-->\n" +
                "          <carWindowStatus>\n" +
                "            <!--ro, opt, object, 车窗状态-->\n" +
                "            <passengers>\n" +
                "              <!--ro, opt, int, 车窗内人数, range:[1,10]-->1\n" +
                "            </passengers>\n" +
                "            <windowStatus>\n" +
                "              <!--ro, opt, enum, 车窗是否打透状态, subType:string, [unknown#未知,yes#是,no#否]-->yes\n" +
                "            </windowStatus>\n" +
                "          </carWindowStatus>\n" +
                "        </carWindowStatusList>\n" +
                "      </carWindowInfo>\n" +
                "      <actualPassengers>\n" +
                "        <!--ro, opt, int, 车内实际乘客数, range:[0,100]-->1\n" +
                "      </actualPassengers>\n" +
                "      <vehiclePosition>\n" +
                "        <!--ro, opt, enum, 检测出的车身位置类型, subType:string, [leftSide#左侧面,rightSide#右侧面,headStock#车头,tailStock#车尾,roof#车顶]-->leftSide\n" +
                "      </vehiclePosition>\n" +
                "      <containerInfo>\n" +
                "        <!--ro, opt, object, 集装箱信息-->\n" +
                "        <containerNum>\n" +
                "          <!--ro, opt, int, 转载的集装箱个数, range:[1,10]-->2\n" +
                "        </containerNum>\n" +
                "        <containerList>\n" +
                "          <!--ro, opt, array, 集装箱信息列表, subType:object, range:[1,10]-->\n" +
                "          <container>\n" +
                "            <!--ro, opt, object, 集装箱信息-->\n" +
                "            <containerMainNum>\n" +
                "              <!--ro, opt, string, 抓拍的集装箱主号码, range:[1,32]-->abcd1234\n" +
                "            </containerMainNum>\n" +
                "            <containerSubNum>\n" +
                "              <!--ro, opt, string, 抓拍的集装箱副号码, range:[1,32]-->abcd1234\n" +
                "            </containerSubNum>\n" +
                "            <containerISONum>\n" +
                "              <!--ro, opt, string, 抓拍的集装箱ISO号码, range:[1,32]-->abcd1234\n" +
                "            </containerISONum>\n" +
                "            <containerNumConfidence>\n" +
                "              <!--ro, opt, int, 抓拍的集装箱号码置信度, range:[0,100]-->0\n" +
                "            </containerNumConfidence>\n" +
                "          </container>\n" +
                "        </containerList>\n" +
                "      </containerInfo>\n" +
                "      <RFID>\n" +
                "        <!--ro, opt, string, 关联RFID, range:[1,64], dep:and,{$.EventNotificationAlert.ANPR.vehicleType,eq,nonmotorVehicle}-->12345\n" +
                "      </RFID>\n" +
                "      <vehicleCarryFeature>\n" +
                "        <!--ro, opt, object, 车辆载货属性-->\n" +
                "        <isCarry>\n" +
                "          <!--ro, opt, enum, 是否载货, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "        </isCarry>\n" +
                "        <isTarpaulin>\n" +
                "          <!--ro, opt, enum, 是否有篷布, subType:string, [unknown#未知,yes#是,no#否]-->unknown\n" +
                "        </isTarpaulin>\n" +
                "      </vehicleCarryFeature>\n" +
                "    </vehicleInfo>\n" +
                "    <EntranceInfo>\n" +
                "      <!--ro, opt, object, 出入口信息-->\n" +
                "      <parkingID>\n" +
                "        <!--ro, opt, string, 停车点编号-->test\n" +
                "      </parkingID>\n" +
                "      <gateID>\n" +
                "        <!--ro, opt, string, 出入口编号-->test\n" +
                "      </gateID>\n" +
                "      <direction>\n" +
                "        <!--ro, opt, enum, 目标方向, subType:string, [enter#进入,leave#离开]-->enter\n" +
                "      </direction>\n" +
                "      <cardNo>\n" +
                "        <!--ro, opt, string, 卡编号-->test\n" +
                "      </cardNo>\n" +
                "      <parkType>\n" +
                "        <!--ro, opt, enum, 停车类型, subType:string, [temporary#临时,permanent#固定]-->temporary\n" +
                "      </parkType>\n" +
                "    </EntranceInfo>\n" +
                "    <pictureInfoList>\n" +
                "      <!--ro, req, array, 图片列表, subType:object, range:[0,8]-->\n" +
                "      <pictureInfo>\n" +
                "        <!--ro, req, object, 图片信息-->\n" +
                "        <fileName>\n" +
                "          <!--ro, req, enum, 图片名称, subType:string, [detectionPicture.jpg#检测图(背景图),licensePlatePicture.jpg#车牌小图,pilotPicture.jpg#主驾驶抠图,copilotPicture.jpg#副驾驶抠图,compositePicture.jpg#合成图,plateBinaryPicture.jpg#车牌二值图,nonMotorPicture.jpg#非机动车抠图,pedestrianDetectionPicture.jpg#非机动车和行人图(背景图),pedestrianPicture.jpg#行人抠图,vehiclePicture.jpg#机动车图,featurePicture.jpg#特写图,panoramaPicture.jpg#全景通道大图], desc:图片名称,必须和报警消息一起传过来的图片名称对应,有多张同类图片时，filename采取如下规则命名：每个filename的扩展名之前加上“_1”、“_2”等后缀，例如有三张检测图的时候，检测图的命名：detectionPicture_1.jpg、detectionPicture_2.jpg、 detectionPicture_3.jpg-->detectionPicture.jpg\n" +
                "        </fileName>\n" +
                "        <type>\n" +
                "          <!--ro, req, enum, 停车类型, subType:string, [detectionPicture#检测图(背景图),licensePlatePicture#车牌小图,pilotPicture#主驾驶抠图,copilotPicture#副驾驶抠图,compositePicture#合成图,plateBinaryPicture#车牌二值图,nonMotorPicture#非机动车抠图,pedestrianDetectionPicture#行人图,pedestrianPicture#行人抠图,vehiclePicture#机动车图,featurePicture.jpg#特写图,panoramaPicture#全景通道大图]-->vehiclePicture\n" +
                "        </type>\n" +
                "        <dataType>\n" +
                "          <!--ro, req, enum, 数据类型, subType:int, [0#二机制,1#URL]-->0\n" +
                "        </dataType>\n" +
                "        <picRecogMode>\n" +
                "          <!--ro, opt, enum, 牌识模式, subType:int, [0#正向车牌识别,1#背向识别(尾牌识别)]-->0\n" +
                "        </picRecogMode>\n" +
                "        <redLightTime>\n" +
                "          <!--ro, opt, int, 经过的红灯时间(s), unit:s, unitType:时间-->60\n" +
                "        </redLightTime>\n" +
                "        <vehicleHead>\n" +
                "          <!--ro, opt, enum, 车牌识别方向, subType:string, [unknown#未知,forward#正向,back#背向]-->unknown\n" +
                "        </vehicleHead>\n" +
                "        <absTime>\n" +
                "          <!--ro, opt, string, 绝对时间点, desc:格式:yyyyMMddHHmmssxxx,e.g.20090810235959999  最后三位为毫秒数-->20090810235959999\n" +
                "        </absTime>\n" +
                "        <plateRect>\n");
        buffer.append("          <!--ro, opt, object, 车牌区域坐标, desc:当type=detectionPicture时生效;归一化,数值为当前画面的千分比大小*1000，屏幕左上角为坐标原点-->\n" +
                "          <X>\n" +
                "            <!--ro, req, int, 边界框左上角点的X轴坐标, range:[0,1000]-->1000\n" +
                "          </X>\n" +
                "          <Y>\n" +
                "            <!--ro, req, int, 边界框左上角点的Y轴坐标, range:[0,1000]-->1000\n" +
                "          </Y>\n" +
                "          <width>\n" +
                "            <!--ro, req, int, 边界框的宽度, range:[0,1000]-->1000\n" +
                "          </width>\n" +
                "          <height>\n" +
                "            <!--ro, req, int, 边界框的高度, range:[0,1000]-->1000\n" +
                "          </height>\n" +
                "        </plateRect>\n" +
                "        <vehicelRect>\n" +
                "          <!--ro, opt, object, 车辆区域坐标, desc:归一化,数值为当前画面的千分比大小*1000,当type=detectionPicture时生效，屏幕左上角为坐标原点-->\n" +
                "          <X>\n" +
                "            <!--ro, req, int, 边界框左上角点的X轴坐标, range:[0,1000]-->1000\n" +
                "          </X>\n" +
                "          <Y>\n" +
                "            <!--ro, req, int, 边界框左上角点的Y轴坐标, range:[0,1000]-->1000\n" +
                "          </Y>\n" +
                "          <width>\n" +
                "            <!--ro, req, int, 边界框的宽度, range:[0,1000]-->1000\n" +
                "          </width>\n" +
                "          <height>\n" +
                "            <!--ro, req, int, 边界框的高度, range:[0,1000]-->1000\n" +
                "          </height>\n" +
                "        </vehicelRect>\n" +
                "        <pictureURL>\n" +
                "          <!--ro, opt, string, 图片URL, desc:当<dataType> ==URL时生效-->test\n" +
                "        </pictureURL>\n" +
                "        <pId>\n" +
                "          <!--ro, opt, string, strlen.max=32, range:[1,32], desc:建议生成规则（设备序列号+设备启动时间至今的时间+随机数）-->test\n" +
                "        </pId>\n" +
                "        <province>\n" +
                "          <!--ro, opt, enum, 中国省份索引, subType:int, [0#保留,1#澳,10#冀,11#豫,12#黑,13#鄂,14#湘,15#吉,16#苏,17#赣,18#辽,19#蒙,2#京,20#宁,21#青,22#鲁,23#晋,24#陕,25#沪,255#全部,26#川,27#台,28#津,29#藏,3#渝,30#港,31#新,32#云,33#浙,34#皖,4#闽,5#甘,6#粤,7#桂,8#贵,9#琼], desc:当支持三地车牌（内地、港、澳）时会存在返回三张车牌小图的情况,该字段可用于区分为当前为哪个省的车牌-->0\n" +
                "        </province>\n" +
                "      </pictureInfo>\n" +
                "    </pictureInfoList>\n" +
                "    <hasMoreData>\n" +
                "      <!--ro, opt, bool, 是否还有后续数据, desc:是否还有后续数据,本节点用于先报车牌信息,再报完整的xml+图片数据,第二次完整上传通过UUID与第一次上传的信息关联-->true\n" +
                "    </hasMoreData>\n" +
                "    <listType>\n" +
                "      <!--ro, opt, enum, 名单属性, subType:string, [white#授权名单,black#非授权名单,temporary#临时名单]-->white\n" +
                "    </listType>\n" +
                "    <originalLicensePlate>\n" +
                "      <!--ro, opt, string, 原始车牌号码, desc:原始车牌号码,当为小语种车牌时,返回未转化为英文的原始车牌号码,支持返回类似德语的小语种符号(如Ä/ä、Ö/ö、Ü/ü等符号)-->test\n" +
                "    </originalLicensePlate>\n" +
                "    <CRIndex>\n" +
                "      <!--ro, opt, enum, 国家/区域, subType:int, [258#Macau (China)中国澳门,257#Hong Kong (China)中国香港,134#Guinea几内亚,135#Guinea-Bissau几内亚比绍,136#Cape Verde佛得角,137#Sierra Leone塞拉利昂,138#Liberia利比里亚,139#Ivory Coast科特迪瓦,140#Ghana加纳,141#Togo多哥,142#Benin贝宁,143#Niger尼日尔,81#Turkey土耳其,82#Palestinian巴勒斯坦国,83#Tajikistan塔吉克斯坦,84#Kuwait科威特,85#Syria叙利亚,86#India印度,87#Indonesia印度尼西亚,88#Afghanistan阿富汗,89#Sri Lanka斯里兰卡,92#Iran伊朗,93#Yemen也门,94#Jordan约旦,96#Sikkim锡金,97#Bangladesh孟加拉国,98#Singapore新加坡,99#Democratic Republic of Timor-Leste东帝汶（已宣布独立,100#Reserved保留字段,101#Reserved保留字段,102#Reserved保留字段,103#Reserved保留字段,27#Serbia塞尔维亚,29#Georgia格鲁吉亚(亚洲),30#Kazakhstan哈萨克斯坦(亚洲),31#Lithuania立陶宛共和国,32#Turkmenistan土库曼斯坦(亚洲),144#Zambia赞比亚,145#Angola安哥拉,146#Zimbabwe津巴布韦,147#Malawi马拉维,148#Mozambique莫桑比克,149#Botswana博茨瓦纳,150#Namibia纳米比亚,151#South Africa南非,152#Swaziland斯威士兰,153#Lesotho莱索托,154#Madagasca马达加斯加,155#Comoros科摩罗,156#Mauritius毛里求斯,157#Nigeria尼日利亚,158#South Sudan南苏丹,160#Mayotte马约特（法国海外省）,161#Reunion留尼旺（法国海外省）,162#Canary Islands加那利群岛（西班牙海外领土）,163#AZORES亚速尔群岛（北大西洋非洲西海岸（葡萄牙））,164#Madeira马德拉群岛（北大西洋非洲西海岸（葡萄牙））,165#Reserved保留字段,166#Reserved保留字段,167#Reserved保留字段,168#Reserved保留字段,169#Canada加拿大,170#Greenland Nuuk格陵兰（丹麦王国的海外自治领土）,171#Pierre and Miquelon圣皮埃尔和密克隆（法国海外领土）,172#United State美国,173#Bermuda百慕大（英国海外领土）,174#Mexico墨西哥,175#Guatemala危地马拉,176#Belize伯利兹,177#El Salvador萨尔瓦多,178#Honduras洪都拉斯,179#Nicaragua尼加拉瓜,180#Costa Rica哥斯达黎加,181#Panama巴拿马,182#Bahamas巴哈马,183#Turks and  Caicos Islands特克斯群岛和凯科斯群岛（英国海外领土）,184#Cuba古巴,185#Jamaica牙买加,186#Cayman Islands开曼群岛（英国海外领土）,187#Haiti海地,189#Puerto Rico波多黎各（美国海外领土）,253#Reserved保留字段,227#Australia澳大利亚,60#Bahrain巴林,95#Burma/Myanmar缅甸,17#United Kingdom英国 之前叫Great Britain,188#Dominican多米尼加,228#New Zealand 新西兰,23#Macedonia马其顿共和国  2018年改为North Macedonia,70#Philippines菲律宾,28#Azerbaijan阿塞拜疆共和国(亚洲),131#Gambia冈比亚,132#Mali马里,159#Saint Helena圣赫勒拿（英国海外省）,133#Burkina Faso布基纳法索,59#China中国,91#Vietnam越南,61#South Korea韩国,62#Lebanon黎巴嫩,63#Nepal尼泊尔,64#Thailand泰国,65#Pakistan巴基斯坦,66#United Arab Emirates阿拉伯联合酋长国,67#Bhutan不丹,68#Oman阿曼,69#North Korea朝鲜,71#Cambodia柬埔寨,72#Qatar卡塔尔,73#Kyrgyzstan吉尔吉斯斯坦,74#Maldives马尔代夫,75#Malaysia马来西亚,76#Mongolia蒙古,77#Saudi Arabia沙特阿拉伯,78#Brunei文莱,79#Laos老挝,80#Japan日本,190#United States Virgin Islands美属维尔京群岛,191#British Virgin Islands英属维尔京群岛,192#Anguilla安圭拉（英国海外领土）,193#Antigua and Barbuda安提瓜和巴布达,194#Collectivité de Saint-Martin法属圣马丁（法国海外领土）,195#Autonomous country荷属圣马丁（荷兰王国的自治国）,196#Saint-Barthélemy圣巴泰勒米岛（法国海外领土）,197#Saint Kitts and Nevis圣基茨和尼维斯,198#Montserrat蒙特塞拉特（英国海外领土）,199#Guadeloupe瓜德罗普（法国海外领土）,200#Dominica多米尼克,201#Martinique马提尼克（法国海外领土）,202#St. Lucia圣卢西亚,203#Saint Vincent and the Grenadines圣文森特和格林纳丁斯,204#Grenada格林纳达,205#Barbados巴巴多斯,206#Trinidad and Tobago特立尼达和多巴哥,207#Cura?ao库拉索（荷兰王国的一个自治国）,0#Unsupported算法库不支持牌识国家,1#Czech Republic捷克共和国,2#France法国,3#Germany德国,4#Spain西班牙,5#Italy意大利,6#Netherlands荷兰,7#Poland波兰,8#Slovakia斯洛伐克,9#Belarus白俄罗斯,10#Moldova摩尔多瓦,11#Russia俄罗斯,12#Ukraine乌克兰,13#Belgium比利时,14#Bulgaria保加利亚,15#Denmark丹麦,16#Finland芬兰,18#Greece希腊,19#Croatia克罗地亚,20#Hungary匈牙利,21#Israel以色列(亚洲),22#Luxembourg卢森堡,24#Norway挪威,25#Portuga葡萄牙,26#Romania罗马尼亚,211#Venezuela委内瑞拉,212#Guyana圭亚那,213#Suriname苏里南,214#Guyane Francaise法属圭亚那,215#Ecuador厄瓜多尔,216#Peru秘鲁,217#Bolivia玻利维亚,218#Paraguay巴拉圭,219#Chile智利,220#Brazil巴西,221#Uruguay乌拉圭,222#Argentina阿根廷,223#Reserved保留字段,224#Reserved保留字段,225#Reserved保留字段,226#Reserved保留字段,229#Papua New Guinea巴布亚新几内亚,230#Salomonen所罗门群岛,231#Vanuatu瓦努阿图,232#New Caledonia新喀里多尼亚（法国的海外属地）,233#Palau帕劳,234#Federated States of Micronesia密克罗尼西亚联邦,235#Marshall Island马绍尔群岛,236#Northern Mariana Islands北马里亚纳群岛（美国的海外属地）,237#Guam关岛（美国的海外属地）,238#Nauru瑙鲁,239#Kiribati基里巴斯,240#Fidschi斐济群岛,241#Tonga汤加,242#Tuvalu图瓦卢,243#Wallis et Futuna瓦利斯和富图纳（法国的海外属地）,244#Samoa萨摩亚,245#Eastern Samoa美属萨摩亚,246#Tokelau托克劳（新西兰）,33#Uzbekistan乌兹别克斯坦(亚洲),34#Latvia拉脱维亚,35#Estonia爱沙尼亚,36#Albania阿尔巴尼亚,37#Austria奥地利,38#Bosnia and Herzegovina波斯尼亚和黑塞哥维那,39#Ireland爱尔兰,40#Iceland冰岛,41#Vatican梵蒂冈,42#Malta马耳他,43#Sweden瑞典,44#Switzerland瑞士,45#Cyprus塞浦路斯,46#Turkey土耳其,47#Slovenia斯洛文尼亚,48#Montenegro黑山共和国,49#Kosovo科索沃,50#Andorra安道尔,51#Armenia亚美尼亚(亚洲),52#Monaco摩纳哥,53#Liechtenstein列支敦士登,54#San Marino圣马力诺,55#Reserved保留字段,56#Reserved保留字段,90#Iraq伊拉克,57#Reserved保留字段,58#Reserved保留字段,247#Niue纽埃（新西兰）,248#Cook Islands库克群岛（新西兰）,249#French Polynesia法属波利尼西亚,250#Pitcairn Islands皮特凯恩群岛（英国的海外属地）,251#Hawaii State夏威夷（美国的海外属地）,252#Reserved保留字段,254#Unrecognized无法识别,255#ALL全部,256#Taiwan (China) 台湾（中国）,104#Egypt埃及,105#Libya利比亚,106#Sudan苏丹,107#Tunisia突尼斯,108#Algeria阿尔及利亚,109#Morocco摩洛哥,110#Ethiopia埃塞俄比亚,111#Eritrea厄立特里亚,112#Somalia Democratic索马里,113#Djibouti吉布提,114#Kenya肯尼亚,115#Tanzania坦桑尼亚,116#Uganda乌干达,117#Rwanda卢旺达,118#Burundi布隆迪,119#Seychelles塞舌尔,120#Chad乍得,121#Central African中非,122#Cameroon喀麦隆,123#Equatorial Guinea赤道几内亚,124#Gabon加蓬,125#Congo刚果共和国（即：刚果（布））,126#Democratic Republic of the Congo刚果民主共和国（即：刚果（金））,127#Sao Tome and Principe圣多美和普林西比,128#Mauritania毛里塔尼亚,129#Western Sahara西撒哈拉（撒拉威）,130#Senegal塞内加尔,208#Aruba阿鲁巴（荷兰王国的一个自治国）,209#Netherlands Antilles荷属安的列斯,210#Colombia哥伦比亚], desc:设备兼容：为了兼容老用户，新老字段都有返回，当值为CRIndex<=255时，countryIndex取值和CRIndex相同，当CRIndex>255时,countryIndex字段取值为253（该字段无效，需要使用CRIndex字段）；集成流程：新用户如果能力中有CRIndex字段，优先使用CRIndex，如果能力中没有，则使用countryIndex。  老用户只集成了countryIndex，如果遇到countryIndex为253时，需要增加处理逻辑，使用CRIndex字段；-->258\n" +
                "    </CRIndex>\n" +
                "    <VehicelGPSInfo>\n" +
                "      <!--ro, opt, object, 车辆GPS位置信息-->\n" +
                "      <longitudeType>\n" +
                "        <!--ro, req, enum, W, subType:string, [E#东半球,W#西半球]-->E\n" +
                "      </longitudeType>\n" +
                "      <latitudeType>\n" +
                "        <!--ro, req, enum, N, subType:string, [S#南半球,N#北半球]-->S\n" +
                "      </latitudeType>\n" +
                "      <Longitude>\n" +
                "        <!--ro, req, object, 经度-->\n" +
                "        <degree>\n" +
                "          <!--ro, req, int, 度-->60\n" +
                "        </degree>\n" +
                "        <minute>\n" +
                "          <!--ro, req, int, 分, range:[0,59]-->59\n" +
                "        </minute>\n" +
                "        <sec>\n" +
                "          <!--ro, req, float, 秒, range:[0,59.999999]-->59.000000\n" +
                "        </sec>\n" +
                "      </Longitude>\n" +
                "      <Latitude>\n" +
                "        <!--ro, req, object, 纬度-->\n" +
                "        <degree>\n" +
                "          <!--ro, req, int, 度-->60\n" +
                "        </degree>\n" +
                "        <minute>\n" +
                "          <!--ro, req, int, 分, range:[0,59]-->59\n" +
                "        </minute>\n" +
                "        <sec>\n" +
                "          <!--ro, req, float, 秒, range:[0,59.999999], desc:精确到小数点后6位-->59.000000\n" +
                "        </sec>\n" +
                "      </Latitude>\n" +
                "    </VehicelGPSInfo>\n" +
                "    <vehiclePositionControl>\n" +
                "      <!--ro, opt, enum, 车辆布防, subType:string, [vehicleMonitor#车辆智能布防,manualVehicleMonitor#手动车辆布防,dailyVehicleMonitor#日常车辆布防], desc:vehicleMonitor-车辆智能布防(即通过PUT /ISAPI/Traffic/channels/<ID>/vehicleMonitor/<taskID>/startTask触发),manualVehicleMonitor-手动车辆布防(即通过PUT /ISAPI/Traffic/channels/<ID>/manualVehicleMonitor触发),-->dailyVehicleMonitor\n" +
                "    </vehiclePositionControl>\n" +
                "    <vehicleMonitorTaskID>\n" +
                "      <!--ro, opt, string, 车辆智能布防任务ID, range:[1,64], desc:创建任务时由上层下发给设备,上层确保ID唯一性,vehiclePositionControl=vehicleMonitor时返回-->test\n" +
                "    </vehicleMonitorTaskID>\n" +
                "    <vehicleListName>\n" +
                "      <!--ro, opt, string, 车辆名单名称, range:[0,128], desc:这个字段表示车辆归属于名单的名称描述-->test\n" +
                "    </vehicleListName>\n" +
                "    <vehicleThermometryEnabled>\n" +
                "      <!--ro, opt, bool, 车辆测温使能-->true\n" +
                "    </vehicleThermometryEnabled>\n" +
                "    <currTemperature>\n" +
                "      <!--ro, opt, float, 温度-->36.5\n" +
                "    </currTemperature>\n" +
                "    <thermometryUnit>\n" +
                "      <!--ro, opt, enum, 测温单位, subType:string, [celsius#摄氏度,fahrenheit#华氏度,kelvin#开尔文]-->celsius\n" +
                "    </thermometryUnit>\n" +
                "    <plateCategory>\n" +
                "      <!--ro, opt, string, 车牌附加信息, range:[0,8], desc:即中东车牌中车牌号码旁边的小字信息，(目前只有中东地区支持)-->test\n" +
                "    </plateCategory>\n" +
                "    <plateSize>\n" +
                "      <!--ro, opt, enum, 车牌尺寸, subType:int, [0#未知,1#short(中东车牌使用),2#long]-->1\n" +
                "    </plateSize>\n" +
                "    <isNeedVerification>\n" +
                "      <!--ro, opt, bool, 是否需要核验, desc:本节点当前仅应用于安检的人车核验一体机产品，用于通知平台本次人脸抓拍结果是否需要进行人车核验,默认false不核验-->true\n" +
                "    </isNeedVerification>\n" +
                "    <ISO-CR>\n" +
                "      <!--ro, opt, string, ISO 3166-1 标准国家和地区代码, desc:见协议字典(二位字母)-->CN\n" +
                "    </ISO-CR>\n" +
                "    <vehicelRectName>\n" +
                "      <!--ro, opt, string, 触发事件的车辆区域名称, range:[0,64]-->11\n" +
                "    </vehicelRectName>\n" +
                "    <rodeType>\n" +
                "      <!--ro, opt, enum, 道路类型, subType:string, [entrance#出入口,city#城市,custom#自定义,alarmInput#报警输入(通过线圈触发),post#卡口,publicSecurity#治安监控], desc:publicSecurity(治安监控：该模式下可以检测车辆比较混乱且没有车道线的场景，无需配置车道线)-->entrance\n" +
                "    </rodeType>\n" +
                "    <Custom>\n" +
                "      <!--ro, opt, object, 自定义参数, dep:and,{$.EventNotificationAlert.ANPR.rodeType,eq,custom}-->\n" +
                "      <direction>\n" +
                "        <!--ro, opt, enum, 目标方向, subType:string, [enter#进入,parkind#停靠,leave#离开]-->enter\n" +
                "      </direction>\n" +
                "    </Custom>\n" +
                "    <accelerationNoise>\n" +
                "      <!--ro, opt, object, 车辆恶意急加速产生噪音的行为（简称炸街）-->\n" +
                "      <startTime>\n" +
                "        <!--ro, req, datetime, 该行为开始时间-->1970-01-01T00:00:00+08:00\n" +
                "      </startTime>\n" +
                "      <endTime>\n" +
                "        <!--ro, req, datetime, 该行为结束时间-->1970-01-01T00:00:00+08:00\n" +
                "      </endTime>\n" +
                "      <noiseDecibel>\n" +
                "        <!--ro, req, float, 噪声分贝-->36.5\n" +
                "      </noiseDecibel>\n" +
                "    </accelerationNoise>\n" +
                "    <ADRNo>\n" +
                "      <!--ro, opt, string, 危险品标识码, range:[1,8]-->231965\n" +
                "    </ADRNo>\n" +
                "    <pilotmask>\n" +
                "      <!--ro, opt, enum, 机动车主驾驶是否戴口罩, subType:string, [unknown#未知,yes#戴,no#未戴]-->unknown\n" +
                "    </pilotmask>\n" +
                "    <vicepilotMask>\n" +
                "      <!--ro, opt, enum, 机动车副驾驶是否戴口罩, subType:string, [unknown#未知,yes#戴,no#未戴]-->unknown\n" +
                "    </vicepilotMask>\n" +
                "    <nonMotorMask>\n" +
                "      <!--ro, opt, enum, 非机动车驾驶员是否戴口罩, subType:string, [unknown#未知,yes#戴,no#未戴]-->unknown\n" +
                "    </nonMotorMask>\n" +
                "    <pedestrianMask>\n" +
                "      <!--ro, opt, enum, 行人是否戴口罩, subType:string, [unknown#未知,yes#戴,no#未戴]-->unknown\n" +
                "    </pedestrianMask>\n" +
                "  </ANPR>\n" +
                "  <UUID>\n" +
                "    <!--ro, opt, string, 通用唯一识别码, desc:车辆唯一标识,多次抓拍相同车辆,UUID值相同-->test\n" +
                "  </UUID>\n" +
                "  <picNum>\n" +
                "    <!--ro, opt, int, 图片数量-->2\n" +
                "  </picNum>\n" +
                "  <monitoringSiteID>\n" +
                "    <!--ro, opt, string, 监测点编号, desc:对应/ISAPI/System/Video/inputs/channels/<channelID>/cameraInfo中的<positionNum>字段; 部分交通设备使用/ISAPI/Traffic/channels/<channelID>/cameraInfo中的<positionNum>字段，该协议为交通抢球设备自定义协议后移交协议集成组，两条协议信息同步，集成平台和设备开发需注意兼容处理，新设备建议统一使用/ISAPI/System/Video/inputs/channels/<ID>/cameraInfo-->test\n" +
                "  </monitoringSiteID>\n" +
                "  <ePlateUUID>\n" +
                "    <!--ro, opt, string, 电子车牌关联ID, desc:与电子车牌关联ID,如果此节点不为空且有值,表示有关联的电子车牌-->test\n" +
                "  </ePlateUUID>\n" +
                "  <isDataRetransmission>\n" +
                "    <!--ro, opt, bool, 重传数据标记（由于网络异常等因素-->true\n" +
                "  </isDataRetransmission>\n" +
                "  <SceneInfo>\n" +
                "    <!--ro, opt, object, 场景信息-->\n" +
                "    <scenesID>\n" +
                "      <!--ro, opt, string, 场景ID[1-16]-->test\n" +
                "    </scenesID>\n" +
                "    <sceneName>\n" +
                "      <!--ro, opt, string, 场景名称, range:[0,128]-->test\n" +
                "    </sceneName>\n" +
                "    <PTZPos>\n" +
                "      <!--ro, opt, object, PTZ位置-->\n" +
                "      <elevation>\n" +
                "        <!--ro, opt, int, 仰角, range:[-900,2700]-->0\n" +
                "      </elevation>\n" +
                "      <azimuth>\n" +
                "        <!--ro, opt, int, 方位角, range:[0,3600]-->0\n" +
                "      </azimuth>\n" +
                "      <absoluteZoom>\n" +
                "        <!--ro, opt, int, 变倍倍率, range:[0,1000]-->1\n" +
                "      </absoluteZoom>\n" +
                "    </PTZPos>\n" +
                "  </SceneInfo>\n" +
                "  <monitorDescription>\n" +
                "    <!--ro, opt, string, 监控点信息, range:[0,256], desc:对应/ISAPI/System/Video/inputs/channels/<ID>/cameraInfo中positionInfo字段;部分交通设备使用/ISAPI/Traffic/channels/<channelID>/cameraInfo中的<positionInfo>字段，该协议为交通抢球设备自定义协议后移交协议集成组，两条协议信息同步，集成平台和设备开发需注意兼容处理，新设备建议统一使用/ISAPI/System/Video/inputs/channels/<ID>/cameraInfo-->test\n" +
                "  </monitorDescription>\n" +
                "  <DeviceGPSInfo>\n" +
                "    <!--ro, opt, object, 设备GPS位置信息-->\n" +
                "    <longitudeType>\n" +
                "      <!--ro, req, enum, W, subType:string, [E#东半球,W#西半球]-->E\n" +
                "    </longitudeType>\n" +
                "    <latitudeType>\n" +
                "      <!--ro, req, enum, N, subType:string, [S#南半球,N#北半球]-->S\n" +
                "    </latitudeType>\n" +
                "    <Longitude>\n" +
                "      <!--ro, req, object, 经度-->\n" +
                "      <degree>\n" +
                "        <!--ro, req, int, 度-->60\n" +
                "      </degree>\n" +
                "      <minute>\n" +
                "        <!--ro, req, int, 分, range:[0,59]-->59\n" +
                "      </minute>\n" +
                "      <sec>\n" +
                "        <!--ro, req, float, 秒, range:[0,59.999999]-->59.000000\n" +
                "      </sec>\n" +
                "    </Longitude>\n" +
                "    <Latitude>\n" +
                "      <!--ro, req, object, 纬度-->\n" +
                "      <degree>\n" +
                "        <!--ro, req, int, 度-->60\n" +
                "      </degree>\n" +
                "      <minute>\n" +
                "        <!--ro, req, int, 分, range:[0,59]-->59\n" +
                "      </minute>\n" +
                "      <sec>\n" +
                "        <!--ro, req, float, 秒, range:[0,59.999999], desc:精确到小数点后6位-->59.000000\n" +
                "      </sec>\n" +
                "    </Latitude>\n" +
                "  </DeviceGPSInfo>\n" +
                "  <pilotStandardSafebelt>\n" +
                "    <!--ro, opt, enum, 主驾驶是否规范系安全带, subType:string, [unknown#未知,yes#是,no#否]-->yes\n" +
                "  </pilotStandardSafebelt>\n" +
                "  <vicepilotStandardSafebelt>\n" +
                "    <!--ro, opt, enum, 副驾驶是否规范系安全带, subType:string, [unknown#未知,yes#是,no#否]-->yes\n" +
                "  </vicepilotStandardSafebelt>\n" +
                "  <trafficLightSnap>\n" +
                "    <!--ro, opt, enum, 是否为红绿灯抓拍, subType:string, [yes#是,no#否]-->yes\n" +
                "  </trafficLightSnap>\n" +
                "  <sequence>\n" +
                "    <!--ro, opt, int, 网络触发连拍车辆抓拍序号, range:[1,4294967295], desc:由网络触发连拍控制命令下发,isapi协议为：/ISAPI/Traffic/startRecognition;SDK接口为：NET_DVR_ContinuousShoot-->0\n" +
                "  </sequence>\n" +
                "  <relaLaneDirectionType>\n" +
                "    <!--ro, opt, enum, 关联车道的方向, subType:int, [0#其它,1#从东向西,2#从西向东,3#从南向北,4#从北向南,5#从东南向西北,6#从西北向东南,7#从东北向西南,8#从西南向东北], desc:这是相机关联车道的方向，一个相机存在检测多个不同行驶方向车道的情况,与detectDir这个是相机安装架设的监控角度方向无关-->1\n" +
                "  </relaLaneDirectionType>\n" +
                "  <carDirectionType>\n" +
                "    <!--ro, opt, enum, 车辆具体在车道上行驶的方向, subType:int, [0#表示从上往下,1#表示从下往上], desc:车辆具体在车道上行驶的方向,与detectDir这个是相机安装架设的监控角度方向无关-->1\n" +
                "  </carDirectionType>\n" +
                "  <targetID>\n" +
                "    <!--ro, opt, string, 车辆目标ID, range:[1,64], desc:UUID,由设备确保唯一性,对应SDK私有协议dwMatchNo-->test\n" +
                "  </targetID>\n" +
                "  <isSecondCamera>\n" +
                "    <!--ro, opt, bool, 是否第二相机抓拍, desc:如交通远近景抓拍机中的远景相机，或前后抓拍机中的后相机，特殊相机中会用到-->false\n" +
                "  </isSecondCamera>\n" +
                "  <dataAnalysisType>\n" +
                "    <!--ro, opt, enum, 数据分析类型, subType:int, [0#数据未分析,1#数据已分析]-->1\n" +
                "  </dataAnalysisType>\n" +
                "  <RecordInfo>\n" +
                "    <!--ro, opt, object, 车辆小视频信息-->\n" +
                "    <fileName>\n" +
                "      <!--ro, req, enum, 小视频名称, subType:string, [record.mp4#车辆小视频], desc:2进制传输时，该名称必须和Content-ID值保持一致-->record.mp4\n" +
                "    </fileName>\n" +
                "    <dataType>\n" +
                "      <!--ro, req, enum, 数据类型, subType:int, [0#二机制,1#URL]-->0\n" +
                "    </dataType>\n" +
                "    <URL>\n" +
                "      <!--ro, opt, string, URL, desc:当<dataType> ==URL时生效-->test\n" +
                "    </URL>\n" +
                "  </RecordInfo>\n" +
                "  <VehicleWeightInfo>\n" +
                "    <!--ro, opt, object, 车辆称重信息, desc:当前只有称重数据管理服务器才支持-->\n" +
                "    <isOverWeight>\n" +
                "      <!--ro, opt, bool, 是否超重, desc:可通过/ISAPI/Traffic/channels/<channelID>/vehicleWeight/capabilities?format=json中illegalPriorityType配置优先上报超重还是超限-->false\n" +
                "    </isOverWeight>\n" +
                "    <axleNum>\n" +
                "      <!--ro, opt, int, 轴数, range:[1,10]-->4\n" +
                "    </axleNum>\n" +
                "    <axleModel>\n" +
                "      <!--ro, opt, enum, 轴数模式, subType:int, [0#未知,512#2轴载货汽车,765#3轴中置轴挂车列车,766#3轴铰接列车,767#3轴载货汽车,768#3轴载货汽车,1024#4轴中置轴挂车列车125型号,1025#4轴中置轴挂车列车152型号,1026#4轴铰接列车,1027#4轴全挂汽车列车,1028#4轴载货汽车,1280#5轴中置轴挂车列车155型号,1281#5轴中置轴挂车列车1125型号,1282#5轴铰链列车155型号,1283#5轴铰链列车1125型号,1284#5轴铰链列车129型号,1285#5轴全挂汽车列车1522型号,1286#5轴全挂汽车列车11222型号,1536#6轴中置轴挂车列车159型号,1537#6轴中置轴挂车列车159-2型号,1538#6轴中置轴挂车列车1155-1型号,1539#6轴中置轴挂车列车1155-2型号,1540#6轴铰链列车159-3型号,1541#6轴铰链列车159-4型号,1542#6轴铰链列车1129型号,1543#6轴全挂车11522-1型号,1544#6轴全挂车11522-2型号]-->0\n" +
                "    </axleModel>\n" +
                "    <overWeight>\n" +
                "      <!--ro, opt, float, 超限重量(吨), range:[0.000,100.000], unit:吨, desc:保留三位小数点-->4.502\n" +
                "    </overWeight>\n" +
                "    <weight>\n" +
                "      <!--ro, opt, float, 车身重量(吨), range:[0.000,100.000], unit:吨, desc:保留三位小数点-->4.502\n" +
                "    </weight>\n" +
                "    <limitWeight>\n" +
                "      <!--ro, opt, float, 限制重量(吨), range:[0.000,100.000], unit:吨, desc:保留三位小数点-->4.502\n" +
                "    </limitWeight>\n" +
                "    <axleLen>\n" +
                "      <!--ro, opt, float, 轴距(米), range:[0.00,100.00], unit:吨, desc:保留二位小数点-->4.502\n" +
                "    </axleLen>\n" +
                "    <devDescInfo>\n" +
                "      <!--ro, opt, string, 设备描述信息, range:[0,64]-->test\n" +
                "    </devDescInfo>\n" +
                "    <AxleInfoList>\n" +
                "      <!--ro, opt, object, 车轴信息列表, desc:个数对应axleNum-->\n" +
                "      <AxleInfo>\n" +
                "        <!--ro, opt, object, 单个车轴信息-->\n" +
                "        <axleWeight>\n" +
                "          <!--ro, opt, float, 车轴重量, range:[0.00,10000.00], unit:kg-->100.00\n" +
                "        </axleWeight>\n" +
                "        <axleDistance>\n" +
                "          <!--ro, opt, int, 车轴间距, range:[0,100000], unit:mm, desc:当前车轴到下一个车轴的距离-->30000\n" +
                "        </axleDistance>\n" +
                "      </AxleInfo>\n" +
                "    </AxleInfoList>\n" +
                "    <length>\n" +
                "      <!--ro, opt, int, 车长, range:[1,1000000], unit:cm-->4000\n" +
                "    </length>\n" +
                "    <width>\n" +
                "      <!--ro, opt, int, 车宽, range:[1,1000000], unit:cm-->4000\n" +
                "    </width>\n" +
                "    <height>\n" +
                "      <!--ro, opt, int, 车高, range:[1,1000000], unit:cm-->4000\n" +
                "    </height>\n" +
                "    <tollwayVehicleType>\n" +
                "      <!--ro, opt, enum, 收费公路车型, subType:int, [0#未知,1#1类客车微型,2#1类客车小型,3#2类客车中型,4#2类客车乘用车列车,5#3类客车大型,6#4类客车大型,7#1类货车2轴,8#2类货车2轴,9#3类货车3轴,10#4类货车4轴,11#5类货车5轴,12#6类货车6轴,13#1类作业车2轴,14#2类作业车2轴,15#3类作业车3轴,16#4类作业车4轴,17#5类作业车5轴,18#6类作业车大于等于6轴]-->1\n" +
                "    </tollwayVehicleType>\n" +
                "    <tiresNum>\n" +
                "      <!--ro, opt, int, 轮胎个数, range:[1,20]-->4\n" +
                "    </tiresNum>\n" +
                "    <approvedPassengers>\n" +
                "      <!--ro, opt, int, 核定载人数, range:[1,100]-->7\n" +
                "    </approvedPassengers>\n" +
                "    <limitLength>\n" +
                "      <!--ro, opt, int, 限制车长, range:[1,1000000], unit:cm, desc:可通过/ISAPI/Traffic/channels/<channelID>/vehicleWeight/capabilities?format=json配置-->4000\n" +
                "    </limitLength>\n" +
                "    <limitWidth>\n" +
                "      <!--ro, opt, int, 限制车宽, range:[1,1000000], unit:cm, desc:可通过/ISAPI/Traffic/channels/<channelID>/vehicleWeight/capabilities?format=json配置-->4000\n" +
                "    </limitWidth>\n" +
                "    <limitHeight>\n" +
                "      <!--ro, opt, int, 限制车高, range:[1,1000000], unit:cm, desc:可通过/ISAPI/Traffic/channels/<channelID>/vehicleWeight/capabilities?format=json配置-->4000\n" +
                "    </limitHeight>\n" +
                "    <overLength>\n" +
                "      <!--ro, opt, int, 超限车长, range:[1,1000000], unit:cm, desc:超过限制的这部分值,等于实际车长length减去长度限制值limitLength-->4000\n" +
                "    </overLength>\n" +
                "    <overWidth>\n" +
                "      <!--ro, opt, int, 超限车宽, range:[1,1000000], unit:cm, desc:超过限制的这部分值,等于实际车宽width减去宽度限制值limitWidth-->4000\n" +
                "    </overWidth>\n" +
                "    <overHeight>\n" +
                "      <!--ro, opt, int, 超限车高, range:[1,1000000], unit:cm, desc:超过限制的这部分值,等于实际车高height减去高度限制值limitHeight-->4000\n" +
                "    </overHeight>\n" +
                "    <isOverLimit>\n" +
                "      <!--ro, opt, bool, 是否超限, desc:可通过/ISAPI/Traffic/channels/<channelID>/vehicleWeight/capabilities?format=json中illegalPriorityType配置优先上报超重还是超限-->false\n" +
                "    </isOverLimit>\n" +
                "    <axleNumConfidence>\n" +
                "      <!--ro, opt, int, 抓拍的轮轴数置信度, range:[0,100]-->0\n" +
                "    </axleNumConfidence>\n" +
                "  </VehicleWeightInfo>\n" +
                "  <isNotSlowZebraCrossing>\n" +
                "    <!--ro, opt, bool, 车辆是否斑马线未减速-->false\n" +
                "  </isNotSlowZebraCrossing>\n" +
                "  <isTurnRightStop>\n" +
                "    <!--ro, opt, bool, 车辆是否右转不停车-->false\n" +
                "  </isTurnRightStop>\n" +
                "  <PlateInfoList>\n" +
                "    <!--ro, opt, object, 支持三地车牌等多车牌时返回（包括港、澳车牌、欧洲ADR车牌）-->\n" +
                "    <PlateInfo>\n" +
                "      <!--ro, opt, object, 单一车牌信息-->\n" +
                "      <plateRect>\n" +
                "        <!--ro, opt, object, 车牌区域坐标, desc:当type=detectionPicture时生效;归一化,数值为当前画面的千分比大小*1000，屏幕左上角为坐标原点-->\n" +
                "        <X>\n" +
                "          <!--ro, req, int, 边界框左上角点的X轴坐标, range:[0,1000]-->1000\n" +
                "        </X>\n" +
                "        <Y>\n" +
                "          <!--ro, req, int, 边界框左上角点的Y轴坐标, range:[0,1000]-->1000\n" +
                "        </Y>\n" +
                "        <width>\n" +
                "          <!--ro, req, int, 边界框的宽度, range:[0,1000]-->1000\n" +
                "        </width>\n" +
                "        <height>\n" +
                "          <!--ro, req, int, 边界框的高度, range:[0,1000]-->1000\n" +
                "        </height>\n" +
                "      </plateRect>\n" +
                "      <plateColor>\n" +
                "        <!--ro, req, enum, 车牌颜色, subType:string, [black#黑色,blue#蓝色,golden#金色,orange#橙色,red#红色,yellow#黄色,white#白色,unknown#未知,other#其他颜色,newEnergyYellowGreen#新能源黄绿色,civilAviationBlack#民航黑色,civilAviationGreen#民航绿色,green#绿色,mixedColor#花底,newEnergyGreen#新能源绿色]-->black\n" +
                "      </plateColor>\n" +
                "      <licensePlate>\n" +
                "        <!--ro, req, string, 车牌号码, range:[1,32], desc:noPlate-表示识别出无车牌车辆；unknown-表示未识别出车牌；具体车牌号字符串-例如，中文车牌蓝浙AX2P12 （需要带车牌颜色），海外车牌A283KY77（不需要带上车牌颜色）-->A283KY77\n" +
                "      </licensePlate>\n" +
                "      <confidenceLevel>\n" +
                "        <!--ro, req, int, 置信度等级, range:[0,100]-->50\n" +
                "      </confidenceLevel>\n" +
                "      <province>\n" +
                "        <!--ro, opt, enum, 中国省份索引, subType:int, [0#保留,1#澳,10#冀,11#豫,12#黑,13#鄂,14#湘,15#吉,16#苏,17#赣,18#辽,19#蒙,2#京,20#宁,21#青,22#鲁,23#晋,24#陕,25#沪,255#全部,26#川,27#台,28#津,29#藏,3#渝,30#港,31#新,32#云,33#浙,34#皖,4#闽,5#甘,6#粤,7#桂,8#贵,9#琼]-->0\n" +
                "      </province>\n" +
                "    </PlateInfo>\n" +
                "  </PlateInfoList>\n" +
                "  <deviceUUID>\n" +
                "    <!--ro, opt, string, 设备编号, range:[1,32], desc:设备唯一标识，默认值为设备序列号，可通过协议/ISAPI/System/deviceInfo中的<deviceID>字段进行编辑修改-->12345\n" +
                "  </deviceUUID>\n" +
                "  <VehicleGATInfo>\n" +
                "    <!--ro, opt, object, 机动车国标定义信息, desc:国标定义对应参考资料：GAT833-2016-《机动车号牌图像自动识别技术规范》-->\n" +
                "    <palteTypeByGAT>\n" +
                "      <!--ro, opt, enum, 国标车牌类型, subType:int, [1#大型汽车,2#小型汽车,25#农机号牌,41#无号牌,42#假号牌,44#无法识别号牌种类,99#其它号牌], desc:符合GA/T 16.7-->1\n" +
                "    </palteTypeByGAT>\n" +
                "    <plateColorByGAT>\n" +
                "      <!--ro, opt, enum, 国标车牌颜色, subType:int, [0#白色,1#黄色,2#蓝色,3#黑色,4#绿色,5#未识别,9#其他]-->0\n" +
                "    </plateColorByGAT>\n" +
                "    <vehicleTypeByGAT>\n" +
                "      <!--ro, opt, enum, 国标车辆类型, subType:string, [K10#大型客车,K20#中型客车,K30#小型客车,K33#小型轿车,H10#重型货车,H20#中型货车,H30#轻型货车,M10#三轮摩托车,M20#两轮摩托车,X99#其它], desc:符合GA/T 16.4-->K10\n" +
                "    </vehicleTypeByGAT>\n" +
                "    <colorByGAT>\n" +
                "      <!--ro, opt, enum, 国标车辆颜色, subType:string, [A#白,B#灰,C#黄,D#粉,E#红,F#紫,G#绿,H#蓝,I#棕,J#黑,K#未识别,Z#其他], desc:符合GA/T 16.8-->A\n" +
                "    </colorByGAT>\n" +
                "  </VehicleGATInfo>\n" +
                "  <EPlateInfo>\n" +
                "    <!--ro, opt, object, RFID检测结果-->\n" +
                "    <EPlateChipNo>\n" +
                "      <!--ro, opt, string, 电子车牌芯片号(RFID检测结果), range:[0,16]-->E855000011F9AAA5\n" +
                "    </EPlateChipNo>\n" +
                "    <EPlateCardNo>\n" +
                "      <!--ro, opt, string, 电子车牌卡号(RFID检测结果), range:[0,12], desc:电子车牌卡号,12位,前两位为省份代码-->E855000011F9AAA5\n" +
                "    </EPlateCardNo>\n" +
                "    <EPlateNo>\n" +
                "      <!--ro, opt, string, 车牌号码(RFID检测结果), range:[0,32], desc:noPlate：识别出无车牌车辆；unknown：未识别出车牌；临时车牌：抚州临时12345；-->浙A12345\n" +
                "    </EPlateNo>\n" +
                "    <EPlateManufacturingDate>\n" +
                "      <!--ro, opt, string, 出厂日期(RFID检测结果), range:[0,7], desc:出厂日期,格式为yyyy-MM-->2014-01\n" +
                "    </EPlateManufacturingDate>\n" +
                "    <EPlateInspectionValidity>\n" +
                "      <!--ro, opt, string, 检验有效期(RFID检测结果), range:[0,7], desc:检验有效期,精确到月,格式为yyyy-MM-->2014-01\n" +
                "    </EPlateInspectionValidity>\n" +
                "    <EPlateMandaScrapPeriod>\n" +
                "      <!--ro, opt, int, 强制报废时间(RFID检测结果), range:[0,100], unit:年, desc:从检验有效期开始到强制报废的时间（年）-->10\n" +
                "    </EPlateMandaScrapPeriod>\n" +
                "    <EPlatePassengersCapacity>\n" +
                "      <!--ro, opt, int, 核定载客量(RFID检测结果), range:[0,100], desc:核定载客量,例如1-->1\n" +
                "    </EPlatePassengersCapacity>\n" +
                "    <EPlateCarryingCapacity>\n" +
                "      <!--ro, opt, float, 总牵引质量, range:[0,100], unit:吨, desc:总牵引质量,单位吨（千千克）-->2.0\n" +
                "    </EPlateCarryingCapacity>\n" +
                "    <EPlateVehicleColor>\n" +
                "      <!--ro, opt, enum, 车身颜色(RFID检测结果), subType:string, [unknown#未知,white#白,silver#银,gray#灰,black#黑,red#红,deepBlue#深蓝,blue#蓝,yellow#黄,green#绿,brown#棕,pink#粉,purple#紫,deepGray#深灰,cyan#青,orange#橙]-->black\n" +
                "    </EPlateVehicleColor>\n" +
                "    <EPlateNonMotorType>\n" +
                "      <!--ro, opt, enum, 非机动车辆类型(RFID检测结果), subType:string, [unknown#未知,threeWheelVehicle#三轮车,twoWheelVehicle#二轮车]-->threeWheelVehicle\n" +
                "    </EPlateNonMotorType>\n" +
                "    <EPlateNonMotorPlateType>\n" +
                "      <!--ro, opt, enum, 非机动车车牌类型(RFID检测结果), subType:string, [unknown#未知,temporary#临时车牌,normal#正常车牌]-->unknown\n" +
                "    </EPlateNonMotorPlateType>\n" +
                "    <EPlateColor>\n" +
                "      <!--ro, opt, enum, 车牌颜色(RFID检测结果), subType:string, [black#黑色,blue#蓝色,golden#金色,orange#橙色,red#红色,yellow#黄色,white#白色,unknown#未知,other#其他颜色,newEnergyYellowGreen#新能源黄绿色,civilAviationBlack#民航黑色,civilAviationGreen#民航绿色,green#绿色,mixedColor#花底,newEnergyGreen#新能源绿色,brown#棕色]-->black\n" +
                "    </EPlateColor>\n" +
                "    <EPlateUseType>\n" +
                "      <!--ro, opt, enum, 非机动车使用性质(RFID检测结果), subType:string, [unknown#未知,nonOperating#非营运,takeOut#外卖,express#快递]-->nonOperating\n" +
                "    </EPlateUseType>\n" +
                "    <EPlateTriggerTime>\n" +
                "      <!--ro, req, datetime, 电子车牌设备检测触发时间(RFID检测结果)-->1970-01-01T00:00:00+08:00\n" +
                "    </EPlateTriggerTime>\n" +
                "    <EPlateListenAuthCode>\n" +
                "      <!--ro, opt, string, 电子车牌发牌代号(RFID检测结果)-->粤B\n" +
                "    </EPlateListenAuthCode>\n" +
                "  </EPlateInfo>\n" +
                "  <accelerationNoise>\n" +
                "    <!--ro, opt, object, 车辆恶意急加速产生噪音的行为（简称炸街）-->\n" +
                "    <isExistsAccelerationNoise>\n" +
                "      <!--ro, req, bool, 是否存在车辆恶意急加速产生噪音的行为（简称炸街）-->true\n" +
                "    </isExistsAccelerationNoise>\n" +
                "    <startTime>\n" +
                "      <!--ro, req, datetime, 该行为开始时间, desc:精确到毫秒-->1970-01-01T00:00:00.000+08:00\n" +
                "    </startTime>\n" +
                "    <endTime>\n" +
                "      <!--ro, req, datetime, 该行为结束时间, desc:精确到毫秒-->1970-01-01T00:00:00.000+08:00\n" +
                "    </endTime>\n" +
                "  </accelerationNoise>\n" +
                "  <noiseDecibel>\n" +
                "    <!--ro, opt, float, 车辆行驶的噪声分贝, range:[0,300], unit:分贝, desc:保留一位小数点-->65.5\n" +
                "  </noiseDecibel>\n" +
                "  <exhaustPipeNum>\n" +
                "    <!--ro, opt, int, 车辆排气管数量, range:[0,4]-->2\n" +
                "  </exhaustPipeNum>\n" +
                "  <exhaustPipePositionType>\n" +
                "    <!--ro, opt, enum, 车辆排气管安装位置类型, subType:string, [unilateral#单侧,bilateral#双侧,middle#中间]-->unilateral\n" +
                "  </exhaustPipePositionType>\n" +
                "  <openGateType>\n" +
                "    <!--ro, opt, enum, 开闸原因类型, subType:string, [white#授权名单情况下设备自动放行,manual#平台手动放行,abnormal#异常情况下设备自动放行], dep:and,{$.EventNotificationAlert.ANPR.barrierGateCtrlType,eq,0}-->white\n" +
                "  </openGateType>\n" +
                "  <plateStandardStatus>\n" +
                "    <!--ro, opt, enum, 车牌状态是否规范, subType:string, [yes#是,no#否]-->yes\n" +
                "  </plateStandardStatus>\n" +
                "  <limitSurfaceSpeed>\n" +
                "    <!--ro, opt, int, 设备监测断面限速值（超速违法必填）, range:[0,255], unit:km/h, unitType:速度-->1\n" +
                "  </limitSurfaceSpeed>\n" +
                "  <startCaptureSpeed>\n" +
                "    <!--ro, opt, int, 设备监测起拍速度值（超速违法必填）, range:[0,255], unit:km/h, unitType:速度-->1\n" +
                "  </startCaptureSpeed>\n" +
                "  <redlightIllegalCode>\n" +
                "    <!--ro, opt, string, 闯红灯违法信号灯车道匹配代码, range:[0,4], desc:0-全部车道；1-左转；2-直行；3-右转；4-直左混行；5-直右混行-->1\n" +
                "  </redlightIllegalCode>\n" +
                "  <redlightSignalStartTime>\n" +
                "    <!--ro, opt, string, 信号灯红灯开始时间（闯红灯违法必填）, desc:ISO8601格式： YYYY-MM-DD'T'hh:mm:ss+zone 例2017-08-01T17:30:08+08:00-->\"2004-05-03T17:30:08+08:00\"\n" +
                "  </redlightSignalStartTime>\n" +
                "  <redlightSignalEndTime>\n" +
                "    <!--ro, opt, string, 信号灯红灯结束时间（闯红灯违法必填）, desc:ISO8601格式： YYYY-MM-DD'T'hh:mm:ss+zone 例2017-08-01T17:30:08+08:00-->\"2004-05-03T17:30:08+08:00\"\n" +
                "  </redlightSignalEndTime>\n" +
                "  <trafficControlTimeSpanList>\n" +
                "    <!--ro, opt, array, 分时段限行违法限行时间, subType:object-->\n" +
                "    <TimeRange>\n" +
                "      <!--ro, req, object, 时间段-->\n" +
                "      <beginTime>\n" +
                "        <!--ro, req, time, 开始时间-->10:00:00\n" +
                "      </beginTime>\n" +
                "      <endTime>\n" +
                "        <!--ro, req, time, 结束时间-->10:00:00\n" +
                "      </endTime>\n" +
                "    </TimeRange>\n" +
                "  </trafficControlTimeSpanList>\n" +
                "  <detectionBackgroundImageResolution>\n" +
                "    <!--ro, opt, object, -ro, desc:对应ANPR.pictureInfoList.pictureInfo中fileName==detectionPicture.jpg且type==detectionPicture时pictureURL和pId所表示的图片。当ANPR.Rect节点、ANPR.pictureInfoList.pictureInfo.plateRect节点、ANPR.pictureInfoList.pictureInfo.vehicelRect节点、ANPR.PlateInfoList.PlateInfo.plateRect节点表示的归一化坐标转换成实际分辨率坐标时,需要依赖此节点-->\n" +
                "    <height>\n" +
                "      <!--ro, req, int, 分辨率高, range:[1,65535], unit:px, unitType:图像显示-->1\n" +
                "    </height>\n" +
                "    <width>\n" +
                "      <!--ro, req, int, 分辨率宽, range:[1,65535], unit:px, unitType:图像显示-->1\n" +
                "    </width>\n" +
                "  </detectionBackgroundImageResolution>\n" +
                "  <trafficSurveyVehicleType>\n" +
                "    <!--ro, opt, enum, 公路交通情况调查设备协议车辆类型, subType:int, [0#未知,1#中小客车,2#大客车,3#小型货车,4#中型货车,5#大型货车,6#特大型货车,7#集装箱车,8#摩托车,9#拖拉机]-->1\n" +
                "  </trafficSurveyVehicleType>\n" +
                "</EventNotificationAlert>\n");
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
