package com.hx.eplate.trafficdata.query.service;

import com.hx.eplate.trafficdata.query.util.json.JsonUtil;

import java.util.Map;

/**
 * Created by Administrator on 2018-03-12.
 */
public interface VehicleRfidService {
    //车辆通行记录查询
    JsonUtil findCarPassList(Map map,JsonUtil jsonUtil);
    //断面流量统计查询
    JsonUtil findPlaneFlowList(Map map,JsonUtil jsonUtil);
}
