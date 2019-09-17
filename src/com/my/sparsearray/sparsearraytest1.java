package com.my.sparsearray;

import java.io.*;

/**
 * 稀疏数组
 *
 * @author gjq
 * @create 2019-09-16-14:18
 */
public class sparsearraytest1 {


    public static void main(String[] args) {

        //创建一个原始的二维数组  11 *  11
        // 0表示没有棋子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组为：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数组转化为稀疏数组
        //1.先遍历二维数组，得到非0的数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("二维数组中非0的数据个数 = " + sum);

        //2.创建稀疏数组
        int sparseArr2[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr2[0][0] = 11;
        sparseArr2[0][1] = 11;
        sparseArr2[0][2] = sum;
        //遍历二维数组，将非0的值存入到sparseArr2中
        int count = 0; //用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr2[count][0] = i;
                    sparseArr2[count][1] = j;
                    sparseArr2[count][2] = chessArr1[i][j];
                }
            }
        }
        //打印稀疏数组
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparseArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr2[i][0], sparseArr2[i][1], sparseArr2[i][2]);
        }
        System.out.println();


        // 稀疏数组存入文件中
        File file = new File("E:\\map.txt");
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < sparseArr2.length; i++) {
                stringBuilder.append(sparseArr2[i][0] + "  " + sparseArr2[i][1] + "  " + sparseArr2[i][2] + "\r\n");
            }
            fileOutputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println("从文件中读取的信息为：");
        //从文件中读取数组信息
        FileReader fr = null;
        BufferedReader br = null;
        int[][] sparseArr3 = new int[4][3];

        try {

            //FileReader流的实例化
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String string = "";
            String[] arr1 = null;
            int t = 0;

            while ((string = br.readLine()) != null) {
                arr1 = string.split("  ");
                sparseArr3[t][0] = Integer.valueOf(arr1[0]);
                sparseArr3[t][1] = Integer.valueOf(arr1[1]);
                sparseArr3[t][2] = Integer.valueOf(arr1[2]);
                t++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源的关闭操作
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("从文件读取的稀疏数组为：");
        for (int i = 0; i < sparseArr3.length; i++) {
            for (int j = 0; j < sparseArr3[0].length; j++) {
                System.out.print(sparseArr3[i][j] + "\t");
            }
            System.out.println();
        }

        //将稀疏数组恢复为原始的二维数组
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
        //2. 再读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
        System.out.println("恢复为原始的二维数组为：");
        //先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr3[0][0]][sparseArr3[0][1]];
        //读取稀疏数组后几行的数据
        for (int i = 1; i < sparseArr3.length; i++) {

            chessArr2[sparseArr3[i][0]][sparseArr3[i][1]] = sparseArr3[i][2];
        }
        //输出恢复后的二维数组
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

}
