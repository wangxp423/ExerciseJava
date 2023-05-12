package com.xp.java.exercise;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/28 0028 17:59
 * @修改人：
 * @修改时间：2018/9/28 0028 17:59
 * @修改备注：
 */
public class TestClassLoader {
    static class Father {
        public static final String TAG = "Father";

        static {
            System.out.println("static Father");
        }

        {
            System.out.println("unStatic Father");
        }

        public Father() {
            System.out.println("constract Father");
            method();
        }

        public void method() {
            System.out.println("method Father");
        }

        @Override
        public String toString() {
            return "toString Father";
        }
    }

    static class Son extends Father {
        static {
            System.out.println("static Son.before");
        }

        public static Son instance = new Son();

        static {
            System.out.println("static Son");
        }

        {
            System.out.println("unStatic Son");
        }

        public Son() {
            System.out.println("constract Son");
            method();
        }

        public void method() {
            System.out.println("method Son");
        }

        @Override
        public String toString() {
            return "toString Son";
        }
    }

    //父类静态代码块 =》 子类静态代码块 =》 父类代码块 =》 父类构造方法 =》 子类代码块 =》 子类构造方法
    //如果存在多个静态域 按照前后顺序执行
    //静态域只执行一次，代码块每次new都执行
    public static void main(String[] args) {
        System.out.println("1.---------------------");
        System.out.println(Son.TAG);
        Son[] sons = new Son[10];
        System.out.println(sons);
        System.out.println("2.---------------------");
        System.out.println(Son.instance);
        System.out.println("3.---------------------");
        Son son = new Son();
        Father father = son;
        father.method();
        System.out.println(son);
    }
}
