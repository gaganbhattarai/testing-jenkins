package com.gritfeat.botpoc.botpoc.serviceImpl;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotSchedule;
import com.gritfeat.botpoc.botpoc.repository.BotScheduleRepository;
import com.gritfeat.botpoc.botpoc.service.BotScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotScheduleServiceImpl implements BotScheduleService {
    @Autowired
    private BotScheduleRepository repository;

    @Override
    public String test() {
        return "hello World";
    }

    @Override
    public BotSchedule saveSchedule(String loggedInUser, BotSchedule schedule) {
        schedule.setCreatedBy(loggedInUser);
        return repository.save(schedule);
    }

    @Override
    public List<BotSchedule> getSchedule() {
        return repository.findAll();
    }

    @Override
    public BotSchedule updateSchedule(String loggedInUser, BotSchedule schedule) {
        BotSchedule existingSchedule = repository.findById(schedule.getId()).orElse(null);
        existingSchedule.setDay(schedule.getDay());
        existingSchedule.setMethod(schedule.getMethod());
        existingSchedule.setTrigger(schedule.getTrigger());
        existingSchedule.setTriggerType(schedule.getTriggerType());
        existingSchedule.setWeek(schedule.getWeek());
        existingSchedule.setModifiedBy(loggedInUser);
        return repository.save(existingSchedule);
    }

    @Override
    public String deleteSchedule(int id) {
        try{
            repository.deleteById(id);
        }catch(Exception e){
            return "Error Message: "+ e.getMessage();
        }
        return "Schedule Deleted Successfully!!";
    }
}
