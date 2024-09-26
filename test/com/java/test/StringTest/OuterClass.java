package com.java.test.StringTest;

/**
 * @author shadow
 * @create 2024-09-01 20:45
 **/
public class OuterClass {

    class InnerClass {
    }

    static class StaticInnerClass {

        private static final String TEST = "123";
    }

    public static void main(String[] args) {
        // InnerClass innerClass = new InnerClass(); // 'OuterClass.this' cannot be referenced from a static context
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

}
