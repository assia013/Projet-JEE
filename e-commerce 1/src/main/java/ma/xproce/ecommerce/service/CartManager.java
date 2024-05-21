package ma.xproce.ecommerce.service;

import ma.xproce.ecommerce.dao.entity.Cart;
import ma.xproce.ecommerce.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartManager {
    public Cart addNewCart(Cart product);
    public Page<Cart> getAllCarts(int page, int taille);
    public Page<Cart> searchCarts(String keyword, int page, int taille);
    public List<Cart> getByKeyword(String keyword);
    public Cart updateCart(Cart cart);
    public boolean deleteCart(Integer id);
}
