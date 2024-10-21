package com.java.test.StringTest;

/**
 * @author shadow
 * @create 2024-09-01 15:14
 **/
public class DemoTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(e2.toString()+":"+e1.toString());
        System.out.println(e1.equals(e2));
        e1.set(2, 222);
        //浅拷贝:拷贝对象和原始对象的引用类型引用同一个对象
        System.out.println(e2.get(2));
        System.out.println(e1.getArr() == e2.getArr());//true引用的字段是同一个，但是是不同对象
        DeepCloneExample de1 = new DeepCloneExample();
        DeepCloneExample de2 = null;
        try {
            de2 = de1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //深拷贝:拷贝对象和原始对象的引用类型引用不同对象
        de1.set(2, 222);
        System.out.println(de2.get(2)); // 2
        //向上转型是自动的:子类转父类
        Anaimal anaimal = new Cat();
        System.out.println(anaimal.toString());
        //向下转型是需要显示指定，且必须要为子类的实例，可能Anaimal上面还有父类
        Cat cat = (Cat) anaimal;
        System.out.println(cat.toString());
    }
}
