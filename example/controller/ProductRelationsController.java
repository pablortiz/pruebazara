package com.example.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Product;
import com.example.service.imp.ProductRelationsService;
import com.google.gson.Gson;


@RestController
@RequestMapping(path = "/", 
        //consumes = MediaType.APPLICATION_JSON_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE, 
        method = {RequestMethod.GET, RequestMethod.POST})
public class ProductRelationsController {

	@Autowired
	private ProductRelationsService productrelations;
   
    public ProductRelationsController(ProductRelationsService productrelations) {
		this.productrelations = productrelations;
	}

    public ProductRelationsController() {
    	
    }

	@RequestMapping(path = "/relations/{id}", method = RequestMethod.GET)
    public String getProductRelations(@PathVariable Integer id) {

    	List<Product> arraylist = productrelations.getRelationProduct(id);
    	Gson gson = new Gson();
    	String json = gson.toJson(arraylist);  
    	return json;
    }

}