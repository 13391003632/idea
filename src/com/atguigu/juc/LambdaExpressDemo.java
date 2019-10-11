package com.atguigu.juc;

/**
 * @author qjx
 * @create 2019-10-11 19:44
 **/
@FunctionalInterface
interface  Foo{
    public int add(int x,int y);

    default int div(int x,int y){
        return x/y;
    }
    static int mul(int x ,int y){
        return x*y;
    }
}
public class LambdaExpressDemo {
    public static void main(String[] args) {
    Foo foo=(int x,int y) -> {
        System.out.println("*****come in add method");
        return  x+y;
    };
        System.out.println(foo.add(3,5));
        System.out.println(foo.div(10,2));
        System.out.println(Foo.mul(2,3));
    }
}
