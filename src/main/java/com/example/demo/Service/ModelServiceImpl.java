package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Model;
import com.example.demo.Repository.ModelRepo;

@Service
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelRepo repo;

	@Override
	public Model saveproduct(Model model) {
		return repo.save(model);
	}

	@Override
	public List<Model> getallproducts() {
		return repo.findAll();
	}

	@Override
	public Model getproductbyId(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public String deleteproduct(Integer id) {
		Model model= repo.findById(id).get();
		if(model!= null)
		{
			repo.delete(model);
			return "product deleted successfully";
		}
		return "Some Error Occured";
	}

	@Override
	public List<Model> findByProductName(String productName) {
		return repo.findByProductName(productName);
	}

	
	
}
