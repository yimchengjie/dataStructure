package com.ycj.dataStructure.线性结构;

import com.ycj.dataStructure.工具人.Person;

import org.junit.Test;

/**
 * MyDequeTest
 */
public class MyDequeTest {

    @Test
    public void test(){
        Person p1 = new Person("1", "person1");
        Person p2 = new Person("2", "person2");
        Person p3 = new Person("3", "person3");
        Person p4 = new Person("4", "person4");
        Person p5 = new Person("5", "person5");
        MyDeque<Person> linkedList = new MyDeque<>();
        linkedList.enQueueFront(p1);
        linkedList.enQueueFront(p2);
        linkedList.enQueueRear(p3);
        linkedList.enQueueRear(p4);
        linkedList.enQueueFront(p5);
        System.out.println(linkedList);

        System.out.println(linkedList.size());

        System.out.println("头部出队 " + linkedList.deQueueFront());
        System.out.println("获取队首元素 " + linkedList.front());
        System.out.println("尾部出队 " + linkedList.deQueueRear());
        System.out.println("获取队尾元素 " + linkedList.rear());

        System.out.println(linkedList);

        System.out.println("队列是否为空: " + linkedList.isEmpty());

        System.out.println(linkedList.size());

        System.out.println("首出队 " + linkedList.deQueueFront());
        System.out.println("首出队 " + linkedList.deQueueFront());
        System.out.println("首出队 " + linkedList.deQueueFront());
        System.out.println("栈是否为空: " + linkedList.isEmpty());

    }
}