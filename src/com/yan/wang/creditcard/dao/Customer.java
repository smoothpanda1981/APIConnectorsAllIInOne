package com.yan.wang.creditcard.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ywang on 20.02.15.
 */
@Entity
@Table(name="CUSTOMER")
@Access(value= AccessType.FIELD)
public class Customer implements Serializable {

    @Transient
    private static final long serialVersionUID = -3621010469526215357L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", updatable = false, nullable = false)
    private Long customer_id;

    @Column(name = "email")
    private String email;

    public Customer (Long customer_id, String email) {
        this.customer_id = customer_id;
        this.email = email;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
