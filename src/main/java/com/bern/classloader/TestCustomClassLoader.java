package com.bern.classloader;

public class TestCustomClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new CustomClassLoader();
        Class<?> customClass = classLoader.loadClass("com.bern.classloader.CustomClass");
        CustomClass custom = (CustomClass) customClass.newInstance();
        System.out.println(custom.hello());
    }
}
