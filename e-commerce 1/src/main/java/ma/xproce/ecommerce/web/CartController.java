package ma.xproce.ecommerce.web;

import ma.xproce.ecommerce.service.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
    @Autowired
    private CartManager cartManager;

    @RequestMapping("/deleteCart/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        cartManager.deleteCart(id);
        return "redirect:/myCart";

    }
}