package com.hx.eplate.trafficdata.query.servlet;

import com.google.common.collect.Maps;
import com.hx.eplate.trafficdata.query.chain.ParityClient;
import com.hx.eplate.trafficdata.query.state.FinalJson;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.parity.Parity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 查询交易记录
 * Version: 1.0<br>
 * Date: 2017年8月16日
 */
public class GetTransaction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(GetTransaction.class);
	private Parity parity = ParityClient.getParity();
       
    public GetTransaction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * 查询交易记录
	 * Version: 1.0<br>
	 * Date: 2017年8月16日
	 */
	protected JsonUtil doPost(JsonUtil jsonUtil) throws ServletException, IOException {
		Map map = (Map)jsonUtil.getData();
		String transactionHash=map.get("transactionHash").toString();
		if(transactionHash==null){
			jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
			jsonUtil.getInfo().setMessage("transactionHash地址不能为空");
			return jsonUtil;
		}
		try {
    		EthTransaction s =  parity.ethGetTransactionByHash(transactionHash).send();
            if(s==null||s.getResult()==null){
            	logger.info("hash地址:[{}]查询交易信息不存在!",transactionHash);
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
				jsonUtil.getInfo().setMessage("没有找到hash对应转账的信息");
				return jsonUtil;
            }
            Transaction transaction=s.getResult();
            Map jsonData = Maps.newHashMap();
            jsonData.put("blockHash", transaction.getBlockHash());
            jsonData.put("from", transaction.getFrom());
            jsonData.put("to", transaction.getTo());
            BigDecimal bigDecimal=new BigDecimal(transaction.getValue());
            bigDecimal=bigDecimal.divide(new BigDecimal("1000000000000000000"));
            jsonData.put("value", bigDecimal.toPlainString());
            jsonData.put("input", transaction.getInput());
            jsonData.put("gas", transaction.getGas());
            jsonData.put("gasPrice", transaction.getGasPrice());
            jsonData.put("r", transaction.getR());
            jsonData.put("s", transaction.getS());
            logger.info("hash地址:[{}]查询交易成功!",transactionHash);

			jsonUtil.setData(jsonData);
			jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
			jsonUtil.getInfo().setMessage("查询交易成功");
			return jsonUtil;
        }catch (Exception e){
        	logger.error("hash地址:[{}]查询交易失败!",transactionHash,e);
			e.printStackTrace();
			jsonUtil.getInfo().setStatus(FinalJson.STATUS_SERVERERROR);
			jsonUtil.getInfo().setMessage("交易失败，服务出现问题。");
			return jsonUtil;
        }
	}

}
