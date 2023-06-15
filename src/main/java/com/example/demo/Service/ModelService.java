package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Model;

public interface ModelService {
	
	public Model saveproduct(Model model);
	public List<Model> getallproducts();
	public Model getproductbyId(Integer id);
	public String deleteproduct(Integer id);
	public List<Model> findByProductName(String productName);
	
	
}
