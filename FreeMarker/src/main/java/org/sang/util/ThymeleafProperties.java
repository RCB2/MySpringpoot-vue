package org.sang.util;

import org.springframework.boot.autoconfigure.template.AbstractTemplateViewResolverProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.freemarker")
public class ThymeleafProperties  {

    public  static  final String DEFAULT_TEMPLATE_LOADER_PATH = "classpath:/templates";
    public  static  final String DEFAULT_PREFIX = "";
    public  static  final String DEFAULT_SUFFIX = ".ftl";
}
