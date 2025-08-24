package inc.sims.hustles.controller;

import inc.sims.hustles.model.Product;
import inc.sims.hustles.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
