package cn.hzq.chatgml.model;

import lombok.Data;

import java.util.List;

/**
 * @author 黄照权
 * @Date 2024/3/31
 * @Description 根据用户的文字描述生成图像,使用同步调用方式请求返回结果  <a href="https://open.bigmodel.cn/dev/api#cogview">CogView</a>
 **/
public class ImageCompletionResponse {
    /**
     * 请求创建时间，是以秒为单位的Unix时间戳。
     */
    private Long created;

    private List<Image> data;

    @Data
    public static class Image{
        private String url;
    }
}
