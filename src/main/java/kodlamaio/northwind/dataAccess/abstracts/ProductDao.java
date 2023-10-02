package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategoryCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryCategoryId(String productName, int categoryId);

    List<Product> getByCategoryCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);
    @Query("From Product where  productName = :productName and category.categoryId = :categoryId")
    List<Product> GetByNameAndCategory(String productName, int categoryId);
}
