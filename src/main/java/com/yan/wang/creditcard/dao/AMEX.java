package com.yan.wang.creditcard.dao;

import com.yan.wang.creditcard.CreditCardParser;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ywang on 19.02.15.
 */
@Entity
@Table(name="AMEX")
@Access(value= AccessType.FIELD)
public class AMEX extends CreditCard {

    @Transient
    private static final long serialVersionUID = -3621010469526215357L;

    public AMEX(Long id, String issuing_network, Long cardNumber) {
        super(id, issuing_network, cardNumber);
    }
}
