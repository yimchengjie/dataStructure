package com.ycj.dataStructure.线性结构;

import com.ycj.dataStructure.工具人.Person;

import org.junit.Test;

/**
 * MyCycleQueueTest
 */
public class MyCycleQueueTest {

    @Test
    public void test(){
        Person p1 = new Person("1", "person1");
        Person p2 = new Person("2", "person2");
        Person p3 = new Person("3", "person3");
        Person p4 = new Person("4", "person4");
        Person p5 = new Person("5", "person5");
        MyCycleQueue<Person> linkedList = new MyCycleQueue<>();
        linkedList.enQueue(p1);
        linkedList.enQueue(p2);
        linkedList.enQueue(p3);
        linkedList.enQueue(p4);
        linkedList.enQueue(p5);
        linkedList.enQueue(p1);
        linkedList.enQueue(p2);
        linkedList.enQueue(p3);
        linkedList.enQueue(p4);
        linkedList.enQueue(p5);
        linkedList.enQueue(p1);
        linkedList.enQueue(p2);
        linkedList.enQueue(p3);
        linkedList.enQueue(p4);
        linkedList.enQueue(p5);
        System.out.println(linkedList);

        System.out.println(linkedList.size());

        System.out.println("出队 " + linkedList.deQueue());
        System.out.println("获取队首元素 " + linkedList.front());
        System.out.println("出队 " + linkedList.deQueue());
        System.out.println("获取队首元素 " + linkedList.front());

        System.out.println("队列是否为空: " + linkedList.isEmpty());

        System.out.println(linkedList.size());

        System.out.println("出队 " + linkedList.deQueue());
        System.out.println("出队 " + linkedList.deQueue());
        System.out.println("出队 " + linkedList.deQueue());
        System.out.println("出队 " + linkedList.deQueue());
        System.out.println("出队 " + linkedList.deQueue());
        System.out.println("栈是否为空: " + linkedList.isEmpty());


        linkedList.enQueue(p3);
        linkedList.enQueue(p4);
        linkedList.enQueue(p5);
        System.out.println(linkedList);

        while (!linkedList.isEmpty()) {
            System.out.println("出队 " + linkedList.deQueue());
        }

    }
}