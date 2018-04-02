package com.hx.eplate.trafficdata.query.chain;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 * Created by Administrator on 2018-03-23.
 */
public class Web3JClient {

    private Web3JClient(){}

    private volatile static Web3j web3j;

    public static Web3j getClient(String moneyUrl){
        if(web3j==null){
            synchronized (Web3JClient.class){
                if(web3j==null){
                    web3j = Web3j.build(new HttpService(moneyUrl));
                }
            }
        }
        return web3j;
    }
}
