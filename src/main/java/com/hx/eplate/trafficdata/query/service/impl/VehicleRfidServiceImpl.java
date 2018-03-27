package com.hx.eplate.trafficdata.query.service.impl;

import com.hx.eplate.trafficdata.query.dao.read.VehicleRfidReadDao;
import com.hx.eplate.trafficdata.query.service.VehicleRfidService;
import com.hx.eplate.trafficdata.query.state.FinalJson;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-12.
 */
@Service("vehicleRfidService")
public class VehicleRfidServiceImpl implements VehicleRfidService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    VehicleRfidReadDao vehicleRfidReadDao;

    //车辆通行记录查询
    @Override
    public JsonUtil findCarPassList(Map map, JsonUtil jsonUtil) {
        List carPsssList = vehicleRfidReadDao.findLimit(map);
        Integer count = vehicleRfidReadDao.findCount(map);
        return JsonUtil.setParameter(carPsssList,count,jsonUtil);
    }
    //断面流量统计查询
    @Override
    public JsonUtil findPlaneFlowList(Map map, JsonUtil jsonUtil) {

        List planeFlowList = vehicleRfidReadDao.planeFlowList(map);
        jsonUtil.setData(planeFlowList);

        jsonUtil.getInfo().setMessage("获取成功！");
        jsonUtil.getInfo().setStatus(FinalJson.STATUS_OK);
        jsonUtil.getInfo().setTimestamp(String.valueOf(System.currentTimeMillis()));
        return jsonUtil;
    }
}
