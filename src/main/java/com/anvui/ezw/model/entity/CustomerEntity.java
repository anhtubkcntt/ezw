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
@Table(name = "customer_tbl")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "contract_id")
    private String contractId;
    @Column(name = "district_id")
    private String districtId;
}
