package cn.hzq.chatgml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 黄照权
 * @Date 2024/3/31
 * @Description 消息类型 <a href="https://open.bigmodel.cn/dev/api#chatglm_lite">chatglm_lite</a>
 **/
@Getter
@AllArgsConstructor
public enum EventType {

    add("add", "增量"),
    finish("finish", "结束"),
    error("error", "错误"),
    interrupted("interrupted", "中断"),

    ;
    private final String code;
    private final String info;

}