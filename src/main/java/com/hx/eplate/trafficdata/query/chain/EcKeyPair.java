package com.hx.eplate.trafficdata.query.chain;

public class EcKeyPair {
    private String privateKey; //私钥
    private String publicKey; //公钥

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
