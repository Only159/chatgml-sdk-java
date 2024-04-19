package cn.hzq.chatgml.session;

import cn.hzq.chatgml.model.ChatCompletionRequest;
import cn.hzq.chatgml.model.ChatCompletionSyncResponse;
import cn.hzq.chatgml.model.ImageCompletionRequest;
import cn.hzq.chatgml.model.ImageCompletionResponse;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.util.concurrent.CompletableFuture;

/**
 * @author 黄照权
 * @Date 2024/4/12
 * @Description 会话服务接口
 **/
public interface OpenAiSession {
    EventSource completions(ChatCompletionRequest chatCompletionRequest, EventSourceListener eventSourceListener) throws Exception;

    CompletableFuture<String> completions(ChatCompletionRequest chatCompletionRequest) throws Exception;

    ChatCompletionSyncResponse completionsSync(ChatCompletionRequest chatCompletionRequest) throws Exception;

    ImageCompletionResponse genImages(ImageCompletionRequest imageCompletionRequest) throws Exception;

    Configuration configuration();
}
