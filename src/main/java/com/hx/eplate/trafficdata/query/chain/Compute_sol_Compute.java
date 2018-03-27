package com.hx.eplate.trafficdata.query.chain;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018-03-23.
 */
public class Compute_sol_Compute {
    public static void main(String[] args) throws Exception{
        // 创建一个 web3j 的连接
        Web3j web3j = Web3j.build(new HttpService());

        // 部署的时候需要用到该账户的 gas，务必保证该账户余额充足
        Credentials credentials = WalletUtils.loadCredentials(
                "123",
                "/datadir/chain/keystore/UTC--2018-03-14T14-46-38.646997441Z--c2acba996f709d4b806d3330996f49d50f088258");

        // 部署合约
        //Compute_sol_Compute compute_sol_compute = Compute_sol_Compute.deploy(web3j, credentials, BigInteger.valueOf(200000), BigInteger.valueOf(20000000)).send();

        // 部署完成后打印合约地址
        //System.out.println(simpleStorage_sol_simpleStorage.getContractAddress());
    }
}
