package com.ycj.dataStructure.线性结构;

import com.ycj.dataStructure.工具人.Person;

import org.junit.Test;

/**
 * MyLinkedListTest
 */
public class MyCycleSingleLinkedListTest {

    @Test
    public void test() {
        Person p1 = new Person("1", "person1");
        Person p2 = new Person("2", "person2");
        Person p3 = new Person("3", "person3");
        Person p4 = new Person("4", "person4");
        Person p5 = new Person("5", "person5");
        MyCycleSingleLinkedList<Person> linkedList = new MyCycleSingleLinkedList<>();
        linkedList.add(p1);
        linkedList.add(p2);
        linkedList.add(p3);
        linkedList.add(p4);
        // linkedList.add(p5);
        System.out.println(linkedList);

        linkedList.add(0, p5);
        System.out.println("在0位置添加p5后, " + linkedList);

        System.out.println("链表是否包含p1: " + linkedList.contains(p1));

        System.out.println("4位置的元素是: " + linkedList.get(4));

        System.out.println("p1元素所在位置是: " + linkedList.indexOf(p1));

        System.out.println("链表是否为空: " + linkedList.isEmpty());

        linkedList.remove(0);
        System.out.println("删除0位置的元素后, " + linkedList);

        linkedList.set(0, p5);
        System.out.println("修改0位置元素为p5后, " + linkedList);

        linkedList.clear();
        System.out.println("清空后是否为空, "+linkedList.isEmpty());

        linkedList.remove(0);
    }
}