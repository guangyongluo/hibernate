package com.vilin.hibernate.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/*
 * 使用hibernate进行持久化操作的步骤
 */
public class UsetTest {

	private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事物
        transaction = session.beginTransaction();
    }

    @After
    public void destory() {
        //提交事物
        transaction.commit();
        //关闭会话
        session.close();
        //关闭会话工厂
        sessionFactory.close();
    }
    
    @Ignore
    @Test
    public void testSaveStudents() {
        //生成学生对象
        User user = new User(null, "张三丰", "男", 23);
        System.out.println(user);
        session.save(user);
        System.out.println(session);
    }
}
