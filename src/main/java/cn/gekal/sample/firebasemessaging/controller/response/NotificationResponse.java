package cn.gekal.sample.firebasemessaging.controller.response;

/**
 * 通知詳細リクエスト
 */
public class NotificationResponse {

    /** 送信ID */
    private String id;

    /**
     * 送信IDを取得します。
     *
     * @return 送信ID
     */
    public String getId() {
        return id;
    }

    /**
     * 送信IDを設定します。
     *
     * @param id 送信ID
     */
    public void setId(String id) {
        this.id = id;
    }
}
