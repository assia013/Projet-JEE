package ma.xproce.ecommerce.web;

import ma.xproce.ecommerce.dao.entity.Category;
import ma.xproce.ecommerce.service.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryManager categoryManager;

    @PostMapping("/addCategory")
    public String addProductAction(Model model,
                                   @RequestParam(name = "name") String name,
                                   @RequestParam(name = "id", defaultValue = "") Integer id){
        Category category= new Category(id,name);
        categoryManager.addCategory(category);
        return "redirect:categoryList";
    }
    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }


    @GetMapping("/categoryList")
    public String listProducts(Model model) {
        List<Category> categories = categoryManager.getAllCategories();
        model.addAttribute("listCategories", categories);
        return "categoryList";
    }
    @GetMapping("/deleteCategory")
    public String deleteCategory(Model model, @RequestParam(name = "id") Integer id) {
        if(categoryManager.deleteCategory(id)){
            return "redirect:/categoryList";
        }
        return "redirect:/categoryList";
    }
}
