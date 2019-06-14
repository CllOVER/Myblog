package cn.cllover.myblog.common.util;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

/*
* 运行状态码
* */
public class Status {

    @Getter
    @Setter
    private Map<String,Object> userMsg = new HashMap();

    //状态码200：成功
    private static final Integer SUCCESS = 200;
    //状态码500：失败
    private static final Integer FAIL = 500;
    //状态码300：警告
    private static final Integer WARNING = 300;


    //初始化
    public Status (){
        userMsg.put("code",SUCCESS);
        userMsg.put("message","操作成功");
    }

    //执行成功
    public static Status success(Object message){

        Status status = new Status();
        status.add("code",SUCCESS);
        status.add("message",message);
        return status;
    }

    //执行失败
    public static Status erroy(Object message){

        Status status = new Status();
        status.add("code",FAIL);
        status.add("message",message);
        return status;
    }

    //执行异常
    public static Status warning(Object message){

        Status status = new Status();
        status.add("code",WARNING);
        status.add("message",message);
        return status;
    }

    //存储
    public Status add(String key,Object value) {
        this.getUserMsg().put(key,value);
        return this;
    }

}
