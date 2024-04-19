package cn.hzq.chatgml.executor;

import cn.hzq.chatgml.model.ChatCompletionRequest;
import cn.hzq.chatgml.model.ChatCompletionSyncResponse;
import cn.hzq.chatgml.model.ImageCompletionRequest;
import cn.hzq.chatgml.model.ImageCompletionResponse;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author 黄照权
 * @Date 2024/4/9
 * @Description openAi执行器
 **/
public interface Executor {

    /**
     * 问答模式，流式反馈
     *
     * @param chatCompletionRequest 请求信息
     * @param eventSourceListener   实现监听；通过监听的 onEvent 方法接收数据
     * @return 应答结果
     * @throws Exception 异常
     */
    EventSource completions(ChatCompletionRequest chatCompletionRequest, EventSourceListener eventSourceListener) throws Exception;

    /**
     * 问答模式，同步反馈 —— 用流式转化 Future
     *
     * @param chatCompletionRequest 请求信息
     * @return 应答结果
     */
    CompletableFuture<String> completions(ChatCompletionRequest chatCompletionRequest) throws InterruptedException;

    /**
     * 同步应答接口
     *
     * @param chatCompletionRequest 请求信息
     * @return ChatCompletionSyncResponse
     * @throws IOException 异常
     */
    ChatCompletionSyncResponse completionsSync(ChatCompletionRequest chatCompletionRequest) throws Exception;

    /**
     * 图片生成接口
     *
     * @param request 请求信息
     * @return 应答结果
     */
    ImageCompletionResponse genImages(ImageCompletionRequest request) throws Exception;
}
