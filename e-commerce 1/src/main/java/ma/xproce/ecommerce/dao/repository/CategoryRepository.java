package ma.xproce.ecommerce.dao.repository;

import ma.xproce.ecommerce.dao.entity.Category;
import ma.xproce.ecommerce.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByName(String name);
}
