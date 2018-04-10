package com.hx.eplate.trafficdata.query.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hx.eplate.trafficdata.query.chain.ParityClient;
import com.hx.eplate.trafficdata.query.state.FinalJson;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.parity.Parity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Map;

/**
 * 创建账户
 */
public class CreateAccount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CreateAccount.class);
	private Parity parity = ParityClient.getParity();
       
    public CreateAccount() {
        super();
    }

	protected JsonUtil doGet(JsonUtil jsonUtil) throws ServletException, IOException {
		return jsonUtil;

	}

	/**
	 * 创建账户
	 * @param jsonUtil
	 * @return  输入用户名和密码
	 * @throws ServletException
	 * @throws IOException
	 */
	protected JsonUtil doPost(JsonUtil jsonUtil) throws ServletException, IOException {
		Map map = (Map) jsonUtil.getData();
		String password = map.get("password").toString();
		JSONObject jsonData=new JSONObject();
		if(password==null){
			jsonUtil.getInfo().setStatus(FinalJson.STATUS_ACCEPTED);
			jsonUtil.getInfo().setMessage("password地址不能为空");
			return jsonUtil;
		}
		try {
            NewAccountIdentifier newAccountIdentifier = parity.personalNewAccount(password).send();
            if(newAccountIdentifier!=null){
                String accountId = newAccountIdentifier.getAccountId();
                jsonData.put("accountId", accountId);
                logger.info("创建成功！账户地址是:[{}]!",accountId);
				jsonUtil.getInfo().setStatus(FinalJson.STATUS_OK);
				jsonUtil.getInfo().setMessage("创建成功！账户地址是:["+accountId+"]!");
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
