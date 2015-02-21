package com.yan.wang.creditcard.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by ywang on 19.02.15.
 */
@Entity
@Table(name="DISCOVER")
public class Discover extends CreditCard {

    @Transient
    public static final long serialVersionUID = 1L;

    public Discover(Long id, String issuing_network, Long cardNumber) {
        super(id, issuing_network, cardNumber);
    }
}
