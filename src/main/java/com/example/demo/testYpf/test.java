package com.example.demo.testYpf;

import com.example.demo.testYpf.interfaceTest.Shopping;
import com.example.demo.testYpf.interfaceTest.enumType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.Properties;

@Configuration
public class test implements Shopping {
    private static final Logger logger = LoggerFactory.getLogger(Shopping.class);


    @Override
    public void goShopping() {
        if ("Mon".equals(enumType.Mon))
        {
            System.out.println("去购物");

        }
    }

    @Override
    public void donNotShopping(int num) {
        int res = 5+2;
        System.out.println(res+"不去购物");
    }

    public static void testStatic(){
        String name = null;
        InputStream in = null;
        try{
            Properties properties = new Properties();
            in= test.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(in);
            name = properties.getProperty("UserName");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(in != null){
                try{
                    in.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            logger.info("name222"+name);


        }
    }

    public  void testStatic1(){
        int res = 5+2;
        String s = "11111";
        String a = s.replace("1","2");
        System.out.println(a);
        logger.info(res+"");
        System.out.println(res);
    }

    static{
        String name = null;
        InputStream in = null;
        try{
            Properties properties = new Properties();
            in= test.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(in);
            name = properties.getProperty("UserName");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(in != null){
                try{
                    in.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            logger.info("name1111"+name);
            enumType enumTypes = enumType.Mon;
            if ("Monday".equals(enumTypes.getDay()))
            {
                System.out.println("去购物");

            }

            logger.info("enum11sss1"+enumTypes.getDay());
            logger.info("enum222"+enumType.Mon);
        }
    }
}
