package com.gritfeat.botpoc.botpoc.service;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotContent;

import java.util.List;

public interface BotContentService {
    public String test();
    public BotContent saveContent(InputRequest<BotContent> request);
    public List<BotContent> getContent();
    public BotContent updateContent(InputRequest<BotContent> request);
    public String deleteContent(int id);
}
