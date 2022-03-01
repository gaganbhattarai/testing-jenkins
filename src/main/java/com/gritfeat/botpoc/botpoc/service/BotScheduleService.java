package com.gritfeat.botpoc.botpoc.service;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotReceiver;
import com.gritfeat.botpoc.botpoc.entity.BotSchedule;

import java.util.List;

public interface BotScheduleService {
     String test();
     BotSchedule saveSchedule(String loggedInUser, BotSchedule schedule);
     List<BotSchedule> getSchedule();
     BotSchedule updateSchedule(String loggedInUser, BotSchedule schedule);
     String deleteSchedule(int id);

}
