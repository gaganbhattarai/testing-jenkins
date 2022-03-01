package com.gritfeat.botpoc.botpoc.repository;

import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BotScheduleRepository extends JpaRepository<BotSchedule, Integer> {
    @Query(value = "SELECT * FROM Bot_Schedule_table WHERE bi_fk = ?1 AND deleted = 0",nativeQuery = true)
    List<BotSchedule> getByBotInfoId(int id);

    @Query(value = "SELECT * FROM Bot_schedule_table WHERE deleted = 0",nativeQuery = true)
    List<BotSchedule> findAllNotDeleted();
}
