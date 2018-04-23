package com.hx.eplate.trafficdata.query.servlet;

import com.google.common.collect.Maps;
import com.hx.eplate.trafficdata.query.chain.Web3JClient;
import com.hx.eplate.trafficdata.query.state.FinalJson;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 * 查询账户余额
 */
public class GetBalance{

	private static Web3j web3j = Web3JClient.getClient();
	private static final Logger logger = LoggerFactory.getLogger(GetBalance.class);
	/**
	 * 查询账户余额
	 * Version: 1.0<br>
	 * Date: 2017年8月16日
	 */
	protected JsonUtil doPost(JsonUtil jsonUtil) throws ServletException, IOException {
		Map map = (Map)jsonUtil.getData();
		String accountId=map.get("accountId").toString();
		if(accountId==null){
			jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
			jsonUtil.getInfo().setMessage("accountId不能为空。查询余额地址不能为空");
			return jsonUtil;
		}
		EthGetBalance ethGetBalance;
		try {
			ethGetBalance = web3j
					  .ethGetBalance(accountId, DefaultBlockParameterName.LATEST)
					  .sendAsync()
					  .get();
			BigInteger wei = ethGetBalance.getBalance();
			BigDecimal bigDecimal=new BigDecimal(wei);
            bigDecimal=bigDecimal.divide(new BigDecimal("1000000000000000000"));
			Map data = Maps.newHashMap();
			data.put("balance", bigDecimal.toPlainString());
			jsonUtil.getInfo().setStatus(FinalJson.STATUS_OK);
			jsonUtil.getInfo().setMessage("accountId:"+accountId+".查询余额成功");
			return jsonUtil;
		} catch (Exception e) {
			logger.error("账户:[{}]余额查询失败!",accountId,e);
			jsonUtil.getInfo().setStatus(FinalJson.STATUS_SERVERERROR);
			jsonUtil.getInfo().setMessage("余额查询失败，服务出现问题。");
			return jsonUtil;
		}
	}

}
