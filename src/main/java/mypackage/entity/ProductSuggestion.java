package mypackage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProductSuggestion {

    @Id
    @GeneratedValue
    private Long id;

    private String productDescription;

    private Double recommendedPrice;

    private Double estimatedAnnualSales;
}
