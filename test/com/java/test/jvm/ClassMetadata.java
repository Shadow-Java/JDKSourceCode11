package com.java.test.jvm;

/**
 * @author shadow
 * @create 2024-04-27 17:33
 **/
public class ClassMetadata {
    /**
     * java7之前存在永久代中；java8之后将字符串常量池和类静态变量存在堆中，将类元信息存放在本地内存中；
     * 使用static修饰的为静态变量，属于类信息，存放在堆中的字符串常量池中；
     * 类元信息包含类的结构和属性，如类名、字段、方法等，存放在本地内存
     */
    public static final String CONSTANT_STRING = "Hello";
    private int myField;
    String str1 = "Hello";  // 字符串常量池中创建了"Hello"对象
    String str2 = "Hello";  // 直接从字符串常量池中获取了相同的"Hello"对象

    public void myMethod() {
        // 方法体
        String sc ="STORAGE_CONTROLLER";
        //存放在堆中的字符串常量池中
        String str3= "Hello";
        /**
         * 不管是存在方法栈帧里面的还是存放在方法外部的字符串，都存放在字符串常量池中；只是方法中的变量在方法结束之后会会被销毁
         */
        System.out.println(str3==str1);
        System.out.println(CONSTANT_STRING==str3);
        System.out.println("Hello"==CONSTANT_STRING);
    }

    public static void main(String[] args) {
        ClassMetadata classMetadata = new ClassMetadata();
        classMetadata.myMethod();
        System.out.print("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    }

}
