package com.ycj.dataStructure.线性结构;

import com.ycj.dataStructure.工具人.Person;

import org.junit.Test;

/**
 * MyStackTest
 */
public class MyStackTest {

    @Test
    public void test(){
        Person p1 = new Person("1", "person1");
        Person p2 = new Person("2", "person2");
        Person p3 = new Person("3", "person3");
        Person p4 = new Person("4", "person4");
        Person p5 = new Person("5", "person5");
        MyStack<Person> linkedList = new MyStack<>();
        linkedList.push(p1);
        linkedList.push(p2);
        linkedList.push(p3);
        linkedList.push(p4);
        linkedList.push(p5);
        System.out.println(linkedList);

        System.out.println(linkedList.size());

        System.out.println("栈顶 " + linkedList.top());
        System.out.println("栈顶 " + linkedList.pop());
        System.out.println("栈顶 " + linkedList.top());
        System.out.println("栈顶 " + linkedList.pop());

        System.out.println("栈是否为空: " + linkedList.isEmpty());

        System.out.println(linkedList.size());

        System.out.println("栈顶 " + linkedList.pop());
        System.out.println("栈顶 " + linkedList.pop());
        System.out.println("栈顶 " + linkedList.pop());
        System.out.println("栈是否为空: " + linkedList.isEmpty());

    }
}