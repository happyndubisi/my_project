package personl_project.my_project;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
	private Inventory inventory;
	  

	@BeforeEach
	void setUp() {
		inventory = new Inventory(new Scanner(System.in));
	}
	    @Test
	    public void testAddProduct()
	    {
	      
	       String category = "newCategory";
	       int categoryPreviousSize = inventory.getAllCategory().size();
	       int categoryPreviousProductSize = inventory.getAllProducts().getOrDefault(category, new ArrayList<>()).size();
	    		  
	       Product product = inventory.addProduct( category, "newProductName", "newProductId", 123.00f, 10);
	       int categoryCurrentSize = inventory.getAllCategory().size();
	       assert(categoryPreviousSize != categoryCurrentSize);
	       assert(categoryPreviousSize < categoryCurrentSize);
	       assert(product.getProductName().equals("newProductName"));
	       int categoryNewProductSize = inventory.getAllProducts().getOrDefault(category, new ArrayList<>()).size();
	       assert(categoryNewProductSize > categoryPreviousProductSize);
	    }
	    
	    @Test
	    
	    public void testRemoveProduct()
	    {
	       
	    	String category = "newCategory";
		       int categoryPreviousSize = inventory.getAllCategory().size();
		       int categoryPreviousProductSize = inventory.getAllProducts().getOrDefault(category, new ArrayList<>()).size();
		    		  
		       Product product = inventory.addProduct( category, "newProductName", "newProductId", 123.00f, 10);
		       int categoryCurrentSize = inventory.getAllCategory().size();
		       assert(categoryPreviousSize != categoryCurrentSize);
		       assert(categoryPreviousSize < categoryCurrentSize);
		       assert(product.getProductName().equals("newProductName"));
		       int categoryNewProductSizeAfterAdd = inventory.getAllProducts().getOrDefault(category, new ArrayList<>()).size();
		       assert(categoryNewProductSizeAfterAdd > categoryPreviousProductSize);
	      inventory.removeProduct("newProductId");
	      int categoryNewProductSizeAfterRemove = inventory.getAllProducts().getOrDefault(category, new ArrayList<>()).size();
	       assert(categoryNewProductSizeAfterAdd > categoryNewProductSizeAfterRemove );
	      
	    }
	    
	    

}
