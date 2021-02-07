package com.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        //定义一个逆波兰表达式
        String ex = "1+((2+3)*4)-5";
        List<String> ls = toInfix(ex);//1,+,(,(,2,+,3,),*,4,),-,5
        System.out.println(ls);

        //将得到的中缀表达式得到list 转  后缀表达式的list
       // List<String> ps = parseSuffix(ls);
      //  System.out.println(ps);
        //1.先将suffixExpression放入list中
        //2.用list传递方法中,配合栈完成计算
        //   List<String> rpnList = getListString(suffixExpression);
        //    System.out.println(rpnList);
        //  System.out.println(calculate(ls));
    }

    // 中缀表达式得到list 转  后缀表达式的list
    public static List<String> parseSuffix(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        // Stack<String> s2 = new Stack<>();//存储中间结果的栈
        //因为S2的栈没有pop操作，而且后面还需要逆序输出，比较麻烦，不用栈，直接用List替代
        ArrayList<String> alS2 = new ArrayList<>();
        for (String l : ls) {
            System.out.println(l);
            if (l.matches("\\d+")) {//多位数

                alS2.add(l);
            } else {
                switch (l) {
                    case "(":
                        //存入栈内
                        s1.push(l);
                        break;
                    case ")":
                        //直到碰到"("停止弹出
                        while (!s1.peek().equals("(")) {
                            alS2.add(s1.pop());
                        }
                        s1.pop();

                        break;
                    default:
                        if (s1.size() != 0 && Opertion.getValue(s1.peek()) >= Opertion.getValue(l)) {
                            //如果s1有数据，且运算符大于等于当前运算符，则弹出栈内所以运算符，存入S2
                            while (s1.size() != 0 && Opertion.getValue(s1.peek()) >= Opertion.getValue(l)) {
                                alS2.add(s1.pop());
                            }
                            //将当前运算符也存入S2
                            alS2.add(l);
                        } else {
                            //s1栈内没有数据，或者当前运算符大于栈内运算符,将 符号 压入栈内
                            s1.push(l);
                        }
                        break;
                }
            }
        }
        return alS2;
    }


    //将中缀表达式转为对应list
    public static List<String> toInfix(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0; //指针，用于遍历中缀表达式中的字符串
        String str;//多位数的拼接
        char c;//遍历到的字符，存入C
        do {
            //如果c是一个非数字

            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(s.charAt(i) + "");
                i++;
            } else {
                str = "";
                while (i < s.length() && ((c = s.charAt(i)) > 48 || (c = s.charAt(i)) < 57)) {
                    str = str + s.charAt(i);
                    i++;
                }

                ls.add(str);
            }
        } while (i < s.length());

        return ls;
    }

    //将逆波兰表达式，依次将数据和运算符放入list中
    public static List<String> getListString(String sf) {
        String[] sp = sf.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : sp) {
            list.add(s);
        }
        return list;
    }

    //完成运算
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String l : ls) {
            if (l.matches("\\d+")) {//多位数
                stack.push(l);//入栈
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (l) {
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    default:
                        System.out.println("运算符异常");
                        break;
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class Opertion {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String s) {
        switch (s) {
            case "*":
                return MUL;
            case "/":
                return DIV;
            case "+":
                return ADD;
            case "-":
                return SUB;
            default:
                System.out.println("运算符异常");
                return 0;
        }
    }
}






