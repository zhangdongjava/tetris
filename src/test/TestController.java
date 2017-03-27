package test;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by zd on 2017/3/13.
 */
public class TestController {

    public static void main(String[] args) throws Exception {
        test();
    }
    //脚本内部访问java资源
    public static void test06() throws ScriptException{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        engine.eval("importPackage(java.util)");//importPackage()函数允许在脚本内部导入java包，即可在脚本中实例化java对象
        engine.eval("today = new Date();println(today);");
        engine.put("name", "ZhangSan");
        engine.eval("name2 = name.toUpperCase();println(name2);");
    }




    public static String readInfoStream(InputStream input) throws Exception {
        if (input == null) {
            throw new Exception("输入流为null");
        }
        //字节数组
        byte[] bcache = new byte[2048];
        int readSize = 0;//每次读取的字节长度
        int totalSize = 0;//总字节长度
        ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
        try {
            //一次性读取2048字节
            while ((readSize = input.read(bcache)) > 0) {
                totalSize += readSize;
                //将bcache中读取的input数据写入infoStream
                infoStream.write(bcache, 0, readSize);
            }
        } catch (IOException e1) {
            throw new Exception("输入流读取异常");
        } finally {
            try {
                //输入流关闭
                input.close();
            } catch (IOException e) {
                throw new Exception("输入流关闭异常");
            }
        }


        return infoStream.toString("utf-8");

    }

    public static void test() throws Exception {

        String js = readInfoStream(TestController.class.getResourceAsStream("/test/test.js"));
        ScriptEngineManager manager = new ScriptEngineManager();
//      ScriptEngine engine = manager.getEngineByExtension("js");
//      ScriptEngine engine = manager.getEngineByMimeType("text/javascript");
        ScriptEngine engine = manager.getEngineByName("nashorn");

        if (engine == null) {
            throw new RuntimeException("not found JavaScript engine!");
        }
        // 直接执行脚本
        engine.eval(js);
        Invocable inv = (Invocable) engine;
        Object aa = inv.invokeFunction("sort",1,100,3,6,5,6,7,8);
        System.out.println(aa);
    }

    public  void testAA(){
        System.out.println("static java test");
    }


}
