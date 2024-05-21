package ma.xproce.ecommerce.service;

import ma.xproce.ecommerce.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductManager {
    public Product addNewProduct(Product product);

    public Page<Product> getAllProducts(int page, int taille);
    public Page<Product> searchProducts(String keyword, int page, int taille);
    public List<Product> getByKeyword(String keyword);
    public Product getProductById(Integer id);
    public Product updateProduit(Product product);
    public boolean deleteProduct(Integer id);

}
