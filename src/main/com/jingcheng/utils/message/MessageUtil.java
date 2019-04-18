package jingcheng.utils.message;

import org.apache.http.client.ClientProtocolException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 发送短信
 */
public class MessageUtil {

    /**
     * 生成四位验证码
     */
    public static String code(){
        String code = (int)(Math.random()*10000)+"";
        if(code.length()<4){
            code();
        }
        return code;
    }

    /**
     * 发送短信
     */
    public static String sendMessage(String userPhone ,String code) throws ClientProtocolException, IOException {
        //账号
        String CorpID = "zhulutianxia";
        //密码
        String Pwd = "zl@985211";
        //手机号
        String Mobile = userPhone;
        //内容
        String Content = "【逐鹿科技】您的验证码为"+code+"，10分钟内有效";
        System.out.println("手机号"+userPhone);
        System.out.println("内容"+Content);
        //访问准备
        URL url = new URL("http://101.200.29.88:8082/SendMT/SendMessage");
        //post参数
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("CorpID",CorpID);
        params.put("Pwd", Pwd);
        params.put("Mobile", Mobile);
        params.put("Content", Content);

        //开始访问
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        System.out.println(response);
        return response;

    }

    /*public static String sendMessage(String userPhone) throws ClientProtocolException, IOException {
        String url = "http://101.200.29.88:8082/SendMT/SendMessage";
        //账号
        String CorpID = "zhulutianxia";
        //密码
        String Pwd = "zl@985211";
        //手机号
        String Mobile = userPhone;
        //内容
        String Content = "【逐鹿科技】您的验证码为7788，3分钟内有效";
        //通道号码末尾添加的扩展号码(非必填项)
        String Cell;
        //post请求返回结果
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //定义返回数据
        JSONObject jsonResult = null;
        //设置post请求
        HttpPost method = new HttpPost(url);
        method.setHeader("Content-Type", "application/json");
        method.setHeader("charset", "UTF-8");

        try {
            Map<String, Object> param = new HashMap<>();
            param.put("CorpID", CorpID);
            param.put("Pwd", Pwd);
            param.put("Mobile", Mobile);
            param.put("Content", Content);
            //解决中文乱码问题
            StringEntity entity = new StringEntity(param.toString());
            method.setEntity(entity);
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            System.out.println(result);
            //请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    //读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity());
                    //把json字符串转换成json对象
                    System.out.println("读取服务器返回过来的json字符串数据" + str);
                } catch (Exception e) {
                    System.out.println("post请求提交失败:" + url);
                }
            }
        } catch (IOException e) {
            System.out.println("post请求提交失败:" + url);
        }
        //将环信返回的东西返回给后台做处理
        return "";
    }*/


}
