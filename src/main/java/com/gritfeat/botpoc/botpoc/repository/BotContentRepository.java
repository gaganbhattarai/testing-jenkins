package com.gritfeat.botpoc.botpoc.repository;

import com.gritfeat.botpoc.botpoc.entity.BotCondition;
import com.gritfeat.botpoc.botpoc.entity.BotContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BotContentRepository extends JpaRepository<BotContent, Integer> {
    @Query(value = "SELECT * FROM Bot_content_table WHERE deleted = 0",nativeQuery = true)
    List<BotContent> findAllNotDeleted();
}
