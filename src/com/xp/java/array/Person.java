package com.xp.java.array;

/**
 * @类描述：
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/19 0019 9:49
 * @修改人：
 * @修改时间：2018/7/19 0019 9:49
 * @修改备注：
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayT<Person> persons = new ArrayT();
        persons.addLast(new Person("xiaopan", 29));
        persons.addLast(new Person("yanzi", 25));
        persons.addLast(new Person("ng", 3));
        System.out.println(persons);
    }
}
