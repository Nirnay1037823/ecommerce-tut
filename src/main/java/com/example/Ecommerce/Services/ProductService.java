package com.example.Ecommerce.Services;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository prodRepo;

    public Product saveUser(Product product){
        return prodRepo.save(product);
    }

    public List<Product> saveAllProducts(List<Product> allProducts){
        return prodRepo.saveAll(allProducts);
    }

    public Product findProdById(int id){
        Optional<Product> findProdObj = prodRepo.findById(id);
        return findProdObj.get();
    }

    public List<Product> findAllProducts(){
        return prodRepo.findAll();
    }

    public boolean existProdById(int id){
        System.out.println(prodRepo.existsById(id));
        return prodRepo.existsById(id);
    }

    public void deleteProdById(int id){
        prodRepo.deleteById(id);
    }

    public Product updateProduct(Product product){
        Product prodObj = prodRepo.saveAndFlush(product);
        return prodObj;
    }

}
