package com.xp.java.datastructures.set_map.set;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 9:36
 * @修改人：
 * @修改时间：2018/7/26 0026 9:36
 * @修改备注：
 */
public interface Set<T> {
    void add(T e);

    boolean contains(T e);

    void remove(T e);

    int getSize();

    boolean isEmpty();
}
