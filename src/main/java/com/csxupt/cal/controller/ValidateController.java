package com.csxupt.cal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.csxupt.cal.common.SocketUtil;
import com.csxupt.cal.entity.LoginBean;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bhy on 2016/9/22.
 */
@Controller
public class ValidateController {

//    org.apache.http.client.methods.HttpUriRequest

    // 学校教务处登陆页面
    private final String LOGIN_URL = "http://***.**.**.***/";
    // 验证码页面
    private final String CAPTCHA_URL = "http://***.**.**.***/**.aspx";
    // 保存会话cookie
    public static String cookieValue = null;
    // 模拟登录设置服务器代理
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";

    /**
     * 此方法为了连接教务系统，检测用户教务处学号密码是否正确，否则不予跳至下一界面
     * @param request
     * @return path
     */
    @RequestMapping(value = "stu/getImage", method = RequestMethod.GET)
    public String getImage(HttpServletRequest request){
        String schoolnum = request.getParameter("schoolnum");
        String path = request.getServletContext().getRealPath("user/images/vcode.png");
        BufferedReader reader = null;
        String cookies = SocketUtil.getCookie(LOGIN_URL);
        String img_path_url = CAPTCHA_URL;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try{
            HttpGet httpGet = new HttpGet(img_path_url);
            httpGet.setHeader("User-Agent", USER_AGENT);
            httpGet.setHeader("Cookie", cookies);
            //update to add userCookie to session for validate
            request.getSession().setAttribute("userCookie",cookies);
            httpGet.setHeader("Referer", "http://*****.cn/index/**.htm");
            httpGet.setHeader("Origin", "http://www.baidu.com/");
            CloseableHttpResponse response = httpClient.execute(httpGet);

            //开始存储拿到的图片
            SocketUtil.download(response.getEntity().getContent(),path);
            Header[] headers = response.getAllHeaders();
            for(Header s:headers){
                if("Set-Cookie".equals(s.getName())){
                    cookies = s.getValue();
                }
            }
            if(cookies!=null){
                String[] strs = cookies.split(";");
                cookies = strs[0];
                System.out.println( cookies);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "page/checkNum";
    }

    /**
     * 用于第二次发送请求，验证账号密码是否正确
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "stu/validate",method = RequestMethod.POST)
    public String validate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        String data = request.getParameter("json_data");

        System.out.println(data);
//        return null;



        String userAccount = request.getParameter("schoolnum");
        String userCookie = (String) session.getAttribute("userCookie");
        System.out.println("userCookie="+userCookie);

        String uriAPI = "http://222.24.62.120/default2.aspx";// Post方式没有参数在这里
        HttpPost httpPost = new HttpPost(uriAPI);// 创建HttpPost对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //开始模拟HTTP协议
        httpPost.setHeader("Host","222.24.62.120");
        httpPost.setHeader("User-Agent", USER_AGENT);
        httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Referer", "http://***.**.**.***/***.aspx");
        httpPost.setHeader("Origin", "http://***.**.**.***/***");
        httpPost.setHeader("Cookie", userCookie);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("__V***TE", "****************UCaVfG1Oi+QaOSKH9UZrpjfn1w=="));
        params.add(new BasicNameValuePair("txt***Name", userAccount));    
        params.add(new BasicNameValuePair("TextBox2", request.getParameter("password")));     
        params.add(new BasicNameValuePair("txtSecretCode", request.getParameter("validate")));   
        params.add(new BasicNameValuePair("RadioButtonList1", "**"));
        params.add(new BasicNameValuePair("Button1", ""));
        params.add(new BasicNameValuePair("lbLanguage", ""));
        params.add(new BasicNameValuePair("hidPdrs", ""));
        params.add(new BasicNameValuePair("hidsc", ""));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);


        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);

        System.out.println("httpResponse="+httpResponse.toString());

        String regEx = "xs_main.aspx?x"; // 表示a或f
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(httpResponse.toString());

        boolean info = m.find();
        //info是获得的登录成功还是失败的信息变量
        session.setAttribute("userCookie", null);
        session.setAttribute("userAccout", "false");
        if(info){
            request.setAttribute("result", "信息验证成功！");
//            request.setAttribute("schoolNum",userAccount);
            request.getSession().setAttribute("schoolNum",userAccount);
            return "page/enroll";
//            request.getRequestDispatcher(request.getContextPath()+"/page/enroll.jsp").forward(request,response);
        }else{
            request.setAttribute("result", "信息验证失败，请重新确认信息！");
//            return "page/checkNum";
            return "page/index";
        }

    }

    @RequestMapping(value = "stu/setCode",method = RequestMethod.GET)
    public void setImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置项目文件相对路径
        String path=request.getServletContext().getRealPath("user/images/vcode.png");
        String png = GetImageStr(path);
        PrintWriter out = response.getWriter();
        out.println(png);
        out.flush();
    }

    public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }
    /**
     * 读取管道中的流数据
     */
    public byte[] readStream(InputStream inStream) {
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        int data = -1;
        try {
            while ((data = inStream.read()) != -1) {
                bops.write(data);
            }
            return bops.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

}
