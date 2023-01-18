package com.giveandtake.userService.proxies;


import com.giveandtake.userService.proxies.beans.ProductBean;
import com.giveandtake.userService.proxies.commandBeans.ProductCommandBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.giveandtake.userService.constants.PathConstant.PRODUCT;
import static com.giveandtake.userService.constants.PathConstant.V1;

@FeignClient(name = "ProductService", url = "localhost:8081" + V1+PRODUCT)
public interface ProductProxy {


    @GetMapping
    List<ProductBean> getProducts();

    @GetMapping("/{id}")
    ProductBean getProduct(@PathVariable("id") String id);

    @PostMapping
    public ProductBean addProduct(@RequestBody ProductCommandBean product);
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable String id);


    @PutMapping("/{id}")
    public  ProductBean updateProduct(@PathVariable String id, @RequestBody ProductCommandBean product);

//    @GetMapping("/type")
//    public List<ProductResponseDTO> getProductsByType(@RequestParam ProductType type);
//
//    @GetMapping("/price")
//    public List<ProductResponseDTO> getProductsByPrice(@RequestParam long price);
//
//    @GetMapping("/price/greater")
//    public List<ProductResponseDTO> getProductsByPriceGreaterThan(@RequestParam long price);
//
//    @GetMapping("/price/less")
//    public List<ProductResponseDTO> getProductsByPriceLessThan(@RequestParam long price);
//
//    @GetMapping("/price/between")
//    public List<ProductResponseDTO> getProductsByPriceBetween(@RequestParam long priceMin, @RequestParam long priceMax);
//
//    @GetMapping("/name")
//    public List<ProductResponseDTO> getProductsByName(@RequestParam String name);
//
//    @GetMapping("/price/asc")
//    public List<ProductResponseDTO> getProductsByOrderByPriceAsc();
//    @GetMapping("/price/desc")
//    public List<ProductResponseDTO> getProductsByOrderByPriceDesc();
//    @GetMapping("/name/asc")
//    public List<ProductResponseDTO> getProductsByOrderByNameAsc();
//    @GetMapping("/name/desc")
//    public List<ProductResponseDTO> getProductsByOrderByNameDesc();
//


    }