package com.zzz.demo;

import com.zzz.demo.util.ClassPathFileUtil;
import com.zzz.demo.util.MongodbUtil;

import java.io.IOException;

/**
 * Created by zd on 2017/3/24.
 */
public class TestDemo2RunJsFile {

    public static void main(String[] args) throws IOException {
        Object obj = MongodbUtil.runJs(ClassPathFileUtil.getFileContent("js/sys/userFindAll.js"),"test");
        System.out.println(obj);
    }
}
