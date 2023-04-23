package cn.gekal.sample.firebasemessaging.configuration;

import cn.gekal.sample.firebasemessaging.property.FirebaseProperties;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * Firebaseコンフィグレーション
 */
@Configuration
public class FirebaseConfiguration {

    /** Firebaseプロパティー */
    private final FirebaseProperties firebaseProperties;

    /**
     * コンストラクタ
     *
     * @param firebaseProperties Firebaseプロパティー
     */
    public FirebaseConfiguration(FirebaseProperties firebaseProperties) {
        this.firebaseProperties = firebaseProperties;
    }

    /**
     * GoogleクレデンシャルBeanを定義する。
     *
     * @return GoogleクレデンシャルBean
     */
    @Bean
    GoogleCredentials googleCredentials() {

        try {
            if (firebaseProperties.getServiceAccount() != null) {
                try (InputStream is = firebaseProperties.getServiceAccount().getInputStream()) {
                    return GoogleCredentials.fromStream(is);
                }
            } else {
                // Use standard credentials chain.
                return GoogleCredentials.getApplicationDefault();
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    /**
     * FirebaseアプリBeanを定義する。
     *
     * @param credentials GoogleクレデンシャルBean
     * @return Firebaseアプリ
     */
    @Bean
    FirebaseApp firebaseApp(GoogleCredentials credentials) {

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();

        return FirebaseApp.initializeApp(options);
    }

    /**
     * FirebaseメッセージングBeanを定義する。
     *
     * @param firebaseApp FirebaseアプリBean
     * @return FirebaseメッセージングBean
     */
    @Bean
    FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {

        return FirebaseMessaging.getInstance(firebaseApp);
    }
}
