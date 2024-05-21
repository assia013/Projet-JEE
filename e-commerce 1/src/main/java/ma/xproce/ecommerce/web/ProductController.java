package ma.xproce.ecommerce.web;

import ma.xproce.ecommerce.dao.entity.Cart;
import ma.xproce.ecommerce.dao.entity.Category;
import ma.xproce.ecommerce.dao.entity.Product;
import ma.xproce.ecommerce.service.CartManager;
import ma.xproce.ecommerce.service.CategoryManager;
import ma.xproce.ecommerce.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    ProductManager productManager;
    @Autowired
    CartManager cartManager;
    @Autowired
    CategoryManager categoryManager;

    @GetMapping("")
    public String start() {
        return "home";
    }
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

//    @PostMapping("/add")
//    public String addProductAction(Model model,
//                                       @RequestParam(name = "name") String name,
//                                       @RequestParam(name = "id", defaultValue = "") Integer id,
//                                       @RequestParam(name = "image") String image,
//                                       @RequestParam(name = "category") Category category,
//                                       @RequestParam(name = "quantity") int quantity,
//                                       @RequestParam(name = "price") int price,
//                                       @RequestParam(name = "description") String description) {
//        Product product = new Product(id,name,image,new Category(category.getId(),category.getName()),quantity,price,description);
//        productManager.addNewProduct(product);
//        return "redirect:productList";
//    }

    @PostMapping("/addOnce")
    public String addProduct(Model model,
                                 @Valid Product product,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addproduct";
        }
        productManager.addNewProduct(product);
        return "redirect:productList";
    }

    @GetMapping("/addProduct")
    public String addproduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryManager.getAllCategories() );
        return "addproduct";
    }


    @GetMapping("/productList")
    public String listProducts(Model model,
                               @RequestParam(name = "page", defaultValue = "1") int page,
                               @RequestParam(name = "taille", defaultValue = "3") int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword
    ) {
        Page<Product> products = productManager.searchProducts(keyword, page, taille);
        model.addAttribute("listProducts", products.getContent());
        int[] pages = new int[products.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "productList";
    }


    @GetMapping("/myCart")
    public String myCart(Model model,@RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "taille", defaultValue = "3") int taille,
                         @RequestParam(name = "search", defaultValue = "") String keyword){
        Page<Cart> carts=cartManager.searchCarts(keyword,page,taille);
        model.addAttribute("cart", carts.getContent());
        int[] pages = new int[carts.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "cartList";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Product product=productManager.getProductById(id);
        Cart cart= new Cart(product.getId(),product.getName(),product.getImage(),product.getCategory(),product.getQuantity(),product.getPrice(),product.getDescription());
        cartManager.addNewCart(cart);
        return "redirect:/myCart";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(Model model, @RequestParam(name = "id") Integer id) {
        if (productManager.deleteProduct(id)) {
            return "redirect:/productList";
        } else {
            return "error";
        }
    }

    @GetMapping("/editProduct")
    public String editProduct(Model model, @RequestParam(name = "id") Integer id) {
        Product product = productManager.getProductById(id);
        model.addAttribute("productToBeUpdated", product);
        model.addAttribute("category", categoryManager.getAllCategories() );
        return "updateProduct";

    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }


}
