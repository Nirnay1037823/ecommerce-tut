package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    ProductService prodServ;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Product save(@RequestBody Product product){
        return prodServ.saveUser(product);
    }

    @PostMapping("/addall")
    public List<Product> saveAll(@RequestBody List<Product> allProducts){
        return prodServ.saveAllProducts(allProducts);
    }

    @GetMapping("/findbyid")
    public void findById(@RequestParam(name = "id") int id){
        if(prodServ.existProdById(id)){
            System.out.println(prodServ.findProdById(id));
        }else{
            System.out.println("User is not present");
        }
    }
    @GetMapping("/getall")
    public List<Product> findall(){
        return prodServ.findAllProducts();
    }

    @PostMapping("/deletebyid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") int id){
        try {
            boolean userExists = prodServ.existProdById(id);
            if (userExists){
                prodServ.deleteProdById(id);
                System.out.println("Product id "+id+" successfully deleted");
            }else{
                System.out.println("Product does not exist");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @PostMapping("/updateproduct")
    public Product update(@RequestBody Product product){
        Product newProd = product;
        System.out.println("Id of new user is" + newProd.getId());
        if(prodServ.existProdById(newProd.getId())){
            Product updatedProd = prodServ.updateProduct(product);
            return updatedProd;
        }
        System.out.println("User does not exists");
        return null;
    }
}
