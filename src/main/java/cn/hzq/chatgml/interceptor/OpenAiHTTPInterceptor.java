package cn.hzq.chatgml.interceptor;

import cn.hzq.chatgml.session.Configuration;
import cn.hzq.chatgml.utils.BearerTokenUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;


import java.io.IOException;

/**
 * @author 黄照权
 * @Date 2024/4/9
 * @Description 接口拦截器
 **/
public class OpenAiHTTPInterceptor implements Interceptor {

    /**
     * 智普Ai，Jwt加密Tokenz
     */
    private final Configuration configuration;
    public OpenAiHTTPInterceptor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public @NotNull Response intercept(Chain chain) throws IOException {
        // 1. 获取原始 Request
        Request original = chain.request();
        // 2. 构建请求
        Request request = original.newBuilder()
                .url(original.url())
                .header("Authorization", "Bearer " + BearerTokenUtils.getToken(configuration.getApiKey(), configuration.getApiSecret()))
                .header("Content-Type", Configuration.JSON_CONTENT_TYPE)
                .header("User-Agent", Configuration.DEFAULT_USER_AGENT)
//                .header("Accept", null != original.header("Accept") ? original.header("Accept") : Configuration.SSE_CONTENT_TYPE)
                .method(original.method(), original.body())
                .build();

        // 3. 返回执行结果
        return chain.proceed(request);
    }
}
