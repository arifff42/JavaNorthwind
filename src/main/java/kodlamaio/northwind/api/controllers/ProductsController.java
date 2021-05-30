package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {

		this.productService = productService;
	}

	@GetMapping("getall")
	public DataResult<List<Product>> getAll() {

		return this.productService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody Product product) {

		return this.productService.add(product);
	}

	@GetMapping("getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {

		return this.productService.getByProductName(productName);
	}

	@GetMapping("getByProductNameAndCategory_CategoryId")
	public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,
			@RequestParam int categoryId) {

		return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}

	@GetMapping("getByProductNameOrCategory_CategoryId")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(
			@RequestParam("productName") String productName, @RequestParam int categoryId) {

		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}

	@GetMapping("getByCategory_CategoryIdIn")
	public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam List<Integer> categories) {

		return this.productService.getByCategory_CategoryIdIn(categories);
	}

	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {

		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {

		return this.productService.getByProductNameStartsWith(productName);
	}

	@GetMapping("getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productNameee,
			@RequestParam int categoryIddd) {

		return this.productService.getByNameAndCategory(productNameee, categoryIddd);
	}

	@GetMapping("getAllWithPage")
	public DataResult<List<Product>> getAllWithPage(@RequestParam("pageNo") int pageNo, @RequestParam int pageSize) {

		return this.productService.getAllWithPage(pageNo, pageSize);
	}

	@GetMapping("getAllSorted")
	public DataResult<List<Product>> getAllSorted() {

		return this.productService.getAllSorted();
	}
	
	@GetMapping("getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return this.productService.getProductWithCategoryDetails();
	}
}
