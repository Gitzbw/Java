package com;

/**
 * @author
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
        if(args.length != 2)
        {
            throw new ArrayIndexOutOfBoundsException("参数个数不对");
        }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            System.out.println(cal(n1,n2));
        } catch (NumberFormatException e) {
            System.out.println("数据格式不正确");
        }
        catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }
    }
    public static double cal(int n1,int n2)
    {
        return n1/n2;
    }
}


