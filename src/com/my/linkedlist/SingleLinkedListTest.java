package com.my.linkedlist;

/**
 * 单链表的实现
 *
 * @author gjq
 * @create 2019-09-16-22:20
 */
public class SingleLinkedListTest {

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
     /*   singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);*/


        //按照编号顺序添加英雄
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //显示数据
        singleLinkedList.list();

        //测试修改节点
        HeroNode newHeroNode = new HeroNode(2, "卢俊义111", "玉麒麟111");
        singleLinkedList.update(newHeroNode);

        //显示修改后的链表信息
        System.out.println("修改后的链表为：");
        singleLinkedList.list();


        //测试删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        //再次显示链表信息
        System.out.println("执行删除操作后的链表为");
        singleLinkedList.list();


        //测试，求单链表中有效节点的个数
        System.out.println("有效的节点个数为：" + getLength(singleLinkedList.getHead()));

        //测试是否找到了倒数第index个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("倒数第k个节点为" + res);


    }


    /**
     * 获取到单链表的所有节点的个数（如果是带头结点的链表，要把头节点去掉）
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {

        if (head.next == null) {  //表明此时的链表为空
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量,这里使用head.next表示没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }


    //查找单链表的倒数第k个节点（新浪的面试题）
    //编写一个方法，接收head节点，同时接收一个index，此时的index表示的是倒数第index个节点
    //先遍历整个单链表，得到链表的长度
    //得到链表的长度后，从链表的第一个开始遍历，遍历（总长度size- index）个即可。
    //如果找到了，返回该节点，找不到则返回空。
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        //第一次遍历得到链表的总长度size
        int size = getLength(head);
        //第二次遍历size - index 位置，此时就是倒数的第 k 个节点
        //先做index的校验
        if (index <= 0 || index > size) {
            System.out.println("请输入有效的值");
            return null;
        }
        //定义辅助变量temp,使用for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }



}

