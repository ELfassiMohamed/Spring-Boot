package com.spring.authproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.authproject.dto.ReqRes;
import com.spring.authproject.entity.Product;
import com.spring.authproject.repository.ProductRepo;

@RestController
public class AdminUsers {
	@Autowired
	private ProductRepo productRepo;
	
	  @GetMapping("/public/product")
	    public ResponseEntity<Object> getAllProducts(){
	        return ResponseEntity.ok(productRepo.findAll());
	    }

	    @PostMapping("/admin/saveproduct")
	    public ResponseEntity<Object> signUp(@RequestBody ReqRes productRequest){
	        Product productToSave = new Product();
	        productToSave.setName(productRequest.getName());
	        return ResponseEntity.ok(productRepo.save(productToSave));
	    }


	    @GetMapping("/user/alone")
	    public ResponseEntity<Object> userAlone(){
	        return ResponseEntity.ok("USers alone can access this ApI only");
	    }

	    @GetMapping("/adminuser/both")
	    public ResponseEntity<Object> bothAdminaAndUsersApi(){
	        return ResponseEntity.ok("Both Admin and Users Can  access the api");
	    }
}
