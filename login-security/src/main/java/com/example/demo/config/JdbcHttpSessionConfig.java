/*
 * package com.example.demo.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.jdbc.datasource.DataSourceTransactionManager; import
 * org.springframework.session.jdbc.config.annotation.web.http.
 * EnableJdbcHttpSession; import
 * org.springframework.transaction.PlatformTransactionManager;
 * 
 * 
 * セッション情報をJDBC経由でDBで管理するための設定ファイル
 * 
 * @EnableJdbcHttpSession public class JdbcHttpSessionConfig {
 * 
 * @Bean public PlatformTransactionManager transactionManager(DataSource
 * dataSource) { return new DataSourceTransactionManager(dataSource); }
 * 
 * }
 */