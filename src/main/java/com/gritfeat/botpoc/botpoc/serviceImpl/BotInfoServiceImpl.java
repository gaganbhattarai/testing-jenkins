package com.gritfeat.botpoc.botpoc.serviceImpl;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotInfo;
import com.gritfeat.botpoc.botpoc.entity.BotSchedule;
import com.gritfeat.botpoc.botpoc.repository.BotInfoRepository;
import com.gritfeat.botpoc.botpoc.repository.BotScheduleRepository;
import com.gritfeat.botpoc.botpoc.service.BotInfoService;
import com.gritfeat.botpoc.botpoc.service.BotScheduleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BotInfoServiceImpl implements BotInfoService {

    private static final Logger logger = LogManager.getLogger(BotConditionServiceImpl.class);

    @Autowired
    private BotInfoRepository repository;

    @Autowired
    private BotScheduleRepository scheduleRepository;

    @Autowired
    private BotScheduleServiceImpl botScheduleService;


    @Override
    public String test() {
        return "hello World!!";
    }

    @Override
    public BotInfo saveInfo(InputRequest<BotInfo> request) {
        BotInfo info = request.getInfo();
        info.setCreatedBy(request.getLoggedInUser());

        for( BotSchedule sch: info.getMethods()){
            sch.setCreatedBy(request.getLoggedInUser());
        }

        return repository.save(info);
    }

    @Override
    public List<BotInfo> getInfo() {
        return repository.findAllNotDeleted();
    }

    @Override
    public BotInfo updateInfo(InputRequest<BotInfo> request) {
        BotInfo info = request.getInfo();
        String user = request.getLoggedInUser();
        BotInfo existingInfo = repository.findById(info.getId()).orElse(null);
        existingInfo.setBotType(info.getBotType());
        existingInfo.setClientId(info.getClientId());
        existingInfo.setClientSecret(info.getClientSecret());
        existingInfo.setTenantId(info.getTenantId());
        existingInfo.setTitle(info.getTitle());
        existingInfo.setModifiedBy(user);

        List<BotSchedule> schedules = scheduleRepository.getByBotInfoId(info.getId());
        List<BotSchedule> methods = info.getMethods();

        int count =0;
        for(BotSchedule schedule: methods){

            BotSchedule extSchedule = schedules.get(count);
                    schedule.setId(extSchedule.getId());
                    logger.debug(schedule.getId());
                    botScheduleService.updateSchedule(user, schedule);
                    count++;
        }

        return repository.save(existingInfo);
    }

    @Override
    public String deleteInfo(int id) {
        try{
            BotInfo existingInfo = repository.findById(id).orElse(null);
            existingInfo.setDeleted(true);
            List<BotSchedule> existingSchedule = scheduleRepository.getByBotInfoId(id);
            for(BotSchedule sch: existingSchedule){
                sch.setDeleted(true);
                scheduleRepository.save(sch);
            }
            BotInfo result = repository.save(existingInfo);
            if(result != null){
                return "The info was deleted Successfully!!";
            }else{
                return "something went wrong";
            }

        }catch(Exception e){
            return "Error Message: " + e.getMessage();
        }
    }
}
