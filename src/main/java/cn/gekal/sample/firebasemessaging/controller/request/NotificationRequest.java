package cn.gekal.sample.firebasemessaging.controller.request;

import java.util.Map;

/**
 * 通知詳細リクエスト
 */
public class NotificationRequest {

    /** タイトル */
    private String title;

    /** ボディ */
    private String body;

    /** イメージ */
    private String image;

    /** データマップ */
    private Map<String, String> data;

    /**
     * タイトルを取得します。
     *
     * @return タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトルを設定します。
     *
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ボディを取得します。
     *
     * @return ボディ
     */
    public String getBody() {
        return body;
    }

    /**
     * ボディを設定します。
     *
     * @param body ボディ
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * イメージを取得します。
     *
     * @return イメージ
     */
    public String getImage() {
        return image;
    }

    /**
     * イメージを設定します。
     *
     * @param image イメージ
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * データマップを取得します。
     *
     * @return data
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * データマップを設定します。
     *
     * @param data データマップ
     */
    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
