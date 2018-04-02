package com.hx.eplate.trafficdata.query.chain;

public class ALICE {
    private String address; //钱包地址
    private EcKeyPair ecKeyPair; //秘钥

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EcKeyPair getEcKeyPair() {
        return ecKeyPair;
    }

    public void setEcKeyPair(EcKeyPair ecKeyPair) {
        this.ecKeyPair = ecKeyPair;
    }
}
