package com.my.queue;

import java.util.Scanner;

/**
 * 数组组成的队列的模拟
 *
 * @author gjq
 * @create 2019-09-16-18:18
 */
public class ArrayQueueTest1 {

    public static void main(String[] args) {

        //测试
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show)显示队列");
            System.out.println("e(exit)退出程序");
            System.out.println("a(add)添加数据到队列");
            System.out.println("g(get)从队列取出数据");
            System.out.println("h(head)查看队列头的数据");
            System.out.println("请输入选择:");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':  //取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据为: " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看数据头的信息
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数据为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                   scanner.close();
                   loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序结束");

    }
}


//使用数组模拟队列
class ArrayQueue {
    private int maxSize;  //数组的最大容量
    private int front;  //队列头
    private int rear; //队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造器

    public ArrayQueue(int arrmaxSize) {
        this.maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;   //指向队列头部，front是指向队列头部的前一个位置
        rear = -1;    //指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能添加数据");
            return;
        }
        rear++;  //让rear后移
        arr[rear] = n;
    }


    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列为空，不能取出数据");
        }
        front++; //让front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {

        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }


    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }


}