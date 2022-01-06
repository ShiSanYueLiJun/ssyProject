package com.ssy.project.example.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author LiJun
 * @date 2021-12-29 09:29
 * mybatis
 */
@Configuration
//@MapperScan("com.ssy.project.order.mapper")
public class MybatisObjectHandler extends DefaultSqlInjector implements MetaObjectHandler {

    /**
     * 增加通用方法 CommonMapper.deleteByIdWithFill()
     * @param mapperClass
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        //内置选装组件:批量插入
        methodList.add(new InsertBatchSomeColumn(i->i.getFieldFill()!= FieldFill.UPDATE));
        //根据id逻辑删除,并带字段填充功能，如果字段没有自动填充.则是单纯逻辑删除
        methodList.add(new LogicDeleteByIdWithFill());
        return methodList;
    }


    @Override
    public void insertFill(MetaObject metaObject) {
        //自动填充创建时间
        this.strictInsertFill(metaObject,"gmtCreate", Date.class,new Date());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //自动填充创建时间
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    /**
     * 根据业务自动填充id、no
     * @param metaObject
     */
    public void insertFillIdNo(MetaObject metaObject){
        Object originalObject = metaObject.getOriginalObject();
        Class<?>  clazz = originalObject.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();

        //父类属性
        Field[] superFields = clazz.getSuperclass().getDeclaredFields();
        //自己的属性与父类属性合并
        Stream<Field> allStreamFields = Stream.concat(Arrays.stream(declaredFields), Arrays.stream(superFields));
        Field[] allFields = allStreamFields.toArray(Field[]::new);

        //model上的注解 @TableName(value="xxx") 数据库中表名
        TableName annotation = clazz.getAnnotation(TableName.class);
        String tableValue = annotation.value();
        //列如 设置某个字段
        for(Field field:allFields){
            if(field.getName().equals("no")){
                metaObject.setValue(field.getName(), UUID.randomUUID().toString());
            }
        }


    }
}
