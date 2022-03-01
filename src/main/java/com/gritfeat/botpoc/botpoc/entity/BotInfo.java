package com.gritfeat.botpoc.botpoc.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "BotInfo_table")
public class BotInfo {
    @Id
    @GeneratedValue
    private int id;
    private String botType;
    private String clientId;
    private String clientSecret;
    @OneToMany(targetEntity = BotSchedule.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "bi_fk", referencedColumnName = "id")
    private List<BotSchedule> methods;
    private String tenantId;
    private String title;
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
