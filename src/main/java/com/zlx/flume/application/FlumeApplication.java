package com.zlx.flume.application;

import com.zlx.flume.apirest.model.FlumSendRequest;
import com.zlx.flume.tools.MyRpcClientFacade;

import java.util.ArrayList;
import java.util.List;

public class FlumeApplication {

    private final List<String> message = new ArrayList<>();

    public void send(FlumSendRequest r) {
        MyRpcClientFacade clientFacade = new MyRpcClientFacade(r.getHost(), r.getPort());

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
