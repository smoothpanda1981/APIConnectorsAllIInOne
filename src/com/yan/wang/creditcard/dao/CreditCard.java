package com.yan.wang.creditcard.dao;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ywang on 17.02.15.
 */
@MappedSuperclass
public abstract class CreditCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "issuing_network")
    private String issuingNetwork;

    @Column(name = "card_number")
    private Long cardNumber;

    public CreditCard (Long id, String issuingNetwork, Long cardNumber) {
        this.id = id;
        this.issuingNetwork = issuingNetwork;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssuingNetwork() {
        return issuingNetwork;
    }

    public void setIssuingNetwork(String issuingNetwork) {
        this.issuingNetwork = issuingNetwork;
    }


    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
