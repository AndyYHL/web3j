package com.hx.eplate.trafficdata.query.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 启动线程类
 * Version: 1.0<br>
 * Date: 2017年8月20日
 */
public class ReadPropertyFile extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ReadPropertyFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * 启动所有线程
	 * Version: 1.0<br>
	 * Date: 2017年8月20日
	 */
	public void init() throws ServletException {
		//PropertiesUtils.init();
//		new NotifyService().start();
//		new CrawlerService().start();
//		new TransactionService().start();
	}
}

	
	
	
