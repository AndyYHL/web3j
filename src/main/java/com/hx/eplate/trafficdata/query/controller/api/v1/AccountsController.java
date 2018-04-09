package com.hx.eplate.trafficdata.query.controller.api.v1;

/**
 * Created by wuhaochao on 2017/8/2.
 */

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户信息
 */
@RequestMapping("/accounts")
@RestController
public class AccountsController {
    /**
     * 获取账户资金
     *
     * @param address
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getbalance/{address}")
    public Object getBalance(@PathVariable("address") String address) throws Throwable {
        return null;
    }

    /**
     * 获取存在账户列表
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getAccounts")
    public Object getAccounts() throws Throwable {
        return null;
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
