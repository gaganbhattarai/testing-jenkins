package com.gritfeat.botpoc.botpoc.repository;

import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BotReceiverRepository extends JpaRepository<BotReceiver,Integer> {
    @Query(value = "SELECT * FROM Bot_receiver_table WHERE deleted = 0",nativeQuery = true)
    List<BotReceiver> findAllNotDeleted();
}
