package personl_project.my_project;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InventoryFileHandling extends Inventory {
	final String inventoryFile = "inventoryFile.happi";
	

	public InventoryFileHandling(Scanner scanner) {
		super(scanner);
		readProductListFromFile();
		
	}
	
	//Override methods from inventory class and call the saveProductListToFile to save file after the method get call
	@Override
	public Product addProduct(String category,String productName,String productID,double price,int quantity){
		Product product = super.addProduct(category,productName, productID,price, quantity);
		saveProductListToFile();
		return product;
		
	}
		
	@Override
	public boolean removeProduct(String productIdOrName){
		boolean productRemoved = super.removeProduct(productIdOrName);
		saveProductListToFile();
		return productRemoved;
		
		
	}
	@Override
	public void removeCategory(){
		super.removeCategory();
		saveProductListToFile();
		
	}
	@Override
	public void updateProduct(){
		super.updateProduct();
		saveProductListToFile();
		
	}



	public void saveProductListToFile() {
	    try (FileOutputStream fileOut = new FileOutputStream(inventoryFile);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

	        // Write the productList to the file
	        out.writeObject(getAllProducts());
	        
	        System.out.println(YELLOW+"Product list has been saved to " + inventoryFile);

	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println(RED+"An error occurred while saving the Inventory.");
	    }
	}
	
	public void readProductListFromFile() {
		try(FileInputStream fileIn = new FileInputStream(inventoryFile);
			ObjectInputStream in = new ObjectInputStream(fileIn)){
		setAllProducts((Map<String, List<Product>>) in.readObject());
		
	}catch(Exception e) {
		//e.printStackTrace();
		System.out.println(YELLOW+"An error occured while reading the Inventory");
	}
		
	}
	

}
