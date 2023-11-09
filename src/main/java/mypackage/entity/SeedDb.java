package mypackage.entity;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SeedDb {

    JdbcTemplate jdbcTemplate;

    public SeedDb(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initialize (){
        jdbcTemplate.update("INSERT into PRODUCT_SUGGESTION (PRODUCT_DESCRIPTION, RECOMMENDED_PRICE, ESTIMATED_ANNUAL_SALES) VALUES (?,?,?)","Macbook Air",10000.0,12000000.0);
        jdbcTemplate.update("INSERT into PRODUCT_SUGGESTION (PRODUCT_DESCRIPTION, RECOMMENDED_PRICE, ESTIMATED_ANNUAL_SALES) VALUES (?,?,?)","Macbook Air2",30000.0,14000000.0);
        jdbcTemplate.update("INSERT into PRODUCT_SUGGESTION (PRODUCT_DESCRIPTION, RECOMMENDED_PRICE, ESTIMATED_ANNUAL_SALES) VALUES (?,?,?)","Macbook Air3",40000.0,15000000.0);
        jdbcTemplate.update("INSERT into PRODUCT_SUGGESTION (PRODUCT_DESCRIPTION, RECOMMENDED_PRICE, ESTIMATED_ANNUAL_SALES) VALUES (?,?,?)","Macbook Air4",150000.0,120012300.0);
    }

}
