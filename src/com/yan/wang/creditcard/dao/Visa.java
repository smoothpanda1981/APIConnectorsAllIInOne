package com.yan.wang.creditcard.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ywang on 19.02.15.
 */
@Entity
@Table(name="VISA")
public class Visa extends CreditCard {

    public Visa(Long id, String issuing_network, Long cardNumber) {
        super(id, issuing_network, cardNumber);
    }
}
