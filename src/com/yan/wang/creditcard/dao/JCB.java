package com.yan.wang.creditcard.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ywang on 19.02.15.
 */
@Entity
@Table(name="JCB")
public class JCB extends CreditCard {

    public JCB(Long id, String issuing_network, Long cardNumber) {
        super(id, issuing_network, cardNumber);
    }
}
