package ma.xproce.ecommerce.dao.repository;

import ma.xproce.ecommerce.dao.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CartRepository extends JpaRepository<Cart,Integer> {
    public Page<Cart> findAll(Pageable pageable);
    public Page<Cart> findByNameContains(String keyword, Pageable pageable);
}
