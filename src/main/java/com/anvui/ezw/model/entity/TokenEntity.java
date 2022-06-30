package com.anvui.ezw.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "token_tbl")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TokenEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "accessToken")
    private String access_token;
    @Column(name = "deviceToken")
    private String device_token;
    @Column(name = "staffId")
    private String staff_id;
}
