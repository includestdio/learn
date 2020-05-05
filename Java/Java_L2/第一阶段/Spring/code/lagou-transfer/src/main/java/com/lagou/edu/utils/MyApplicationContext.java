package com.lagou.edu.utils;


import com.alibaba.druid.util.StringUtils;
import com.lagou.edu.config.MyService;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyApplicationContext {

    private String packageName;

    private ConcurrentHashMap<String,Class<?>> beans = null;

    public MyApplicationContext(String packageName) throws Exception {
        beans = new ConcurrentHashMap<String,Class<?>>();
        this.packageName = packageName;
        initBeans();
    }

    public Object getBean(String beanId) throws Exception {
        if (StringUtils.isEmpty(beanId)){
            throw new Exception("beanId参数不能为空");
        }
        //1、从spring容器获取bean
        Class<?> classInfo = beans.get(beanId);
        if (classInfo == null){
            throw new Exception("class not found");
        }
        //2、使用反射机制初始化对象
        return newInstance(classInfo);
    }

    //初始化对象
    public Object newInstance(Class<?> classInfo) throws Exception {
        return classInfo.newInstance();
    }

    public void initBeans() throws Exception{
        //1、使用Java的反射机制扫包，获取当前包下所有的类
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        //2、判断类上是否存在注入bean的注释
        ConcurrentHashMap<String, Class<?>> classExisAnnotation = findClassExisAnnotation(classes);
        if (classExisAnnotation == null || classExisAnnotation.isEmpty()){
            throw new Exception("该包下没有任何类加上注解");
        }
        //3、使用Java的反射机制进行初始化

    }

    public ConcurrentHashMap<String,Class<?>> findClassExisAnnotation(List<Class<?>> classes){
        for (Class<?> classInfo : classes){
            //判断类上是否有注释
            MyService annotation = classInfo.getAnnotation(MyService.class);
            if (annotation != null){
                //获取当前类名
                String className = classInfo.getSimpleName();
                String beanId = toLowerCaseFirstOne(className);
                beans.put(beanId,classInfo);
            }
        }
        return beans;
    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
