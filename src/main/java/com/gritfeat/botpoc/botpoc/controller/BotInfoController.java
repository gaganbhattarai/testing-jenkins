package com.gritfeat.botpoc.botpoc.controller;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotContent;
import com.gritfeat.botpoc.botpoc.entity.BotInfo;
import com.gritfeat.botpoc.botpoc.service.BotInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/botInfo")
public class BotInfoController {
    @Autowired
    private BotInfoService service;

    @GetMapping("/test")
    public String test(){
        return service.test();
    }

    @PostMapping("/add")
    public BotInfo addInfo(@RequestBody InputRequest<BotInfo> request){
        return service.saveInfo(request);
    }

    @GetMapping("/info")
    public List<BotInfo> findAllInfo(){
        return service.getInfo();
    }

    @PutMapping("/update")
    public BotInfo updateInfo(@RequestBody InputRequest<BotInfo> request){
        return service.updateInfo(request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInfo(@PathVariable int id){
        return service.deleteInfo(id);
    }
}
