package com.hd.oms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @ClassName: MyBatisConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wqy
 * @date 2019年8月20日
 *
 */
@Configuration
@EnableTransactionManagement
@MapperScan({ "com.hd.oms.dao" })
public class MyBatisConfig {
}
