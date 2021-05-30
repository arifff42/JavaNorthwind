package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Product getByProductName(String productName); // select * from products where where product name=""

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); // select * from products and
																						// select *
	// from category_id

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); // select * from products
																								// or select
	// * from category_id

	List<Product> getByCategory_CategoryIdIn(List<Integer> categories); // select * from products where category_id
																		// in(1,2,3,4)

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	
	// select * from products where where product name="BİŞEY" and categoryId=İNTEGER
	@Query("from Product where productName=:productNameee and category.categoryId=:categoryIddd ")
	List<Product> getByNameAndCategory(String productNameee, int categoryIddd); 
	
	
	//select p.product_id, p.product_name, c.category_name, p.unit_price from categories c inner join products p on c.category_id = p.category_id
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p") 
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
