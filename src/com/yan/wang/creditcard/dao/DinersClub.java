package com.yan.wang.creditcard.dao;

import javax.persistence.*;

/**
 * Created by ywang on 19.02.15.
 */
@Entity
@Table(name="DINERS_CLUB")
@Access(value= AccessType.FIELD)
public class DinersClub extends CreditCard {

    @Transient
    public static final long serialVersionUID = -3621010469526215357L;

    public DinersClub(Long id, String issuing_network, Long cardNumber) {
        super(id, issuing_network, cardNumber);
    }
}
