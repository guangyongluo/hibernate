package com.vilin.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {

	public static void main(String[] args) {
		Foo<Bar> foo = new Foo<Bar>();
		Type type = foo.getClass().getGenericSuperclass();
		System.out.println(type.getTypeName());
		
//		ParameterizedType pType = (ParameterizedType)type;
//		System.out.println(pType);
//		Method[] methods = foo.getClass().getGenericSuperclass().getClass().getDeclaredMethods();
//		for(Method method : methods) {
//			System.out.println(method.getName());
//		}
		
	}
}
