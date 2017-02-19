package sml;

import java.lang.reflect.Method;

/**
 * Created by lucieburgess on 19/02/2017.
 * Notes on Java Reflection by walking through the Jenkov tutorial. NOT part of the submitted assignment
 */
public class Reflection {

    Object MyObject;

    Method[] methods = MyObject.class.getMethods();

    for(Method method : methods) {
        System.out.println("method = " + method.getName())
    }

}
