package com.gritfeat.botpoc.botpoc.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "BotSchedule_table")
public class BotSchedule {
    @Id
    private int id;
    private Long day;
    private String method;
    @Column(name = "\"trigger\"")
    private String trigger;
    private String triggerType;
    private Long week;
    private boolean deleted;

    //    Auditing Attributes
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date modifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
}
