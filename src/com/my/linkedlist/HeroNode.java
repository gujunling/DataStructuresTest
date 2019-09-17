package com.my.linkedlist;

/**
 * 定义HeroNode，每个HerdNode对象就是一个节点
 *
 * @author gjq
 * @create 2019-09-16-22:20
 */
public class HeroNode {

    public int no;  //编号
    public String name;  //姓名
    public String nickname;  //昵称
    public HeroNode next; //指向下一个节点


    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，重写tostring()
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
