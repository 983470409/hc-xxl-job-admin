package com.xxl.job.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Description 多数据源配置
 * @Author xiaoxiaofeng
 * @Date 2019/10/10 16:08
 */
@Configuration
public class DataSourceConfig {

    /**
     * 加密后的密码
     */
    @Value("${spring.datasource.afterPassword}")
    private String afterPwd;

    /**
     * xxl数据源
     * @return
     */
    @Bean(name="xxlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "xxl.spring.datasource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        dataSource.setPassword(EncryptorUtils.getDecryptionString(afterPwd));
        //properties.setProperty("druid.password", EncryptorUtils.getDecryptionString(afterPwd));
        return dataSource;
    }



}
