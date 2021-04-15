package com.zlx.flume.apirest;


import com.zlx.flume.apirest.model.FlumSendRequest;
import com.zlx.flume.application.FlumeApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flume")
public class FlumController {

    private FlumeApplication flumeApplication;

    public FlumController(FlumeApplication flumeApplication){
        this.flumeApplication=flumeApplication;
    }

    @PostMapping(value = "/send")
    public void send(@RequestBody FlumSendRequest r){
        flumeApplication.send(r);
    }

    @RequestMapping("/receive")
    public void receive(@RequestBody String body){
        flumeApplication.receive(body);
    }

    @PostMapping(value = "/clear")
    public void clear(){
        flumeApplication.clear();
    }

    @GetMapping(value = "/retrieve")
    public List<String> retrieve() {
        return flumeApplication.retrieve();
    }
}
