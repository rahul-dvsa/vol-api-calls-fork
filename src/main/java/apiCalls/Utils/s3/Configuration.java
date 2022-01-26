package apiCalls.Utils.s3;

import activesupport.aws.s3.S3;
import activesupport.system.Properties;
import com.typesafe.config.Config;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

public class Configuration {
    static EnvironmentType env = EnvironmentType.getEnum(Properties.get("env", true));
    static Config config = new activesupport.config.Configuration(env.toString()).getConfig();


    public static String getBucketName() {
        return config.getString("bucketName");
    }

    public static String getTempPassword(String emailAddress) {
        return S3.getTempPassword(emailAddress, getBucketName());
    }
}