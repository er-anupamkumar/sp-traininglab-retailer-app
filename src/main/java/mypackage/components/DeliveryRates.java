package mypackage.components;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "delivery")
@Data
public class DeliveryRates {
    double normal;
    double threshold;
}
