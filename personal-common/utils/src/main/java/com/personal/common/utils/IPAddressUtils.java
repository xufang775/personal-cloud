package com.personal.common.utils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/29.
 */
public class IPAddressUtils {
    /**
     * 根据ip获得该ip的地区信息
     *
     * @param ip
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getAddressByIp(String ip) throws UnsupportedEncodingException {

        if (StringUtils.isEmpty(ip)) {
            return "";
        }

        String encodingString = "utf-8";

        return getAddresses("ip=" + ip, encodingString);
    }

    /**
     * 根据ip获得该ip的地区信息
     * @param ip
     * @param encodingString
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getAddressByIp(String ip, String encodingString) throws UnsupportedEncodingException {

        if (StringUtils.isEmpty(ip)) {
            return "";
        }
        if (StringUtils.isEmpty(encodingString)) {
            encodingString = "utf-8";
        }

        return getAddresses("ip=" + ip, encodingString);
    }

    /**
     * @param content        请求的参数 格式为：name=xxx&pwd=xxx
     * @param encodingString 服务器端请求编码。如GBK,UTF-8等
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getAddresses(String content, String encodingString)
        throws UnsupportedEncodingException {
        // 这里调用taobao的接口
        String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
        // 从http://ip.taobao.com/取得IP所在的省市区信息
        String returnStr = getResult(urlStr, content, encodingString);
        if (returnStr != null) {
            // 处理返回的省市区信息
            //System.out.println(returnStr);
            String[] temp = returnStr.split(",");
            if (temp.length < 3) {
                return "0";//无效IP，局域网测试
            }
            String region = (temp[5].split(":"))[1].replaceAll("\"", "");
            region = decodeUnicode(region);// 省份

            String country = "";
            String area = "";
            String city = "";
            String county = "";
            String isp = "";
            for (int i = 0; i < temp.length; i++) {
                switch (i) {
                    case 1:
                        country = (temp[i].split(":"))[2].replaceAll("\"", "");
                        country = decodeUnicode(country);// 国家
                        break;
                    case 3:
                        area = (temp[i].split(":"))[1].replaceAll("\"", "");
                        area = decodeUnicode(area);// 地区
                        break;
                    case 5:
                        region = (temp[i].split(":"))[1].replaceAll("\"", "");
                        region = decodeUnicode(region);// 省份
                        break;
                    case 7:
                        city = (temp[i].split(":"))[1].replaceAll("\"", "");
                        city = decodeUnicode(city);// 市区
                        break;
                    case 9:
                        county = (temp[i].split(":"))[1].replaceAll("\"", "");
                        county = decodeUnicode(county);// 地区
                        break;
                    case 11:
                        isp = (temp[i].split(":"))[1].replaceAll("\"", "");
                        isp = decodeUnicode(isp); // ISP公司
                        break;
                }
            }

            Map<String, String> map = new HashMap<>();
            map.put("country", country);
            map.put("area", area);
            map.put("region", region);
            map.put("city", city);
            map.put("county", county);
            map.put("isp", isp);

            String resultJson = "";
            resultJson = JSON.toJSONString(map);
            return resultJson;
        }
        return null;
    }

    /**
     * @param urlStr   请求的地址
     * @param content  请求的参数 格式为：name=xxx&pwd=xxx
     * @param encoding 服务器端请求编码。如GBK,UTF-8等
     * @return
     */
    private static String getResult(String urlStr, String content, String encoding) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();// 新建连接实例
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(33000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();// 打开连接端口
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
            out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
            out.flush();// 刷新
            out.close();// 关闭输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
            // ,以BufferedReader流来读取
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();// 关闭连接
            }
        }
        return null;
    }

    /**
     * unicode 转换成 中文
     *
     * @param theString
     * @return
     * @author fanhui 2007-3-15
     */
    private static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Malformed   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't') {
                        aChar = '\t';
                    } else if (aChar == 'r') {
                        aChar = '\r';
                    } else if (aChar == 'n') {
                        aChar = '\n';
                    } else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    outBuffer.append(aChar);
                }
            } else {
                outBuffer.append(aChar);
            }
        }
        return outBuffer.toString();
    }
    /**
     * 获取真实IP地址
     * <p>使用getRealIP代替该方法</p>
     * @param request req
     * @return ip
     */
    @Deprecated
    public static String getClinetIpByReq(HttpServletRequest request) {
        // 获取客户端ip地址
        String clientIp = request.getHeader("x-forwarded-for");

        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
        /*
         * 对于获取到多ip的情况下，找到公网ip.
         */
        String sIP = null;
        if (clientIp != null && !clientIp.contains("unknown") && clientIp.indexOf(",") > 0) {
            String[] ipsz = clientIp.split(",");
            for (String anIpsz : ipsz) {
                if (!isInnerIP(anIpsz.trim())) {
                    sIP = anIpsz.trim();
                    break;
                }
            }
            /*
             * 如果多ip都是内网ip，则取第一个ip.
             */
            if (null == sIP) {
                sIP = ipsz[0].trim();
            }
            clientIp = sIP;
        }
        if (clientIp != null && clientIp.contains("unknown")){
            clientIp =clientIp.replaceAll("unknown,", "");
            clientIp = clientIp.trim();
        }
        if ("".equals(clientIp) || null == clientIp){
            clientIp = "127.0.0.1";
        }
        return clientIp;
    }

    /**
     * 判断IP是否是内网地址
     * @param ipAddress ip地址
     * @return 是否是内网地址
     */
    public static boolean isInnerIP(String ipAddress) {
        boolean isInnerIp;
        long ipNum = getIpNum(ipAddress);
        /**
         私有IP：A类  10.0.0.0-10.255.255.255
         B类  172.16.0.0-172.31.255.255
         C类  192.168.0.0-192.168.255.255
         当然，还有127这个网段是环回地址
         **/
        long aBegin = getIpNum("10.0.0.0");
        long aEnd = getIpNum("10.255.255.255");

        long bBegin = getIpNum("172.16.0.0");
        long bEnd = getIpNum("172.31.255.255");

        long cBegin = getIpNum("192.168.0.0");
        long cEnd = getIpNum("192.168.255.255");
        isInnerIp = isInner(ipNum, aBegin, aEnd) || isInner(ipNum, bBegin, bEnd) || isInner(ipNum, cBegin, cEnd)
            || ipAddress.equals("127.0.0.1");
        return isInnerIp;
    }

    private static long getIpNum(String ipAddress) {
        String[] ip = ipAddress.split("\\.");
        long a = Integer.parseInt(ip[0]);
        long b = Integer.parseInt(ip[1]);
        long c = Integer.parseInt(ip[2]);
        long d = Integer.parseInt(ip[3]);

        return a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
    }

    private static boolean isInner(long userIp, long begin, long end) {
        return (userIp >= begin) && (userIp <= end);
    }

    public static String getRealIP(HttpServletRequest request){
        // 获取客户端ip地址
        String clientIp = request.getHeader("x-forwarded-for");

        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }

        String[] clientIps = clientIp.split(",");
        if(clientIps.length <= 1) return clientIp.trim();

        // 判断是否来自CDN
        if(isComefromCDN(request)){
            if(clientIps.length>=2) return clientIps[clientIps.length-2].trim();
        }

        return clientIps[clientIps.length-1].trim();
    }

    private static boolean isComefromCDN(HttpServletRequest request) {
        String host = request.getHeader("host");
        return host.contains("www.189.cn") ||host.contains("shouji.189.cn") || host.contains(
            "image2.chinatelecom-ec.com") || host.contains(
            "image1.chinatelecom-ec.com");
    }
    // 测试
 //   public static void main(String[] args) {
//        IPAddressUtils addressUtils = new IPAddressUtils();
//        // 测试ip 58.209.121.6 中国-华东-江苏省-苏州市-电信
//        String ip = "111.198.52.87";
//        String address = "";
//        try {
//            address = addressUtils.getAddresses("ip=" + ip, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        System.out.println(address);
//        // 输出结果为：中国-华东-江苏省-苏州市-电信
  //  }
}
