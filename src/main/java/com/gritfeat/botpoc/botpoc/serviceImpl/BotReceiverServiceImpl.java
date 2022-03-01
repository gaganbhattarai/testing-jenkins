package com.gritfeat.botpoc.botpoc.serviceImpl;

import com.gritfeat.botpoc.botpoc.dto.InputRequest;
import com.gritfeat.botpoc.botpoc.entity.BotReceiver;
import com.gritfeat.botpoc.botpoc.repository.BotReceiverRepository;
import com.gritfeat.botpoc.botpoc.service.BotReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotReceiverServiceImpl implements BotReceiverService {
    @Autowired
    private BotReceiverRepository repository;

    @Override
    public String test() {
        return "hello World";
    }

    @Override
    public BotReceiver saveReceiver(InputRequest<BotReceiver> request) {
        BotReceiver receiver = request.getInfo();
        receiver.setCreatedBy(request.getLoggedInUser());
        return repository.save(receiver);
    }

    @Override
    public List<BotReceiver> getReceiver() {
        return repository.findAllNotDeleted();
    }

    @Override
    public BotReceiver updateReceiver(InputRequest<BotReceiver> request) {
        BotReceiver receiver = request.getInfo();
        BotReceiver existingReceiver = repository.findById(receiver.getId()).orElse(null);
        existingReceiver.setUserId(receiver.getUserId());
        existingReceiver.setModifiedBy(request.getLoggedInUser());

        return repository.save(existingReceiver);
    }

    @Override
    public String deleteReceiver(int id) {
        try{
            BotReceiver receiver = repository.findById(id).orElse(null);
            receiver.setDeleted(true);
            BotReceiver result = repository.save(receiver);
            if(result != null){
                return "Receiver Deleted Succesfully!!";
            }else{
                return"something went wrong";
            }
        }catch(Exception e){
            return "Error Message: " + e.getMessage();
        }
    }
}
