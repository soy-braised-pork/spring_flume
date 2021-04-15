package com.zlx.flume.apirest.model;

import java.util.List;

public class FlumSendRequest {


    private String host;
    private int port;
    private List<String> message;

    public String getHost(){
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
