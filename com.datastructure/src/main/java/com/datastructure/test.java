package com.datastructure;

public class test {
    public static void main(String[] args) {
        spareArray();
    }

    static void spareArray() {
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
        System.out.println("二维数组转换后的稀疏数组");
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

        System.out.println("稀疏数组转换为二维数组");
        for (int[] row : arr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
