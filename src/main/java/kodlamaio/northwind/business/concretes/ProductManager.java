package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {

		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listelendi.");

	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {

		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),
				"getByProductName Data Listelendi.");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
//business codes
		return new SuccessDataResult<Product>(
				this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),
				"getByProductNameAndCategory Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {

		return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),
				"getByProductNameOrCategory Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories),
				"getByCategoryIn Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),
				"getByProductNameContains Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),
				"productName Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productNameee, int categoryIddd) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productNameee, categoryIddd),
				"getByNameAndCategory Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAllWithPage(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(), // getContent page
																									// döndüren pageable
																									// ı listeye
																									// çeviriyor.
				"getAllPage Data Listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAllSorted() { // asc veya desc yi parametleri yapabilirsin. ARAŞTIR.

		Sort sort = Sort.by(Sort.Direction.DESC, "id"); // id ye göre sondan sırala

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "getAllSorted Data Listelendi.");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {

		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),
				"Ürünler kategori ile birlikte listelendi.");
	}

}
