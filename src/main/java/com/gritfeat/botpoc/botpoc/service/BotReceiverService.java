package com.gritfeat.botpoc.botpoc.service;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotInfo;
import com.gritfeat.botpoc.botpoc.entity.BotReceiver;

import java.util.List;

public interface BotReceiverService {
    public String test();
    public BotReceiver saveReceiver(InputRequest<BotReceiver> request);
    public List<BotReceiver> getReceiver();
    public BotReceiver updateReceiver(InputRequest<BotReceiver> request);
    public String deleteReceiver(int id);
}
