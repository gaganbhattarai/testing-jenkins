package com.gritfeat.botpoc.botpoc.controller;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.service.BotConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/botCondition")
public class BotConditionController {
    @Autowired
    private BotConditionService service;

    @GetMapping("/test")
    public String test(){
        return service.test();
    }

    @PostMapping("/add")
    public BotCondition addCondition(@RequestBody InputRequest<BotCondition> request){
        return service.saveCondition(request);
    }

    @GetMapping("/conditions")
    public List<BotCondition> findAllConditions(){
        return service.getConditions();
    }

    @PutMapping("/update")
    public BotCondition updateCondition(@RequestBody InputRequest<BotCondition> request){
        return service.updateCondition(request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCondition(@PathVariable int id){
        return service.deleteCondition(id);
    }

}
