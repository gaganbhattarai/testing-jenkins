package com.gritfeat.botpoc.botpoc.serviceImpl;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.repository.BotConditionRepository;
import com.gritfeat.botpoc.botpoc.service.BotConditionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotConditionServiceImpl implements BotConditionService {

    private static final Logger logger = LogManager.getLogger(BotConditionServiceImpl.class);

    @Autowired
    private BotConditionRepository repository;

    @Override
    public String test() {

        logger.debug("this is a debug log");
        logger.info("this is a info log");
        logger.warn("test service implementation reached!!");
        logger.error("this is an error log");
        logger.fatal("this is a fatal log");
        return "helloWorld";
    }

    @Override
    public BotCondition saveCondition(InputRequest<BotCondition> request) {
        String currentUser = request.getLoggedInUser();
        logger.info("logged user pulled from request");
        BotCondition condition = request.getInfo();
        condition.setCreatedBy(currentUser);
        return repository.save(condition);
    }

    @Override
    public List<BotCondition> getConditions() {
        return repository.findAllNotDeleted();
    }

    @Override
    public BotCondition updateCondition(InputRequest<BotCondition> request) {
        BotCondition condition = request.getInfo();
        BotCondition existingCondition =repository.findById(condition.getId()).orElse(null);
        existingCondition.setCondition(condition.getCondition());
        existingCondition.setTimeFrame(condition.getTimeFrame());
        existingCondition.setModifiedBy(request.getLoggedInUser());
        return repository.save(existingCondition);
    }

    @Override
    public String deleteCondition(int id) {
        try{
            BotCondition existingCondition =repository.findById(id).orElse(null);
            existingCondition.setDeleted(true);
            BotCondition result = repository.save(existingCondition);
            if(result != null){
                return "condition has been deleted";
            }else{
                return "something went wrong";
            }
        }catch(Exception e){
            return "Error Message: " + e.getMessage();
        }
    }


}
