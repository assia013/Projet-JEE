package ma.xproce.ecommerce.service;

import ma.xproce.ecommerce.dao.entity.Category;
import ma.xproce.ecommerce.dao.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryManager{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
