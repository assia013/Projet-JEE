package ma.xproce.ecommerce.service;

import ma.xproce.ecommerce.dao.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryManager {
    public Category addCategory(Category category);
    public List<Category> getAllCategories();
    public boolean deleteCategory(Integer id);
}
