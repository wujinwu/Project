# JAVA数据结构和算法

## 稀疏数组

1.解决问题  
![稀疏数组解决问题及介绍](稀疏数组解决问题及介绍.jpg)
2.稀疏数组模型及思路分析
![稀疏数组模型及思路分析](稀疏数组模型及思路分析.jpg)

```java
package com.datastructure;

public class tests {
    void spareArray() {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        System.out.println("原始二维数组");

        //遍历数组，得到非0的数据的个数
        int sum = 0;
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }

        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][sum + 1];
        sparseArray[0][0] = arr.length;//二维数组的行
        sparseArray[0][1] = arr[0].length;//二维数组的列
        sparseArray[0][2] = sum;           //二维数组不为0的个数
        //记录不为0的数值的所在的位置
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arr[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("原始二维数组转换得到的稀疏数组");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组在转原始数组
        int[][] arr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            arr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("x疏数组转换的二维数组");
        for (int[] row : arr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
```  

## 数组模拟队列
1.银行排队系统
2.队列是一个有序列表,遵循先进先出
![数组模拟队列](数组模拟队列.jpg)
### 数组模拟队列案例
```java
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

```
### 问题 数组不能复用，使用一次就不能使用了，没有达到循环使用的作用
#### 使用数组模拟环形队列
![环形队列思路分析](环形队列思路分析.jpg)
```java
package com.datastructure;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //spareArray();
        CircleQueue arrayQueue = new CircleQueue(3);
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

class CircleQueue {

    //数组模拟队列
    int arrayMax;//队列最大值
    int front;//指向队列的第一个元素,默认为0
    int rear;//指向队列的最后的一个元素的后一个位置,空出一个空间做约定,队列满时（rear + 1)%arrayMax=front;队列空rear == front
    int[] arr;//模拟队列的数组

    public CircleQueue(int arrayMaxSize) {
        arrayMax = arrayMaxSize;
        arr = new int[arrayMaxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否满了
     */
    public boolean isFull() {
        return front == (rear + 1) % arrayMax;
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
        //先用value先保存front数组位置的值
        //然后对front + 1,取模防止数组越界
        //然后返回value
        int value = arr[front];
        front = (front + 1) % arrayMax;
        return value;
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
        arr[rear] = n;
        //rear是队列最后一个位置 + 1，所有需要取模，否则会数组越界
        rear = (rear + 1) % arrayMax;
    }

    /**
     * 显示队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空,无数据");
            return;
        }
        System.out.printf("front[%d] = rear[%d] \n", front, rear);
        for (int i = front; i < front + size(); i++) {
            //i % arrayMax 因为是环形队列，所有需要取模，防止数组越界
            System.out.printf("arr[%d] = %d \n", i % arrayMax, arr[i % arrayMax]);
        }
    }

    /**
     * 环形数组有效的数据的个数
     */
    public int size() {
        return (rear + arrayMax - front) % arrayMax;
    }

    /**
     * 队列头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front];
    }
}
```







