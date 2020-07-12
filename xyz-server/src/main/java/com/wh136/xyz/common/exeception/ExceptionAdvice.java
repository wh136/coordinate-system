package com.wh136.xyz.common.exeception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * controller层异常增强类
 * */
@Inherited
@Target(ElementType.TYPE)
public @interface ExceptionAdvice {
}
