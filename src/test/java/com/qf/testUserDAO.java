package com.qf;

import com.qf.dao.UserDAO;
import com.qf.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 2019/10/2911:18
 * <p>
 * 未知的事情 永远充满变数
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testUserDAO {

        @Test
        public void test(){
            ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
            UserDAO userDAO = context.getBean("userDAO",UserDAO.class);
            User user = userDAO.queryUsername("admin");
            System.out.println(user);

        }


        @Test
        public void test29(){
            ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
            UserDAO userDAO = context.getBean("userDAO",UserDAO.class);
            List<String> list = userDAO.queryByUsername("admin");
            for (String s : list) {
                System.out.println(s);
            }
        }

}
