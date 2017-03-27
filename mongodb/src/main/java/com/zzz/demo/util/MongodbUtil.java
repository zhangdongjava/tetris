package com.zzz.demo.util;

import com.mongodb.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zd on 2017/3/24.
 */
public class MongodbUtil {
    static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static Object runJs(String js, String dbName) {
        Mongo mongo = context.getBean(Mongo.class);
        DB db = new DB(mongo, dbName);
        return db.eval(js);
    }

    public static void main(String[] args) {
        DB db = new DB(context.getBean(Mongo.class), "test");
        Object o = db.eval("db.getCollection(\"user\").find({})");
        DBCursor list = db.getCollection("user").find();
        for (DBObject dbObject : list) {
            System.out.println(dbObject);
        }

    }
}
