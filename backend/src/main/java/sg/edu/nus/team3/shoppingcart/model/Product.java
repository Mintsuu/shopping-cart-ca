package sg.edu.nus.team3.shoppingcart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// @author: Jared Chua
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private double unitPrice;

  private int stock;

  private String category;

  public Product() {
  }

  public Product(int id, String name, double unitPrice, int stock, String category) {
    this.name = name;
    this.unitPrice = unitPrice;
    this.stock = stock;
    this.category = category;
  }

  public Product(String name, double unitPrice, int stock, String category) {
    this.name = name;
    this.unitPrice = unitPrice;
    this.stock = stock;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object comparator) {
    if (!(comparator instanceof Product))
      return false;
    Product that = (Product) comparator;

    return this.id == that.id && this.name == that.name && this.unitPrice == that.unitPrice && this.stock == that.stock
        && this.category == that.category;

  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", stock=" + stock + ", category="
        + category + "]";
  }
}
