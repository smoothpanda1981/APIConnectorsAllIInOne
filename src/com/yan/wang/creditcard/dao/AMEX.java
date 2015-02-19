package com.yan.wang.creditcard.dao;

import com.yan.wang.creditcard.CreditCardParser;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ywang on 19.02.15.
 */
@Entity
@Table(name="AMEX")
public class AMEX extends CreditCard {

    public AMEX(Long id, String issuing_network, Long cardNumber) {
        super(id, issuing_network, cardNumber);
    }
}
