package com.example.demo.testYpf.search.qichacha;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.methods.HttpHead;
import org.codehaus.jackson.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Pattern;

@Service
public class QichachaUnit {
    // 请登录http://yjapi.com/DataCenter/MyData
    // 查看我的秘钥 我的Key
    @Autowired
    private  QichachaConfig qichachaConfig;
    private static  String appkey ;
    private static  String seckey ;

    public void getInfoByInfo() {
        String reqInterNme = "http://api.qichacha.com/EquityThrough/GetEquityThrough";
        String paramStr = "keyword=大连万达集团股份有限公司";
        String status = "";
        try {
            appkey = qichachaConfig.getAppkey();
            seckey = qichachaConfig.getSeckey();
            // auth header setting
            HttpHead reqHeader = new HttpHead();
            String[] autherHeader = RandomAuthentHeader();
            reqHeader.setHeader("Token", autherHeader[0]);
            reqHeader.setHeader("Timespan", autherHeader[1]);
            final String reqUri = reqInterNme.concat("?key=").concat(appkey).concat("&").concat(paramStr);
            String tokenJson = HttpHelper.httpGet(reqUri, reqHeader.getAllHeaders());
            System.out.println(String.format("==========================>this is response:{%s}", tokenJson));

            // parse status from json
            status = FormartJson(tokenJson, "Status");
            System.out.println(String.format("==========================>Status:{%s}", status));
            if (!HttpCodeRegex.isAbnornalRequest(status)) {
                PrettyPrintJson(tokenJson);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // 获取返回码 Res Code
    static class HttpCodeRegex {
        private static final String ABNORMAL_REGIX = "(101)|(102)";
        private static final Pattern pattern = Pattern.compile(ABNORMAL_REGIX);
        protected static boolean isAbnornalRequest(final String status) {
            return pattern.matcher(status).matches();
        }
    }

    // 获取Auth Code
    protected static final String[] RandomAuthentHeader() {
        String timeSpan = String.valueOf(System.currentTimeMillis() / 1000);
        String[] authentHeaders = new String[] { DigestUtils.md5Hex(appkey.concat(timeSpan).concat(seckey)).toUpperCase(), timeSpan };
        return authentHeaders;
    }

    // 解析JSON
    protected static String FormartJson(String jsonString, String key) throws JSONException {
        JSONObject jObject = new JSONObject(jsonString);
        return (String) jObject.get(key);
    }

    // pretty print 返回值
    protected static void PrettyPrintJson(String jsonString) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object obj = mapper.readValue(jsonString, Object.class);
            String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(indented);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}