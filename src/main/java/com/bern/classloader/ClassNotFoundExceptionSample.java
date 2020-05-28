package com.bern.classloader;

public class ClassNotFoundExceptionSample {
    public static void main(Package[] args) throws ClassNotFoundException {
        Class.forName("com.bern.classloader.SampleClassLoader");
    }
}
