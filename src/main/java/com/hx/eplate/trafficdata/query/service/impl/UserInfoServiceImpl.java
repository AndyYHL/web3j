package com.hx.eplate.trafficdata.query.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hx.eplate.trafficdata.query.chain.ParityClient;
import com.hx.eplate.trafficdata.query.dao.read.UserInfoReadDao;
import com.hx.eplate.trafficdata.query.dao.write.UserInfoWriteDao;
import com.hx.eplate.trafficdata.query.service.UserInfoService;
import com.hx.eplate.trafficdata.query.servlet.CreateAccount;
import com.hx.eplate.trafficdata.query.state.FinalJson;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.parity.Parity;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-12.
 */
@Service("userInfoService")
@SuppressWarnings({"SpringJavaAutowiringInspection", "SpringJavaInjectionPointsAutowiringInspection"})
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoReadDao userInfoReadDao;
    @Autowired
    UserInfoWriteDao userInfoWriteDao;
    //区跨链账户链接
    private Parity parity = ParityClient.getParity();
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    //用户注册
    @Override
    public JsonUtil register(Map map, JsonUtil jsonUtil) {
        JSONObject jsonData=new JSONObject();
        Map mapData = (Map) jsonUtil.getData();
        String password = mapData.get("pwd").toString();
        if(password==null){
            jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
            jsonUtil.getInfo().setMessage("password地址不能为空");
            return jsonUtil;
        }
        try {
            if(userInfoReadDao.find(map) != null){
                jsonUtil.getInfo().setStatus(FinalJson.STATUS_CREATED);
                jsonUtil.getInfo().setMessage("用户名已存在!");
                return jsonUtil;
            }
            NewAccountIdentifier newAccountIdentifier = parity.personalNewAccount(password).send();
            if(newAccountIdentifier != null){
                String accountId = newAccountIdentifier.getAccountId();
                jsonData.put("accountId", accountId);
                logger.info("创建成功！账户地址是:[{}]!",accountId);
                jsonUtil.getInfo().setStatus(FinalJson.STATUS_OK);
                jsonUtil.getInfo().setMessage("创建成功！账户地址是:["+accountId+"]!");
                ((Map)map.get("data")).put("purseaddress",accountId);
                userInfoWriteDao.saveNotNull(map);
                return jsonUtil;
            }else{
                logger.error("password:[{}]创建账户失败!",password);
                jsonUtil.getInfo().setStatus(FinalJson.STATUS_CREATED);
                jsonUtil.getInfo().setMessage("password:["+password+"]创建账户失败!");
                return jsonUtil;
            }
        } catch (Exception e) {
            logger.error("password:[{}]创建账户失败!",password,e);
            jsonUtil.getInfo().setStatus(FinalJson.STATUS_SERVERERROR);
            jsonUtil.getInfo().setMessage("创建账户失败，服务出现问题。"+e.getMessage());
            return jsonUtil;
        }
    }
}
