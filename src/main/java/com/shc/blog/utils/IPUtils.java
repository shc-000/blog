package com.shc.blog.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


public class IPUtils {
	/**
     * 获取登录用户的IP地址
     * 
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /**
     * 通过IP获取地址(需要联网，调用淘宝的IP库)
     * 
     * @param ip
     * @return
     */
    public static String getIpInfo(String ip) {
        if (ip.equals("本地")) {
            ip = "127.0.0.1";
        }
        String info = "ip=\""+ip+"\";";
        String address ="";
        try {
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
            HttpURLConnection htpcon = (HttpURLConnection) url.openConnection();
            htpcon.setRequestMethod("GET");
            htpcon.setDoOutput(true);
            htpcon.setDoInput(true);
            htpcon.setUseCaches(false);

            InputStream in = htpcon.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            StringBuffer temp = new StringBuffer();
            String line = bufferedReader.readLine();
            while (line != null) {
                temp.append(line).append("\r\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            String jsonString = temp.toString();
            Pattern pattern = null;
    		Matcher matcher = null;
    		pattern = Pattern.compile("\"region\":\"([^\"]*)\"");
			matcher = pattern.matcher(jsonString);
			if(matcher.find()){
				String prov = matcher.group(1);
//				if(prov.isEmpty())prov="\\u8bf7\\u9009\\u62e9";
				info += "prov=\""+prov+"\";";
				address += decodeUnicode(prov)+":";
			}
			pattern = Pattern.compile("\"city\":\"([^\"]*)\"");
			matcher = pattern.matcher(jsonString);
			if(matcher.find()){
				String city = matcher.group(1);
				//if(city.isEmpty())city="\\u8bf7\\u9009\\u62e9";
				info += "city=\""+city+"\";";
				address += decodeUnicode(city);
			}
//            JSONObject obj = (JSONObject) JSON.parse(temp.toString());
//            if (obj.getIntValue("code") == 0) {
//                JSONObject data = obj.getJSONObject("data");
//                info += data.getString("country") + " ";
//                info += data.getString("region") + " ";
//                info += data.getString("city") + " ";
//                info += data.getString("isp");
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }
    
    public static String decodeUnicode(String utfString) { 
        StringBuilder sb = new StringBuilder();  
        int i = -1;  
        int pos = 0;  
        while((i=utfString.indexOf("\\u", pos)) != -1){  
            sb.append(utfString.substring(pos, i));  
            if(i+5 < utfString.length()){  
                pos = i+6;  
                sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));  
            }  
        }  
        return sb.toString();
    }
}
