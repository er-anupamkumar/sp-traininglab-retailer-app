package mypackage.components;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("resources")
@Data
public class Resources {
    String db;
    String logs;
    Boolean secure;
}
