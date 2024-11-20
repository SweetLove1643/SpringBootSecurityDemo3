package vn.iostar.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.iostar.Entity.Product;

@Service
public interface ProductServices {

	void deleteById(Long id);

	Product findById(Long id);

	List<Product> findAll();

	<S extends Product> S save(S entity);

}
