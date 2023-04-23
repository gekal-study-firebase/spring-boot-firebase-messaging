package cn.gekal.sample.firebasemessaging.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Firebaseプロパティー
 */
@Component
@ConfigurationProperties(prefix = "firebase")
public class FirebaseProperties {

    /** サービスアカウントリソース */
    private Resource serviceAccount;

    /**
     * サービスアカウントリソースを取得する。
     *
     * @return サービスアカウントリソース
     */
    public Resource getServiceAccount() {
        return serviceAccount;
    }

    /**
     * サービスアカウントリソースを設定する。
     *
     * @param serviceAccount サービスアカウントリソース
     */
    public void setServiceAccount(Resource serviceAccount) {
        this.serviceAccount = serviceAccount;
    }
}
