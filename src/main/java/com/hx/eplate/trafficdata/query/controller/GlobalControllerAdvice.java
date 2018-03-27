package com.hx.eplate.trafficdata.query.controller;

import com.hx.eplate.trafficdata.query.state.FinalJson;
import com.hx.eplate.trafficdata.query.util.json.Info;
import com.hx.eplate.trafficdata.query.util.json.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalControllerAdvice {

	private Logger logger = LogManager.getLogger(getClass());
	private static JsonUtil jsonUtil = new JsonUtil();
	private static Info info = new Info();

	@ExceptionHandler(Exception.class)
	public JsonUtil handle(Exception e, HttpServletResponse response) {
		try {
			info.setStatus(FinalJson.STATUS_SERVERERROR);
			info.setMessage("服务器网络繁忙，请稍后重试……"+e.getMessage());
			jsonUtil.setInfo(info);
			return jsonUtil;
		} catch (Exception ex) {
			info.setStatus(FinalJson.STATUS_NOTFOUND);
			info.setMessage("服务器网络繁忙，请稍后重试……"+e.getMessage());
			jsonUtil.setInfo(info);
			return jsonUtil;
		}
	}
}
