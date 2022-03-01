package com.gritfeat.botpoc.botpoc.controller;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotContent;
import com.gritfeat.botpoc.botpoc.service.BotContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/botContent")
public class BotContentController {
    @Autowired
    private BotContentService service;

    @GetMapping("/test")
    public String test(){
        return service.test();
    }

    @PostMapping("/add")
    public BotContent addContent(@RequestBody InputRequest<BotContent> request){
        return service.saveContent(request);
    }

    @GetMapping("/contents")
    public List<BotContent> findAllContent(){
        return service.getContent();
    }

    @PutMapping("/update")
    public BotContent updateContent(@RequestBody InputRequest<BotContent> request){
        return service.updateContent(request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContent(@PathVariable int id){
        return service.deleteContent(id);
    }
}
