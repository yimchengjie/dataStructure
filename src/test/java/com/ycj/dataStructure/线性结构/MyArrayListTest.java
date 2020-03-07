package com.ycj.dataStructure.线性结构;

import org.junit.*;
/**
 * MyArrayListTest
 */

public class MyArrayListTest {

    @Test
    public void test(){
        MyArrayList<Integer> list=new MyArrayList<>();
        for (int i = 1; i < 17; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.add(5, 100);
        System.out.println(list);

        System.out.println("元素100的下标是: "+list.indexOf(100));

        System.out.println("下标为5的位置的元素: "+list.get(5));

        System.out.println("移除的元素是: "+list.remove(0));
        System.out.println(list);

        System.out.println("是否包含元素16: "+list.contains(16));

        System.out.println("set方法--这个位置原来的元素是: "+list.set(0,50));
        System.out.println(list);

        System.out.println("数组是否为空: "+list.isEmpty());

        list.clear();
        System.out.println("clear后,数组是否为空: "+list.isEmpty());

        list.add(null);
        System.out.println(list);
        System.out.println("null元素的位置是: "+list.indexOf(null));
    }
}
