package cn.gekal.sample.firebasemessaging.controller;

import cn.gekal.sample.firebasemessaging.controller.request.NotificationRequest;
import cn.gekal.sample.firebasemessaging.controller.response.NotificationResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Firebaseパブリッシャーコントローラー
 */
@RestController
@RequestMapping("/")
public class FirebasePublisherController {

    /** FirebaseメッセージングBean */
    private final FirebaseMessaging firebaseMessaging;

    /**
     * コントローラー
     *
     * @param firebaseMessaging FirebaseメッセージングBean
     */
    public FirebasePublisherController(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    /**
     * クライアントへ送信する。
     *
     * @param registrationToken   トークン
     * @param notificationRequest 通知詳細リクエスト
     * @return 送信結果
     * @throws FirebaseMessagingException Firebaseメッセージングエクセプション
     */
    @PostMapping("/clients/{registrationToken}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public NotificationResponse postToClient(@PathVariable("registrationToken") String registrationToken, @RequestBody NotificationRequest notificationRequest) throws FirebaseMessagingException {

        Notification notification = Notification.builder()
                .setTitle(notificationRequest.getTitle())
                .setBody(notificationRequest.getBody())
                .setImage(notificationRequest.getImage())
                .build();

        Message message = Message.builder()
                .setToken(registrationToken)
                .setNotification(notification)
                .putAllData(notificationRequest.getData())
                .build();

        String id = this.firebaseMessaging.send(message);

        NotificationResponse response = new NotificationResponse();
        response.setId(id);

        return response;
    }
}
