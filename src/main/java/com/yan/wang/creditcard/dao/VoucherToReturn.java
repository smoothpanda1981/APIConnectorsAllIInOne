package com.yan.wang.creditcard.dao;

/**
 * Created by ywang on 20.02.15.
 */
public class VoucherToReturn {

    private String email;
    private String companyName;
    private String voucherText;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVoucherText() {
        return voucherText;
    }

    public void setVoucherText(String voucherText) {
        this.voucherText = voucherText;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
