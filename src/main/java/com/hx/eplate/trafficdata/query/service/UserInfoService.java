package com.hx.eplate.trafficdata.query.service;

import com.hx.eplate.trafficdata.query.util.json.JsonUtil;

import java.util.Map;

/**
 * Created by Administrator on 2018-03-12.
 */
public interface UserInfoService {
    //用户注册
    JsonUtil register(Map map,JsonUtil jsonUtil);
}
