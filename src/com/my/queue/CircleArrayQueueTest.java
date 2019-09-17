package com.my.queue;

import java.util.Scanner;

/**
 * 数组的环形队列
 *
 * @author gjq
 * @create 2019-09-16-20:53
 */
public class CircleArrayQueueTest {

    public static void main(String[] args) {

        System.out.println("测试数组模拟环形队列");
        //创建一个队列
        CicleArrayQueue queue = new CicleArrayQueue(4);//此处设置为4，其队列的有效数据的最大值为3
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
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':  //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数据为: " + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看数据头的信息
                    try {
                        int res = queue.headQueue();
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
class CicleArrayQueue {
    private int maxSize;  //数组的最大容量
    private int front; //队列头,front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素，初值为0
    private int rear; //队列尾,rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定，初值为0
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造器

    public CicleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;

    }


    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列为空，不能取出数据");
        }
        //front是指向队列的第一个元素的
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移,考虑取模
        //将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {

        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

}