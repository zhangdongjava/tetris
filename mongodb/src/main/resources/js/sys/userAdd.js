/**
 * Created by zd on 2017/3/24.
 */
var user = {
    "userName": "zhangsan", 
    "nickName": "张三",
    "password": "123456",
};
db.getCollection("user").insert(user);
