package xmu.crms.service;


import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CrmsEvent {
    String table();
    String timeColumn();
    String[] whereColumns() default {};
    String[] paramColumns();
}