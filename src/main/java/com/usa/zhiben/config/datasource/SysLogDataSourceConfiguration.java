package com.usa.zhiben.config.datasource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = {"com.usa.zhiben.mapper.sysLog"}, sqlSessionFactoryRef = "sysLogSqlSessionFactory")
public class SysLogDataSourceConfiguration {
    /**
     * The constant MAPPER_XML_LOCATION.
     */
    public static final String MAPPER_XML_LOCATION = "classpath:mybatis/mapper/sysLog/**/*.xml";

    /**
     * The Open plat form data source.
     */
    @Autowired
    @Qualifier("sysLogDataSource")
    DataSource sysLogDataSource;

    /**
     * 配置工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "sysLogSqlSessionFactory")
    public SqlSessionFactory sysLogSqlSessionFactory() throws Exception {


        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(sysLogDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_XML_LOCATION));

        //分页插件
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "mysql");
        //是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPageNum", "true");
        //是否进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
        interceptor.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[]{interceptor});

        return sessionFactory.getObject();
    }


    /**
     * 配置模板
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionTemplateSysLog")
    public SqlSessionTemplate sqlSessionTemplateCar() throws Exception {

        return new SqlSessionTemplate(sysLogSqlSessionFactory());
    }
}
