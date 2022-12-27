package com.example.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.entity.Product;
import com.example.service.IRelationsProduct;

@Service
public class ProductRelationsService implements IRelationsProduct{
	

	public ProductRelationsService() {		
	}


	@Override
	public List<Product> getRelationProduct(Integer cprod) {

		RestTemplate restTemplate = new RestTemplate();
		List<Product> arraylist = new ArrayList<>();
		
		String uri = "http://localhost:3001/product/"+cprod+"/similarids";
		String[] products = restTemplate.getForObject(uri, String[].class);
		
		for (int i = 0; i < products.length; i++) {
			
			uri = "http://localhost:3001/product/"+products[i];
			Product product = restTemplate.getForObject(uri, Product.class);
			arraylist.add(product);
			
		}
		
		return arraylist;
	}
}
