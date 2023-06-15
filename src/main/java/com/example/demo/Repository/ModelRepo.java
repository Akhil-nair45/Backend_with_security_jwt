package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Model;

public interface ModelRepo extends JpaRepository<Model, Integer> {

	List<Model> findByProductName(String productName);

}
