package com.my.linkedlist;

/**
 * 单链表的反转
 *
 * @author gjq
 * @create 2019-09-17-10:50
 */
public class SingleLinkedListTest2 {

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


        //测试单链表的反转
        System.out.println("反转后的单链表为：");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();


    }


    //单链表的反转
    public static void reverseList(HeroNode head) {
        //如果当前链表为空或者只有一个节点，则无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助变量，帮助遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点cur节点的下一个节点，如果没有，当单链表中节点移动后就不能找到原来的链表的下一个节点，链表就会断掉
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的单链表，每遍历一个节点，就将其取出，并放在新的单链表reverseHead的最前端
        while (cur != null) {
            next = cur.next;  //先暂时保存当前节点的下一个节点,后面需要使用
            cur.next = reverseHead.next; //将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;  //将cur连接到新的链表上
            cur = next; //让cur后移，指向下一个节点

        }
        //将head.next指向reverseHead.next,实现了单链表的反转
        head.next = reverseHead.next;

    }


}
