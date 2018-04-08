package com.hx.eplate.trafficdata.query.chain;

import com.hx.eplate.trafficdata.query.state.FinalJson;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 * 钱包通过web3j链接
 * Created by Administrator on 2018-03-23.
 */
public class Web3JClient {

    private Web3JClient(){}

    private volatile static Web3j web3j;

    public static Web3j getClient(){
        if(web3j==null){
            synchronized (Web3JClient.class){
                if(web3j==null){
                    web3j = Web3j.build(new HttpService(FinalJson.walletServerUrl));
                }
            }
        }
        return web3j;
    }
}
