package com.anvui.ezw.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Table(name = "staff_tbl")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class StaffEntity {

    @Id
    @Column(name = "staff_id")
    private String staffId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "staff_name")
    private String staffName;
    @Column(name = "address")
    private String address;
    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "home_town")
    private String homeTown;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "state")
    private String state;
    @Column(name = "identity")
    private String identity;
    @Column(name = "identity_issue_place")
    private String identityIssuePlace;
    @Column(name = "email")
    private String email;
    @Column(name = "department_id")
    private String departmentId;
}
