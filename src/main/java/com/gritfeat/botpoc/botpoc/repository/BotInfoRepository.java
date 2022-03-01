package com.gritfeat.botpoc.botpoc.repository;

import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BotInfoRepository extends JpaRepository<BotInfo, Integer> {
    @Query(value = "SELECT * FROM Bot_info_table WHERE deleted = 0",nativeQuery = true)
    List<BotInfo> findAllNotDeleted();
}
