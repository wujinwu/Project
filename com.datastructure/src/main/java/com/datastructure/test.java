package com.datastructure;

import javax.management.RuntimeErrorException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //spareArray();
        ArrayQueue arrayQueue = new ArrayQueue(5);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    try {
                        int n = scanner.nextInt();
                        arrayQueue.addQueue(n);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int q = arrayQueue.removeQueue();
                        System.out.printf("取出来的的数据是%d\n", q);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int q = arrayQueue.headQueue();
                        System.out.printf("取出来的的数据是%d\n", q);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.exit(0);
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue {

    //数组模拟队列
    int arrayMax;//队列最大值
    int front;//队列头
    int rear;//队列尾
    int[] arr;//模拟队列的数组

    public ArrayQueue(int arrayMaxSize) {
        arrayMax = arrayMaxSize;
        arr = new int[arrayMaxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否满了
     */
    public boolean isFull() {
        return front == arrayMax - 1;
    }

    /**
     * 判断队列是否空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 队列取数
     */
    public int removeQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    /**
     * 添加数进入队列
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 显示队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空,无数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d", i, arr[i]);
        }
    }

    /**
     * 队列头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front + 1];
    }
}


