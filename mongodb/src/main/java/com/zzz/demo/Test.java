package com.zzz.demo;

import com.mongodb.*;
import com.zzz.demo.pojo.FdPojo;
import com.zzz.demo.pojo.MuScoreRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

/**
 * Created by zd on 2017/3/16.
 */
public class Test {



    public static void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
        // List<TJFDLog> list = mongoTemplate.findAll(TJFDLog.class, "tjfd");
        Aggregation agg = Aggregation.newAggregation(
                group("startDate").count().as("people")
                        .sum("score").as("score")
                        .sum("drill").as("drill")
                        .max("score").as("maxScore"),
                Aggregation.skip(0L),
                Aggregation.limit(3)

        );
        AggregationResults<FdPojo> ll = mongoTemplate.aggregate(agg, "tjfd", FdPojo.class);
        for (FdPojo tjfdLog : ll.getMappedResults()) {
            System.out.println(tjfdLog);
        }


    }

    public static void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
        long ss = System.currentTimeMillis();
        Object object = mongoTemplate.execute(db -> {
            Object object1 = db.eval("db.getCollection('userScore22').group({\n" +
                    " keyf:function(doc){return {groupDate:doc.insertDate.getFullYear()+\"-\"+(doc.insertDate.getMonth()+1)+\"-\"+doc.insertDate.getDate()}},\n" +
                    "  cond:{},\n" +
                    "  reduce:function(curr , result) {\n" +
                    "      if(curr.hour>result.hour){\n" +
                    "          result.score = curr.score;\n" +
                    "          result.hour = curr.hour;\n" +
                    "          result.dirll = curr.drill;\n" +
                    "      }\n" +
                    "  },\n" +
                    "  initial:{hour:0}\n" +
                    "})");
            return object1;
        });
        System.out.println(System.currentTimeMillis() - ss);
        System.out.println(com.alibaba.fastjson.JSON.parseArray(object.toString(), MuScoreRecord.class));
    }

    public static void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Mongo mongo = context.getBean(Mongo.class);
        DB db = new DB(mongo, "userEachHourScore");
        DBCollection collection = db.getCollection("userScore22");
        String keyf = "function(doc){return {groupDate:doc.insertDate.getFullYear()+\"-\"+(doc.insertDate.getMonth()+1)+\"-\"+doc.insertDate.getDate()}}";
        DBObject condition = new BasicDBObject();
        DBObject initial = new BasicDBObject();
        initial.put("hour", 0);
        String reduce = "function (curr, result) {\n" +
                "        if (curr.hour > result.hour) {\n" +
                "            result.score = curr.score;\n" +
                "            result.hour = curr.hour;\n" +
                "            result.dirll = curr.drill;\n" +
                "        }\n" +
                "    }";
        String finalize = "function(){}";
        GroupCommand groupCommand = new GroupCommand(
                collection,keyf,condition,initial,reduce,finalize
                );
        DBObject list = db.getCollection("userScore22").group(groupCommand);
        System.out.println(list);
    }


    public static void main(String[] args) {

        test3();
    }

}


















