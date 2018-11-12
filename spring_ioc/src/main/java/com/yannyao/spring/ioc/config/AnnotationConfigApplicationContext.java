package com.yannyao.spring.ioc.config;

import com.yannyao.spring.ioc.annotation.Autowired;
import com.yannyao.spring.ioc.annotation.Component;
import com.yannyao.spring.ioc.annotation.Qualifier;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationConfigApplicationContext implements ApplicationContext {

    private String projectPath=this.getClass().getResource("/").getPath();//项目路径
    private List<Class> clazzList;//包下所有类
    private List<String> filePaths;//包下所有文件名
    private Map<String,Class> existComponentClassMap;//含有@Component注解的类
    private Map<String,Class> existComponentValueClassMap;//含有@Qualifier值的类

    public AnnotationConfigApplicationContext(String... strings){
        System.out.println(projectPath);
        clazzList=new ArrayList<Class>();
        existComponentClassMap=new HashMap<String,Class>();
        existComponentValueClassMap=new HashMap<String,Class>();
        for (String tempPackageName : strings) {//遍历传进来的包
            filePaths=getFileName(projectPath+(tempPackageName.replaceAll("[.]","/")));
            try {
                //把扫描到包下的类都放入clazzList集合
                clazzList.addAll(getFileClass(filePaths)) ;
                //遍历所有类，看是否加了@Component
                isComponent();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Object getBean(Class clazz) {
        try {
            //判断传入的类是否加了@Component
            if(existComponentClassMap.get(clazz.getName())!=null){
                //解决clazz依赖并返回clazz的实例
                return isAutowired(clazz);
            }else{
                //抛出异常
                throw new Exception("not found "+clazz.getName()+" mapping class");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }



    //循环判断是否加了@Component
    private void isComponent(){
        for (Class tempClass : clazzList) {
            //判断该类是否加有@Component
            if(tempClass.isAnnotationPresent(Component.class)){
                //把加了@Component注解的类放入集合
                existComponentClassMap.put(tempClass.getName(),tempClass);
                Component component=(Component)tempClass.getAnnotation(Component.class);
                //得出@Component中的value
                String componentValue=component.value();
                //判断@Component中的value是否有值
                if(componentValue.length()>0){
                    //把@Component中的value和当前类的class放入Map集合中
                    existComponentValueClassMap.put(componentValue, tempClass);
                }
            }
        }
    }

    //循环判断加了Component注解类里面是否有加了@Autowired注解,和@Qualifier的属性或方法
    private Object isAutowired(Class clazz) throws Exception{
        //得到传入clazz的实例
        Object object=clazz.newInstance();
        //得到clazz的所有的属性
        Field fields[]=clazz.getDeclaredFields();
        //遍历所有属性
        for (Field field : fields) {
            //判断该属性是否加了@Autowired
            if(field.isAnnotationPresent(Autowired.class)){
                //判断该属性是否加了@Qualifier
                if(field.isAnnotationPresent(Qualifier.class)){
                    Qualifier qualifier=field.getAnnotation(Qualifier.class);
                    //使用@Qualifier的值从Map集合中拿出对该值对应的class
                    Class Tempclazz=existComponentValueClassMap.get(qualifier.value());
                    if(Tempclazz!=null){
                        //为属性设置赋值权限
                        field.setAccessible(true);
                        //为实例出来的clazz对象的该属性赋值，赋值之前再次递归调用本方法，传入该属性类型的class
                        field.set(object,isAutowired(Tempclazz));
                    }else{
                        throw new Exception("not found "+qualifier.value()+" mapping class");
                    }
                }else{
                    //得到该属性的类型
                    Class fieldType=field.getType();
                    Class Tempclazz=existComponentClassMap.get(fieldType.getName());
                    if(Tempclazz!=null){
                        field.setAccessible(true);
                        field.set(object,isAutowired(Tempclazz));
                    }else{
                        throw new Exception("not found "+fieldType.getName()+" mapping class");
                    }
                }
            }
        }
        return object;
    }

    //得到指定包下面的所有java文件路径
    public List<String> getFileName(String packgePath){
        List<String> filePaths=new ArrayList<String>();
        String filePath=packgePath;
        File file=new File(filePath);
        //判断是否为目录
        if(file.isDirectory()){
            //得到包下所有文件
            File files[]=file.listFiles();
            for (File file2 : files) {
                //判断是否为目录
                if(file2.isDirectory()){
                    //递归调用
                    filePaths.addAll(getFileName(file2.getPath()));
                }else{
                    //如果后缀为class则把该文件路径放入集合
                    if(file2.getName().substring(file2.getName().lastIndexOf(".")+1).equals("class")){
                        filePaths.add(file2.getPath());
                    }
                }
            }
        }
        return filePaths;
    }

    //返回所有java文件的class
    public List<Class> getFileClass(List<String> filePath) throws ClassNotFoundException{
        List<Class> list=new ArrayList<Class>();
        for (String tempFileName : filePath) {
            //从项目路径之后开始截取java文件名
            String tempClassName=tempFileName.substring(projectPath.length()-1);
            //把路径中的“\”替换成“.”例如“com\test\test.java”替换后“com.test.test.java”
            tempClassName=tempClassName.replaceAll("\\\\",".");
            //再把后面的“.java”截取掉 然后使用Class.forName得到该类的class,并放入集合
            list.add(Class.forName(tempClassName.substring(0,tempClassName.lastIndexOf("."))));
        }
        return list;
    }
}
