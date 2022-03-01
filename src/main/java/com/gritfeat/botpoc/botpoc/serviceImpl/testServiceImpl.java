package com.gritfeat.botpoc.botpoc.serviceImpl;

import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotReceiver;
import com.gritfeat.botpoc.botpoc.service.testService;

import java.util.List;

public class testServiceImpl implements testService {
    @Override
    public void test() {

    }

    @Override
    public String returnType(List<BotCondition> condition) {
        BotReceiver receiver = new BotReceiver();
        return null;
    }
}
