package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "products")
//@Table(name="Products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// @Column(name="ProductID")
	@Column(name = "product_id")
	private int id;

	// @Column(name="CategoryID")
	// @Column(name = "category_id") //AŞAĞIDA CATEGORY BAĞLANTISI YAPILDI.
	// private int categoryId;

	// @Column(name="ProductName")
	@Column(name = "product_name")
	private String productName;

	// @Column(name="UnitPrice")
	@Column(name = "unit_price")
	private double unitPrice;

	// @Column(name="UnitsInStock")
	@Column(name = "units_in_stock")
	private short unitsInStock;

	// @Column(name="QuantityPerUnit")
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	// --------------------AŞAĞIDAKİ İŞLEMİ LOMBOK OTOMATİK
	// YAPIYOR--------------------------

	/*
	 * public Product() {
	 * 
	 * }
	 * 
	 * public Product(int id, int categoryId, String productName, double unitPrice,
	 * short unitsInStock, String quantityPerUnit) {
	 * 
	 * this.id = id; this.categoryId = categoryId; this.productName = productName;
	 * this.unitPrice = unitPrice; this.unitsInStock = unitsInStock;
	 * this.quantityPerUnit = quantityPerUnit; }
	 * 
	 * /*public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public int getCategoryId() { return categoryId; }
	 * 
	 * public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
	 * 
	 * public String getProductName() { return productName; }
	 * 
	 * public void setProductName(String productName) { this.productName =
	 * productName; }
	 * 
	 * public double getUnitPrice() { return unitPrice; }
	 * 
	 * public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
	 * 
	 * public short getUnitsInStock() { return unitsInStock; }
	 * 
	 * public void setUnitsInStock(short unitsInStock) { this.unitsInStock =
	 * unitsInStock; }
	 * 
	 * public String getQuantityPerUnit() { return quantityPerUnit; }
	 * 
	 * public void setQuantityPerUnit(String quantityPerUnit) { this.quantityPerUnit
	 * = quantityPerUnit; }
	 */
}
