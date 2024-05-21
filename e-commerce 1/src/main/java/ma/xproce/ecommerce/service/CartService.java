package ma.xproce.ecommerce.service;

import ma.xproce.ecommerce.dao.entity.Cart;
import ma.xproce.ecommerce.dao.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements CartManager{
    @Autowired
    private CartRepository cartRepository;


        @Override
        public Cart addNewCart(Cart cart){
            return cartRepository.save(cart);
        }

        @Override
        public Page<Cart> getAllCarts(int page, int taille) {
            return cartRepository.findAll(PageRequest.of(page, taille));
        }

        @Override
        public Page<Cart> searchCarts(String keyword, int page, int taille) {
            return cartRepository.findByNameContains(keyword,PageRequest.of(page,taille));
        }

        @Override
        public List<Cart> getByKeyword(String keyword) {
            return null;
        }


        @Override
        public Cart updateCart(Cart cart) {
            return cartRepository.save(cart);
        }

        @Override
        public boolean deleteCart(Integer id) {
            try {
                cartRepository.deleteById(id);
                return true;
            } catch (Exception exception) {
                return false;
            }
        }


}
