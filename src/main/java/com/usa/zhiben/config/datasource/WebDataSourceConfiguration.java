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

/**
 * Spring data source configuration
 * <p/>
 * Created in 2018.12.03
 * <p/>
 * 注意basePackages 指定扫描Mapper的包路径，sqlSessionFactoryRef 指定sql session工厂，跟下面的方法名相等
 *
 * @author Liaozihong
 */
@Configuration
@MapperScan(basePackages = {"com.usa.zhiben.mapper.web"}, sqlSessionFactoryRef = "webSqlSessionFactory")
public class WebDataSourceConfiguration {
    /**
     * The constant MAPPER_XML_LOCATION.
     */
    public static final String MAPPER_XML_LOCATION = "classpath:mybatis/mapper/web/**/*.xml";

    /**
     * The Open plat form data source.
     */
    @Autowired
    @Qualifier("webDataSource")
    DataSource webDataSource;


    /**
     * 配置工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "webSqlSessionFactory")
    public SqlSessionFactory webSqlSessionFactory() throws Exception {


        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(webDataSource);
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

        System.out.println("web的数据库工厂创建成功----------------------------------------------------");
        return sessionFactory.getObject();
    }


    /**
     * 配置模板
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionTemplateWeb")
    public SqlSessionTemplate sqlSessionTemplateCar() throws Exception {
        return new SqlSessionTemplate(webSqlSessionFactory());
    }
}
