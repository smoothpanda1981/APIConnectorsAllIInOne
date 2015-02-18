package com.yan.wang.apiconnectors;

/**
 * Created by ywang on 17.02.15.
 */
public class CreditCard {
    private String issuingNetwork;
    private Long cardNumber;


    public CreditCard (String issuingNetwork, Long cardNumber) {
        this.issuingNetwork = issuingNetwork;
        this.cardNumber = cardNumber;
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
