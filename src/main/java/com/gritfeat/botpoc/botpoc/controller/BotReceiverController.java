package com.gritfeat.botpoc.botpoc.controller;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotReceiver;
import com.gritfeat.botpoc.botpoc.service.BotReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/botReceiver")
public class BotReceiverController {
    @Autowired
    private BotReceiverService service;

    @GetMapping("/test")
    public String test(){
        return service.test();
    }

    @PostMapping("/add")
    public BotReceiver addReceiver(@RequestBody InputRequest<BotReceiver> request){
        return service.saveReceiver(request);
    }

    @GetMapping("/receivers")
    public List<BotReceiver> findAllReceiver(){
        return service.getReceiver();
    }

    @PutMapping("/update")
    public BotReceiver updateReceiver(@RequestBody InputRequest<BotReceiver> request){
        return service.updateReceiver(request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReceiver(@PathVariable int id){
        return service.deleteReceiver(id);
    }
}
