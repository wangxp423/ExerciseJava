package com.xp.java.exercise;

import java.util.ArrayList;
import java.util.List;

//泛型和通配符 及 extend super的边界
//https://blog.csdn.net/qq_41490274/article/details/122886351
public class TestTongPeiFu {
    public static class Fruit {
    }

    public static class Apple extends Fruit {
    }

    public static class Bananer extends Fruit {
    }

    public static class Plates<T extends Fruit> {
        public void addFruite(Plates<? super T> a) {

        }
    }

    public static void main(String[] args) {
        List<? super Fruit> plates = new ArrayList<>();
        plates.add(new Fruit());
        plates.add(new Apple());
        Plates t = new Plates<Apple>();
        Plates t1 = new Plates<Fruit>();
    }
}
