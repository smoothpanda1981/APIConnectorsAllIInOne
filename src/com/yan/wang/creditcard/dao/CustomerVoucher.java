package com.yan.wang.creditcard.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ywang on 20.02.15.
 */
@Entity
@Table(name="CUSTOMER_VOUCHER")
@Access(value= AccessType.FIELD)
public class CustomerVoucher implements Serializable {

    @Transient
    private static final long serialVersionUID = -3621010469526215357L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "customer_id")
    private Long customer_id;

    @Column(name = "voucher_id")
    private Long voucher_id;

    public CustomerVoucher (Long id, Long  customer_id, Long voucher_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.voucher_id = voucher_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(Long voucher_id) {
        this.voucher_id = voucher_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
