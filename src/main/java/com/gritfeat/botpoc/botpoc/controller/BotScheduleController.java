package com.gritfeat.botpoc.botpoc.controller;

import com.gritfeat.botpoc.botpoc.entity.BotSchedule;
import com.gritfeat.botpoc.botpoc.service.BotScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/botSchedule")
public class BotScheduleController {
    @Autowired
    private BotScheduleService service;

    @GetMapping("/test")
    public String test(){
        return service.test();
    }

//    @PostMapping("/add")
//    public BotSchedule addSchedule(@RequestBody InputRequest<BotSchedule> request){
//        return service.saveSchedule(request);
//    }

    @GetMapping("/schedules")
    public List<BotSchedule> findAllSchedule(){
        return service.getSchedule();
    }

//    @PutMapping("/update")
//    public BotSchedule updateSchedule(@RequestBody InputRequest<BotSchedule> request){
//        return service.updateSchedule(request);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable int id){
        return service.deleteSchedule(id);
    }
}
