package com.gritfeat.botpoc.botpoc.service;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotCondition;

import java.util.List;

public interface BotConditionService {
    public String test();
    public BotCondition saveCondition(InputRequest<BotCondition> request);
    public List<BotCondition> getConditions();
    public BotCondition updateCondition(InputRequest<BotCondition> request);
    public String deleteCondition(int id);

}
