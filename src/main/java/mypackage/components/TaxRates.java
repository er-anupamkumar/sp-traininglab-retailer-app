package mypackage.components;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tax")
@Data
public class TaxRates {
    double salesTaxRate;
}
