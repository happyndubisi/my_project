package personl_project.my_project;

import java.io.Serializable;

public class Product implements Serializable{
	// Declaring the instant variable
	private String productName;
	private String productID;
	private double price;
	private int quantity;
	private String category;
	
	public Product(String category,String productName,String productID,double price,int quantity) {
		this.category = category;
		this.productName = productName;
		this.productID = productID;
		this.price = price;	
		this.quantity =quantity;
			
	}
	@Override
	public String toString() {
	    return "{" +
	           "productName=\"" + productName + "\"" +
	           ", productID=\"" + productID + "\"" +
	           ", price=\"$" + String.format("%.2f", price) + "\"" + 
	           ", quantity=" + quantity +
	           ", category=\"" + category + "\"" +
	           "}";
	}

	
	// getter for the instant variables
	public String getProductName(){
		return productName;
	}
	public String getProductID() {
		return productID;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getCategory() {
		return category;
	}
	
	// Setters
	 
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}
