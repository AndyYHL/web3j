package com.hx.eplate.trafficdata.query.chain;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

/**
 * Created by Administrator on 2018-03-23.
 */
public class Web3Blog1_1 {
    public static void main(String[] args) throws Exception{
        //建立以太坊连接
        Web3j web3 = Web3j.build(new HttpService("https://kovan.infura.io/yXDUNwlNOcx0UJCWjzNr"));
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        //加载账户信息
        Credentials credentials = WalletUtils.loadCredentials(
                "123",
                "/datadir/chain/keystore/UTC--2018-03-14T14-46-38.646997441Z--c2acba996f709d4b806d3330996f49d50f088258");
        //获取账户余额
        String address = "0xa6fd2ebac389773f5bd34d0738bc5fdbd1bea01b";
        EthGetBalance ethGetBalance = web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
        if(ethGetBalance!=null){
            // 打印账户余额
            System.out.println(ethGetBalance.getBalance());
            // 将单位转为以太，方便查看
            System.out.println(Convert.fromWei(ethGetBalance.getBalance().toString(), Convert.Unit.ETHER));
        }

        System.out.println(clientVersion);
    }
}
