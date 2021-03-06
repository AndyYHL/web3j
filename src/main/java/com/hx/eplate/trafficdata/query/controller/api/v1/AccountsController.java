package com.hx.eplate.trafficdata.query.controller.api.v1;

/**
 * Created by wuhaochao on 2017/8/2.
 */

import com.google.common.collect.Maps;
import com.hx.eplate.trafficdata.query.chain.ParityClient;
import com.hx.eplate.trafficdata.query.chain.Web3JClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.parity.Parity;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户信息
 */
@RequestMapping("/accounts")
@RestController
public class AccountsController {
    //区跨链账户链接
    private Parity parity = ParityClient.getParity();
    private Web3j web3j = Web3JClient.getClient();
    /**
     * 获取账户资金
     *
     * @param address
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getbalance/{address}")
    public Object getBalance(@PathVariable("address") String address) throws Throwable {
        return parity.parityRemoveAddress(address);
    }

    /**
     * 获取存在账户列表
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getAccounts")
    public Object getAccounts() throws Throwable {
        Map map = Maps.newHashMap();
        map.put("ethAccounts",web3j.ethAccounts());
        return map;
    }

    /**
     * 获取账户发起交易数量及交易列表
     *
     * @param address
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getTransactionCount/{address}")
    public Object getTransactionCount(@PathVariable("address") String address) throws Throwable {
        return null;
    }
}
