/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: PerfLogging
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 3:44:17 PM
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PerfLogging {

}
