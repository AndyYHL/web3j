package com.hx.eplate.trafficdata.query.controller.api.v1;

/**
 * Created by wuhaochao on 2017/8/2.
 */

import com.alibaba.fastjson.JSON;
import com.hx.eplate.trafficdata.query.service.UserInfoService;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    /**
     * 注册用户
     *
     * @param jsonUtil
     * @return
     * @throws Throwable
     */
    @RequestMapping("/register")
    public Object register(@RequestBody JsonUtil jsonUtil) throws Throwable {
        Map<String,Object> mapUtil = JSON.parseObject(JSON.toJSONString(jsonUtil),Map.class);
        Map map = (Map) jsonUtil.getData();
        return userInfoService.register(mapUtil,jsonUtil);
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
