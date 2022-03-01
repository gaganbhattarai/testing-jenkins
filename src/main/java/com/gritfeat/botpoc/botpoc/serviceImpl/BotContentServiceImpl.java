package com.gritfeat.botpoc.botpoc.serviceImpl;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotContent;
import com.gritfeat.botpoc.botpoc.repository.BotContentRepository;
import com.gritfeat.botpoc.botpoc.service.BotContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotContentServiceImpl implements BotContentService {
    @Autowired
    private BotContentRepository repository;

    @Override
    public String test() {
        return "helloWorld";
    }

    @Override
    public BotContent saveContent(InputRequest<BotContent> request) {
        String currentUser = request.getLoggedInUser();
        BotContent content = request.getInfo();
        content.setCreatedBy(currentUser);
        return repository.save(content);
    }

    @Override
    public List<BotContent> getContent() {
        return repository.findAllNotDeleted();
    }

    @Override
    public BotContent updateContent(InputRequest<BotContent> request) {
        BotContent content = request.getInfo();
        BotContent existingContent = repository.findById(content.getId()).orElse(null);
        existingContent.setMessage(content.getMessage());
        existingContent.setModifiedBy(request.getLoggedInUser());
        return repository.save(existingContent);
    }

    @Override
    public String deleteContent(int id) {
        try{
            BotContent existingContent = repository.findById(id).orElse(null);
            existingContent.setDeleted(true);
            BotContent result = repository.save(existingContent);
            if(result != null){
                return "The content was deleted Successfully!!";
            }else{
                return "Something went wrong";
            }
        }catch(Exception e){
            return "Error Message: " + e.getMessage();
        }
    }
}
