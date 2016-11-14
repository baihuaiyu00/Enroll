package com.csxupt.cal.common;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

/**
 * Created by Admin on 2016/9/22.
 */
public class SocketUtil {

    // 获取cookie
    public static String getCookie(String LOGIN_URL) {
        String cookieValue = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 将每个用户的cookie与登录省份唯一绑定,用系统时间做key，cookie值做value
        try {
            HttpGet httpGet = new HttpGet(LOGIN_URL);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            Header[] headers = response.getAllHeaders();
            for (Header s : headers) {
                if (s.getName().equals("Set-Cookie")) {
                    cookieValue = s.getValue();
                }
            }
            if (cookieValue != null) {
                String[] strs = cookieValue.split(";");
                cookieValue = strs[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cookieValue;
    }

    public static boolean download(InputStream in,String path){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            byte b[] = new byte[1024];
            int j = 0;
            while ((j = in.read(b)) != -1) {
                out.write(b, 0, j);
            }
            out.flush();
            File file = new File(path);
            if(file.exists() && file.length()==0)
                return false;
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return false;
    }

}
