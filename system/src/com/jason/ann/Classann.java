package com.jason.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Classann {
public String tablename();
}
