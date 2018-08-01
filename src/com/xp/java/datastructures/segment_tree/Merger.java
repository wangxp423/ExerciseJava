package com.xp.java.datastructures.segment_tree;

/**
 * @类描述：求和接口
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/1 0001 10:31
 * @修改人：
 * @修改时间：2018/8/1 0001 10:31
 * @修改备注：
 */
public interface Merger<T> {
    T merge(T a, T b);
}
