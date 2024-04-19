package cn.hzq.chatgml.executor.result;

import okhttp3.sse.EventSourceListener;

/**
 * @author 黄照权
 * @Date 2024/4/12
 * @Description 结果封装器
 **/
public interface ResultHandler {
    EventSourceListener eventSourceListener(EventSourceListener eventSourceListener);
}
