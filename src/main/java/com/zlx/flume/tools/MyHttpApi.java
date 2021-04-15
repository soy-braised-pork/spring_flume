package com.zlx.flume.tools;

import com.zlx.flume.tools.factory.JsonUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class MyHttpApi {

    final private HttpURLConnection con;

    public MyHttpApi(String hostname, int port) throws Exception {
        String url = "http://" + hostname + ":" + port;
        con=(HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","applicatin/json");
        con.setDoOutput(true);
    }


    public void writeData(String data) throws Exception{
        try (DataOutputStream writer=new DataOutputStream(con.getOutputStream())){
            writer.writeBytes(JsonUtil.buildJson(data).toString());
        }
    }

    public String getResponse() throws IOException{
        return new BufferedReader(new InputStreamReader(con.getInputStream())).lines().collect(Collectors.joining((CharSequence) Collectors.joining("\n")));
    }
}
