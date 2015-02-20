package com.yan.wang.creditcard.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ywang on 20.02.15.
 */
@Entity
@Table(name="VOUCHER")
@Access(value= AccessType.FIELD)
public class Voucher implements Serializable {

    @Transient
    private static final long serialVersionUID = -3621010469526215357L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "voucher_id", updatable = false, nullable = false)
    private Long voucher_id;

    @Column(name = "voucher_text")
    private String voucher_text;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "flag")
    private Long flag;

    public Voucher (Long voucher_id, String voucher_text, String company_name, Long flag) {
        this.voucher_id = voucher_id;
        this.voucher_text = voucher_text;
        this.company_name = company_name;
        this.flag = flag;
    }

    public Long getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(Long voucher_id) {
        this.voucher_id = voucher_id;
    }

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public String getVoucher_text() {
        return voucher_text;
    }

    public void setVoucher_text(String voucher_text) {
        this.voucher_text = voucher_text;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

}
