package com.chiakimayuzumi.calculate;

import android.text.TextUtils;

import com.chiakimayuzumi.calculate.annotation.Calculate;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chiakimayuzumi on 2018/4/24.
 */

public class CalculateUtil {

    private String something;

    public CalculateUtil(String something) {
        this.something = something;
    }

    public <T> T create(Class<T> proxyClass) {
        return (T) Proxy.newProxyInstance(proxyClass.getClassLoader(), new Class[]{proxyClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                CalculateCell calculateCell = getCalculateCell(method,args);
                CalculateMethod calculateMethod = new CalculateMethod(calculateCell);
                Object result = calculateMethod.calculate();
                return result;
            }
        });
    }

    private CalculateCell getCalculateCell(Method method, Object[] args) {
        Annotation[] annotations = method.getAnnotations();
        return new CalculateCell(annotations[0],args);
    }

    // 建造者方法
    public static class Builder {
        private String something;

        public Builder(){}

        public Builder setSomething(String something) {
            this.something = something;
            return this;
        }

        public CalculateUtil build() {
            if (TextUtils.isEmpty(something)) {
                new CalculateUtil("say something");
            }
            return new CalculateUtil(something);
        }
    }
}
