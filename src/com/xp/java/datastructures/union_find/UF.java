package com.xp.java.datastructures.union_find;

/**
 * @类描述：并查集 一般就只有两个操作，所以可以定义一个通用接口
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/3 0003 10:44
 * @修改人：
 * @修改时间：2018/8/3 0003 10:44
 * @修改备注：
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
