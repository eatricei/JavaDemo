package com.swj.algorithms;

/**
 * 使用尾递归的类 目的是对外统一方法
 * Created by swj on 2018/1/26.
 */
public class TailInvoke {
    /**
     * 统一结构的方法 获得当前递归的下一个递归
     * @param nextFrame 下一个递归
     * @param <T>
     * @return
     */
    public static <T> TailRecursion<T> call(final TailRecursion<T> nextFrame){
        return nextFrame;
    }

    /**
     * 结束当前递归 重写对应的默认方法的值 完成状态改为true 设置最终返回结果 设置非法递归调用
     * @param value 最终递归值
     * @param <T>
     * @return
     */
    public static <T> TailRecursion<T> done(T value){
        return new TailRecursion<T>() {
            @Override
            public TailRecursion<T> apply() {
                throw new Error("递归已经结束,非法调用apply方法");
            }

            @Override
            public boolean isFinished() {
                return true;
            }

            @Override
            public T getResult() {
                return value;
            }
        };
    }
}
