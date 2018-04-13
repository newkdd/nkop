package com.newkdd.framework.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 2017/8/23.
 */
public class BeanUtils {

    /**
     * 根据现有对象的属性创建目标对象，并赋值
     * @param source
     * @param target
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T copyObject(Object source,Class<T> target) {
        T temp = null;
        try {
            temp = target.newInstance();
            if(null != source) {
                org.springframework.beans.BeanUtils.copyProperties(source, temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static Object copyObject(Object source,Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source,target);
        return  target;
    }

    /**
     * 拷贝集合
     * @param source
     * @param target
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T,S> List<T> copyList(List<S> source,Class<T> target){
        List<T> list = new ArrayList<>();
        if(null != source && source.size() > 0) {
            for (Object obj : source) {
                list.add(BeanUtils.copyObject(obj,target));
            }
        }
        return list;
    }

    public static Map<String, String> describe(Object record)throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        return org.apache.commons.beanutils.BeanUtils.describe(record);
    }

}
