package mypackage.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import mypackage.entity.ProductSuggestion;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class ProductSuggestionRepositoryImpl implements ProductSuggestionRepository{

    @PersistenceContext
    EntityManager entityManager;


    /**
     * @return the List of ProductSuggestion from back end
     */
    @Override
    public List<ProductSuggestion> getProductSuggestions() {
        String jpql = "select ps from ProductSuggestion ps";
        TypedQuery<ProductSuggestion> query = entityManager.createQuery(jpql, ProductSuggestion.class);
        return query.getResultList();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProductSuggestion getProductSuggestion(long id) {
        return entityManager.find(ProductSuggestion.class,id);
    }

    /**
     * @param ps
     * @return
     */
    @Override
    public long insertProductSuggestion(ProductSuggestion ps) {
        entityManager.persist(ps);
        entityManager.flush();
        return ps.getId();
    }

    /**
     * @param id
     * @param newPrice
     * @return
     */
    @Override
    public boolean modifyPrice(long id, double newPrice) {
        var ps = entityManager.find(ProductSuggestion.class,id);
        if (isNull(ps)){
            return false;
        }
        ps.setRecommendedPrice(newPrice);
        return true;
    }

    /**
     * @param id
     * @param newSales
     * @return
     */
    @Override
    public boolean modifySales(long id, long newSales) {
        var ps = entityManager.find(ProductSuggestion.class,id);
        if (isNull(ps)){
            return false;
        }
        ps.setEstimatedAnnualSales(newSales);
        return true;
    }

    /**
     *
     */
    @Override
    public void deleteProductSuggestions() {
        var query = entityManager.createQuery("delete from ProductSuggestion");
        query.executeUpdate();
    }

    @Override
    @Transactional
    public int increasePriceForPopularProducts(long sales) {
        String jpql = "update ProductSuggestion set recommendedPrice=recommendedPrice*1.1 where estimatedAnnualSales >= :s";
        var query = entityManager.createQuery(jpql);
        query.setParameter("s", sales);
        return query.executeUpdate();
    }
}

