package com.gritfeat.botpoc.botpoc.service;


import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotContent;
import com.gritfeat.botpoc.botpoc.entity.BotInfo;

import java.util.List;

public interface BotInfoService {
    public String test();
    public BotInfo saveInfo(InputRequest<BotInfo> request);
    public List<BotInfo> getInfo();
    public BotInfo updateInfo(InputRequest<BotInfo> request);
    public String deleteInfo(int id);
}
