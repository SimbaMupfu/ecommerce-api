package inc.sims.hustles.controller;

import inc.sims.hustles.model.Product;
import inc.sims.hustles.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("product/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") int productId){
        Product product = productService.getProductById(productId);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
