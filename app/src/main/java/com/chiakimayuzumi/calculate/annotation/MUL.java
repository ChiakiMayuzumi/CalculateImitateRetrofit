package com.chiakimayuzumi.calculate.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chiakimayuzumi on 2018/4/24.
 */

@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface MUL {
}
