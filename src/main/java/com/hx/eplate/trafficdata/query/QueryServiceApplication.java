package com.hx.eplate.trafficdata.query;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling//启动定时探测
@EnableAsync//启动自定义线程池
@EnableTransactionManagement//启动事物管理
@MapperScan("com.hx.eplate.trafficdata.query.dao")
public class QueryServiceApplication extends SpringBootServletInitializer {

	//  区跨链 在服务器上的创世ID 20180418
	//第一个测试点 如果启用第二个测试节点，port以及rpcport应与第一个节点不同 --port 16333 系统默认是30303 -rpcport 8546 系统默认是8545
	//参考网址：https://blog.csdn.net/w88193363/article/details/79402074
	//https://www.cnblogs.com/liangyue/p/6824858.html
	/**
	 * 添加第三方json工具
	 * 1、需要再pom.xml加入相关以来
	 * 2、需要再APP 继承 WeWebMvcConfigurerAdapter  重写configureMessageConverters
	 * 3、或者使用bean注入fastJsonHttpMessageConverters
	 *
	 *
	 * 配置fastjson支持两种方法
	 * 一：1、启动继承 WebMvcConfigurerAdapter 2、覆盖方法configureMessageConverters
	 * 二：使用bean注入fastJsonHttpMessageConverters
	 * 这里使用@Bean注入 HttpMessageConverters
	 * @Description
	 * @author Administrator
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//1、定义convert转换消息对象
		FastJsonHttpMessageConverter fasConverter  = new  FastJsonHttpMessageConverter();
		//2、添加fastJson的配置信息，比如：是否要格式化返回json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");    // 自定义时间格式
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteNullListAsEmpty);
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		//4.在convert中添加配置信息.
		fasConverter.setSupportedMediaTypes(fastMediaTypes);
		fasConverter.setFastJsonConfig(fastJsonConfig);
		fasConverter.setFastJsonConfig(fastJsonConfig);

		HttpMessageConverter<?> converter = fasConverter;

		return new HttpMessageConverters(converter);
	}

	/**
	 * 添加 tomcat 网页支持
	 * @param application
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(QueryServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(QueryServiceApplication.class, args);
	}
}
