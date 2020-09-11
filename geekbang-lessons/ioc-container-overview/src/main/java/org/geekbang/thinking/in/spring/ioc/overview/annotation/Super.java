package org.geekbang.thinking.in.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //表示标注在类上
@Retention(RetentionPolicy.RUNTIME) //运行时带注解信息
public @interface Super {
}
