package com.Bridgelabz.EmpPayRoll.Model;

import java.time.LocalDateTime;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="Department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long id;
    private String departmentName;
    private String departmentDescription;
    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
    
}