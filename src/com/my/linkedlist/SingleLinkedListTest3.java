package com.my.linkedlist;

import java.util.Stack;

/**
 * 逆序打印单链表的数据 ，没有改变链表本身的结构
 *
 * @author gjq
 * @create 2019-09-17-10:50
 */
public class SingleLinkedListTest3 {

    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入英雄
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        //显示数据
        singleLinkedList.list();

        //测试逆序打印单链表，没有改变链表本身的结构
        System.out.println("逆序打印单链表为：");
        reversePrint(singleLinkedList.getHead());

        System.out.println("原来的单链表为");
        singleLinkedList.list();

    }

    //利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果.
    public static void reversePrint(HeroNode head) {
        //判断链表是否为空
        if (head.next == null) {
            return; //空链表
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next; //定义辅助变量，
        //将链表的所有节点压入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next; //让cur后移，指向下一个节点
        }
        //将栈中的节点进行打印
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
