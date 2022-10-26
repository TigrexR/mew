package com.tigrex.mew.config;

import com.tigrex.mew.api.hessian.UserHessian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * @author linus
 */
@Configuration
public class HessianConfig {

    @Autowired
    private UserHessian userHessian;

    /**
     * 1. HessianServiceExporter是由Spring.web框架提供的Hessian工具类，能够将bean转化为Hessian服务
     * 2. @Bean(name = "/helloHessian.do")加斜杠方式会被spring暴露服务路径,发布服务。
     * @return
     */
    @Bean("/userHessian.do")
    public HessianServiceExporter exportHelloHessian() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(userHessian);
        exporter.setServiceInterface(UserHessian.class);
        return exporter;
    }
}
