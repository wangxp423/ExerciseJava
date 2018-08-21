package com.xp.java.exercise;

/**
 * 多态
 * 多态三个必要条件
 * 1，继承
 * 2，重写
 * 3，父类引用指向子类对象
 * Created by Wang on 2018/1/15 0015.
 */
public class TestDuotai {
    public static class A{
        public A(){System.out.println("A");}
        public String show(D obj){ return "A and D";}
        public String show(A obj){ return "A and A";}
    }
    public static class B extends A{
        public B(){System.out.println("B");}
        public String show(B obj){ return "B and B";}
        public String show(A obj){ return "B and A";}
    }
    public static class C extends B{
        public C(){System.out.println("C");}
    }
    public static class D extends B{
        public D(){System.out.println("D");}
    }
    public static void main(String[] args){
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b));//A and A
        System.out.println(a1.show(c));//A and A
        System.out.println(a1.show(d));//A and D

        System.out.println(a2.show(b));//B and A
        System.out.println(a2.show(c));//B and A
        System.out.println(a2.show(d));//A and D

        System.out.println(b.show(b));//B and B
        System.out.println(b.show(c));//B and B
        System.out.println(b.show(d));//A and D
    }
}
