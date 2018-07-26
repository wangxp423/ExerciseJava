package com.xp.java.datastructures.set_map.map;

/**
 * @类描述：Map 接口
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 14:22
 * @修改人：
 * @修改时间：2018/7/26 0026 14:22
 * @修改备注：
 */
public interface Map<K, V> {
    void add(K key, V val);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
