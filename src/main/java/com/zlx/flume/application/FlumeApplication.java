package com.zlx.flume.application;

import com.zlx.flume.tools.MyRpcClientFacade;

import java.util.ArrayList;
import java.util.List;

public class FlumeApplication {

    private final List<String> message = new ArrayList<>();

    public void send(FlumeSendRequest r) {
        MyRpcClientFacade clientFacade = new MyRpcClientFacader(r.getHost(), r.getPort);

        for (String message : r.getMessage()) {
            clientFacade.sendDataToFlume(message);
        }
        clientFacade.cleanUp();
    }

    public void receive(String body) {
        message.add(body);
    }

    public void clear() {
        message.clear();
    }

    public List<String> retrieve() {
        return message;
    }

}
