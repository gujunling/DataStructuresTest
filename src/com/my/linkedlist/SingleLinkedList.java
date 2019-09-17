package com.my.linkedlist;

/**
 * 定义SingleLinkedList,管理英雄人物
 *
 * @author gjq
 * @create 2019-09-16-22:20
 */
public class SingleLinkedList {


    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 返回头节点
     *
     * @return
     */
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //当不考虑编号的顺序时，
    //1.找到当前链表的最后节点
    //2.将最后的这个节点的next指向新的节点
    public void add(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后的节点
        while (true) {

            if (temp.next == null) {//找到链表的最后
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    //第二种添加英雄人物的方式，根据排名将英雄插入到指定位置,，如果有这个排名，则提示添加失败
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助变量来帮助找到添加的位置
        //因为是单链表，因此我们要找的temp是位于添加位置的前一个节点，否则插入不会成功。
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {  //说明此时的temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//说明此时位置已经找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明此时要添加的英雄排名已经存在，提示添加失败信息
                flag = true;   //说明编号已经存在
                break;
            }
            temp = temp.next;  //temp后移，相当于遍历当前的链表
        }
        //判断flag的值
        if (flag) { //此时flag为true，不能添加,说明编号存在
            System.out.println("待插入的英雄人物的编号" + heroNode.no + "已经存在，添加失败");
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }


    //修改节点的信息，根据编号no来修改，即编号no不能修改
    //根据newHeroNode的no来修改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据编号no进行修改
        //先定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//链表已经遍历结束
            }
            if (temp.no == newHeroNode.no) {
                //表示找到了该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) { //表示找到该节点，需要进行修改信息
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { //没有找到该节点
            System.out.println("没有找到编号为" + newHeroNode.no + "的节点，不能进行修改操作");

        }

    }

    //删除节点
    //head节点不能动，因此我们需要一个辅助节点temp来找到待删除节点的额前一个节点
    //在比较时，是temp.next.no 和待删除节点的 no相比较
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;//用于判断是否找到待删除节点的前一个节点
        while (true) {
            if (temp.next == null) {  //已经到链表的最后
                break;
            }
            if (temp.next.no == no) { //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历链表
        }
        //判断flag
        if (flag) {
            //找到了待删除节点的前一个节点temp,可以进行删除了
            temp.next = temp.next.next;
        } else {
            System.out.println("待删除的节点" + no + "不存在");
        }

    }


    //显示链表(遍历)
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }


}
