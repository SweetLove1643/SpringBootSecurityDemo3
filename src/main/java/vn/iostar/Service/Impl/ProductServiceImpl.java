package vn.iostar.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostar.Entity.Product;
import vn.iostar.Repository.ProductRepository;
import vn.iostar.Service.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices{

	@Autowired
	private ProductRepository repo;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repo = repository;
	}

	@Override
	public <S extends Product> S save(S entity) {
		return repo.save(entity);
	}

	@Override
	public List<Product> findAll() {
		return repo.findAll();
	}

	@Override
	public Product findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	
}
