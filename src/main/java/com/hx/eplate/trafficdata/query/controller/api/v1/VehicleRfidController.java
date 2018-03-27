package com.hx.eplate.trafficdata.query.controller.api.v1;

import com.alibaba.fastjson.JSON;
import com.hx.eplate.trafficdata.query.entity.baseEntity;
import com.hx.eplate.trafficdata.query.service.VehicleRfidService;
import com.hx.eplate.trafficdata.query.state.ClientApiFinal;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-20.
 */
@RestController
@RequestMapping(value = ClientApiFinal.version)
public class VehicleRfidController {

    @Autowired
    VehicleRfidService vehicleRfidService;

    //车辆通行记录查询
    @RequestMapping(value = "car_pass/findLimit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody JsonUtil findCarPassList(@RequestBody JsonUtil jsonUtil) throws Exception {
        Map<String,Object> map = JSON.parseObject(JSON.toJSONString(jsonUtil),Map.class);
        jsonUtil = vehicleRfidService.findCarPassList(map,jsonUtil);
        return jsonUtil;
    }
    //断面流量统计查询
    @RequestMapping(value = "plane_flow/findLimit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody JsonUtil findPlaneFlowList(@RequestBody JsonUtil jsonUtil) throws Exception {
        Map<String,Object> map = JSON.parseObject(JSON.toJSONString(jsonUtil),Map.class);
        jsonUtil = vehicleRfidService.findPlaneFlowList(map,jsonUtil);
        return jsonUtil;
    }

    //断面流量统计查询
    @RequestMapping(value = "Hi", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody baseEntity findPlaneFlowListsdfd(@RequestBody baseEntity e) throws Exception {

        return e;
    }
}
