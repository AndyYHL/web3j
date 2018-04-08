package com.hx.eplate.trafficdata.query.servlet;

import com.google.common.collect.Maps;
import com.hx.eplate.trafficdata.query.chain.ParityClient;
import com.hx.eplate.trafficdata.query.state.FinalJson;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.parity.Parity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 * 创建交易事物
 * Version: 1.0<br>
 * Date: 2017年8月16日
 */
public class CreateTransaction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CreateTransaction.class);
	private Parity parity = ParityClient.getParity();
    public CreateTransaction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * 事物交易请求
	 * Version: 1.0<br>
	 * Date: 2017年8月16日
	 */
	protected JsonUtil doPost(JsonUtil jsonUtil) throws ServletException, IOException {
		while(true){
			Map map = (Map)jsonUtil.getData();
			String accountId=map.get("accountId").toString();
			if(accountId==null){
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
				jsonUtil.getInfo().setMessage("accountId不能为空。");
				return jsonUtil;
			}
			String passsword=map.get("passsword").toString();
			if(passsword==null){
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
				jsonUtil.getInfo().setMessage("passsword不能为空。");
				return jsonUtil;
			}
			String toAccountId=map.get("toAccountId").toString();
			if(toAccountId==null){
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
				jsonUtil.getInfo().setMessage("toAccountId不能为空。");
				return jsonUtil;
			}
			String amStr=map.get("amount").toString();
			if(amStr==null){
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
				jsonUtil.getInfo().setMessage("amount不能为空。");
				return jsonUtil;
			}
			
			BigDecimal amountDecimal=new BigDecimal(amStr);
			amountDecimal=amountDecimal.multiply(new BigDecimal("1000000000000000000"));
			BigInteger amount=amountDecimal.toBigInteger();
			if(amount.compareTo(BigInteger.valueOf(0))==0){
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
				jsonUtil.getInfo().setMessage("操作资金精度太小，不能转账。。");
				return jsonUtil;
			}
			////交易手续费由price*limit来决定，所有这两个值你可以自定义，也可以使用系统参数获取当前两个值
			BigInteger price =new BigInteger("1");
			BigInteger limit =new BigInteger("1");
			Transaction transaction = Transaction.createEtherTransaction(accountId,null,price,limit,toAccountId,amount);
			logger.info("创建事物成功，账户:[{}]转账到账户:[{}],资金amount:[{}]]",accountId,toAccountId,amStr);
			try{
            EthSendTransaction ethSendTransaction =parity.personalSendTransaction(transaction,passsword).send();
				if(ethSendTransaction!=null){
					String tradeHash = ethSendTransaction.getTransactionHash();
					logger.info("转币交易成功，账户:[{}]转账到账户:[{}],资金amount:[{}],交易hash:[{}]",accountId,toAccountId,amStr,tradeHash);
					Map data = Maps.newHashMap();
					data.put("tradeHash", tradeHash);
					jsonUtil.setData(data);
					jsonUtil.getInfo().setStatus(FinalJson.STATUS_OK);
					jsonUtil.getInfo().setMessage("转币交易成功，账户:["+accountId+"]转账到账户:["+toAccountId+"],资金amount:["+amStr+"],交易hash:["+tradeHash+"]");
					return jsonUtil;
				}
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_OK);
				jsonUtil.getInfo().setMessage("转币交易成功");
				return jsonUtil;
			}catch (Exception e){
				logger.error("账户:[{}]交易失败!",accountId,e);
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_SERVERERROR);
				jsonUtil.getInfo().setMessage("账户:["+accountId+"]交易失败!交易失败，服务出现问题。"+e.getMessage());
				return jsonUtil;
			}
		}
	}

}
