package com.myjava.pattern.singleton.demo1;

public class Emperor {

	// 定义一个皇帝
	private static Emperor emperor = null;

	// 私有化构造方法,限定唯一皇帝
	private Emperor() {

	}

	public static Emperor getInstance() {
		if (emperor == null) {
			emperor = new Emperor();
		}
		return emperor;
	}

	public static void emperorInfo() {
		System.out.println("我就是皇帝XXX----");

	}
}
