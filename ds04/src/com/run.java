package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class run {
    public static void main(String[] args) {
//        ArrayStack arrayStack = new ArrayStack(5);
//        arrayStack.push(1);
//        arrayStack.push(2);
//        arrayStack.push(3);
//        arrayStack.push(4);
//        arrayStack.showStack();
//        System.out.println("--------------");
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.showStack();
//        System.out.println("--------------");
//        arrayStack.push(3);
//        arrayStack.push(4);
//        arrayStack.push(5);
//        arrayStack.push(6);
//        System.out.println("---------------");
//        arrayStack.showStack();
//        String exp = "100+2*6-2";
//        ArrayStack.calculator(exp);
//        System.out.println(int.class);
//        System.out.println(Integer.class);
//        System.out.println(Integer.TYPE);
//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = true?a:b;
//        int e = true?a:b;
        //System.out.println(d.getClass());

        String exp = "3 4 + 5 * 6 - ";
        ReversePolandNotationCal.cal(ReversePolandNotationCal.getExpList(exp));
        String exp1 = "1 + ( ( 2 + 3 ) * 4 ) - 5 ";
        //System.out.println(ReversePolandNotationCal.getExpList(exp1));
        ReversePolandNotationCal.toSuffixExp(exp1);


    }
}
@SuppressWarnings({"all"})
class ArrayStack
{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull()
    {
        return top == maxSize-1;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public void push(int value)
    {
        if(isFull())
        {
            System.out.println("栈满 无法添加");
            return;
        }
        stack[++top] = value;
    }

    public int pop()
    {
        if(isEmpty())
        {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    public void showStack()
    {
        if(isEmpty())
        {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.println(stack[i]);
        }
    }

    public static int priority(int oper)
    {
        if(oper == '*' || oper == '/')//char 和 int 是可以比较的
        {
            return 1;
        }
        return 0;
    }

    public static boolean isOper(char val)
    {
        return val == '+' || val == '-' || val == '*' || val == '/' ;
    }

    public int showTop()//该方法用来显示栈顶元素
    {
        return stack[top];
    }

    public static int cal(int num1,int num2,int oper)
    {
        int res = 0;
        switch(oper)
        {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//注意顺序
                break;
        }
        return res;
    }

    public static void calculator(String exp)
    {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";//用来保存可能是多位数情况的数字
        int length = exp.length();
        for(int i = 0;i<length;i++)
        {
            ch = exp.charAt(i);
            if(!isOper(ch))//是数字就入栈
            {
                if(i == length-1)//如果是最后一个数字 那就直接入栈 如果还向后找 就会发生越界
                {
                    numStack.push(Integer.parseInt(ch+""));
                }
                else
                {
                    if(!isOper(exp.charAt(i+1)))//后一位不是符号就拼接到keepNum后
                    {
                        keepNum += ch;
                    }
                    else//后一位是符号 就入栈
                    {
                        keepNum += ch;
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";//清空keepNum
                    }
                }
            }
            else//符号有三种情况
            {
                if(operStack.isEmpty())
                {
                    operStack.push(ch);//栈空直接入栈
                    continue;//符号入栈后 直接进行下一次循环
                }
                if(priority(ch) <= priority(operStack.showTop()))
                {
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    oper = operStack.pop();
                    res = cal(num1, num2, oper);
                    numStack.push(res);//结果入数栈
                    operStack.push(ch);//当前符号入符号栈
                }
                else
                {
                    operStack.push(ch);
                }
            }
        }//至此 表达式扫描完毕
        while(!operStack.isEmpty())//最终数栈只有一个数字 即表达式结果 符号栈为空
        {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1, num2, oper);
            numStack.push(res);//结果入数栈
        }
        System.out.println("传入的表达式结果为 : " + numStack.pop());
    }

}


class ReversePolandNotationCal
{
    public static List<String> getExpList(String exp)//该方法将表达式串转成数组列表 方便操作
    {
        String[] split = exp.split(" ");//这里为了方便处理 我们默认传入的表达式的数字和符号间有空格
        ArrayList<String> list = new ArrayList<>();
        for (String element : split) {
            list.add(element);
        }
        return list;
    }

    public static void cal(List<String> list)//核心方法 这里我们使用库中的栈
    {
        Stack<String> stack = new Stack<>();
        for (String s :list) {
            if(s.matches("\\d+"))//数字
            {
                stack.push(s);//入栈
            }
            else
            {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (s)
                {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;//注意顺序
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;//注意顺序
                        break;
                }
                stack.push(res+"");
            }
        }
        System.out.println("传入的表达式结果为 : " + stack.pop());
    }

    public static void toSuffixExp(String exp)
    {
        List<String> expList = getExpList(exp);
        Stack<String> s1 = new Stack<>();//运算符栈
        //Stack<String> s2 = new Stack<>();//中间结果栈
        ArrayList<String> s2 = new ArrayList<>();//由于整个过程中中间结果栈没有用到pop和push 且最后还需要逆序 故直接使用数字列表
        for(String s : expList)
        {
            if(s.matches("\\d+"))//数字的情况
            {
                s2.add(s);
            }
            else//符号的情况
            {
                if(s1.empty() || s.equals("("))//4.1
                {
                    s1.push(s);
                }
                else if(s.equals(")"))//5.2
                {
                    while(!s1.peek().equals("("))
                    {
                        s2.add(s1.pop());
                    }
                    s1.pop();//最后弹出左括号
                }
                else if(ArrayStack.priority(s.charAt(0)) > ArrayStack.priority(s1.peek().charAt(0))
                        || s1.peek().equals("("))//4.2
                {
                    s1.push(s);
                }
                else//4.3
                {
                    while(!s1.empty())
                    {
                        s2.add(s1.pop());
                    }
                    s1.push(s);//运算符入栈
                }
            }
        }
        while(!s1.empty())
        {
            s2.add(s1.pop());//7
        }
        System.out.println(s2);//8
    }

}