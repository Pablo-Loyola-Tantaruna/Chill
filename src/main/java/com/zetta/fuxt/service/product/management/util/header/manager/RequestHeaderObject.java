package com.zetta.fuxt.service.product.management.util.header.manager;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestHeaderObject {

    @AliasFor("name")
    String name() default "";

    @AliasFor("value")
    String value() default "";

    boolean required() default true;

    String defaultValue() default "";
}
