package com.gritfeat.botpoc.botpoc.repository;

import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BotConditionRepository extends JpaRepository<BotCondition, Integer> {
    @Query(value = "SELECT * FROM Bot_condition_table WHERE deleted = 0",nativeQuery = true)
    List<BotCondition> findAllNotDeleted();
}
