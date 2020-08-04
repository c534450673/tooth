package com.tooth.config;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;

/**
 * @author subo.zhang
 * @description
 * @date 2020/7/16
 * @company own
 */
@Component
public class JerseyConfig extends ResourceConfig {

//    final String basePackage = "com.tooth.*";
    private final String[] basePackage = {"com.tooth.api", "com.tooth.handler"};

    /**
     * 配置注册
     */
    public JerseyConfig() {
        // 开启api请求日志记录
        super.register(new LoggingFeature(null, Level.INFO, null, null));
        // 开启json to bean转换
        super.register(CustomJsonProvider.class);
        //开启文件上传
        super.register(MultiPartFeature.class);
        packages("org.glassfish.jersey.examples.multipart");
        packages(basePackage);
    }

    private void scan(String... packages) {
        //通过反射，注入带Path和Provider注解的类
        RestResourceProvider scanner = new RestResourceProvider(false);
        Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents(packages, new Class[]{Path.class, Provider.class});
        for (BeanDefinition beanDefinition : beanDefinitions) {
            super.register(ClassUtils.resolveClassName(beanDefinition.getBeanClassName(), this.getClassLoader()));
        }
    }

    private class RestResourceProvider extends ClassPathScanningCandidateComponentProvider {

        public RestResourceProvider(boolean useDefaultFilters) {
            super(useDefaultFilters);
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public Set<BeanDefinition> findCandidateComponents(String[] basePackage, Class[] cls) {
            Set<BeanDefinition> candidates = new LinkedHashSet<>();
            for (Class nextCls : cls) {
                super.addIncludeFilter(new AnnotationTypeFilter(nextCls));
            }
            for (String nextPack : basePackage) {
                candidates.addAll(super.findCandidateComponents(nextPack));
            }
            return candidates;
        }
    }
}
