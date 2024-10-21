package com.java.test.jvm;

/**
 * @author shadow
 * @create 2024-04-27 20:15
 **/
public class TestVm {

    public static void main(String[] args) {
        //补充
        byte[] b=new byte[5*1024*1024];
        System.out.println("分配了1M空间给数组");
        System.out.print("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");
    }

}
