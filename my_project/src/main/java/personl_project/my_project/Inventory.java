package personl_project.my_project;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Inventory extends Color {
	Scanner scanner;

	private Map<String, List<Product>> productList;

	public Inventory(Scanner scanner) {
		this.scanner = scanner;
		//map to store product category and the list of product information

		productList = new HashMap<>();
		productList.put("Electronis", new ArrayList<>());
		productList.put("Food", new ArrayList<>());
		productList.put("Furnitures", new ArrayList<>());
		productList.put("Fashion", new ArrayList<>());
		productList.put("Stationary", new ArrayList<>());
		productList.put("Cosmetics",  new ArrayList<>());
		productList.put("Stationary", new ArrayList<>());



	}
	// method to add new category and product
	public void handleAddProduct() {
		System.out.println(CYAN +"What Category is the Product?");
		displayAllCategory(); // to display all existing category
		System.out.println(CYAN +"****************************"+RESET);
		String productCategoryEntry = scanner.nextLine(); // stores the user input for the product category
		System.out.println(CYAN + "****************************\n"+RESET);

		boolean categoryFound = false; // to track if the product get added
		for (String item : productList.keySet()) {
			if (item.equalsIgnoreCase(productCategoryEntry)) {
				categoryFound = true; 
				productCategoryEntry = item;
				break;  // Stop checking further categories once found
			}
		}
		if (!categoryFound) {// if the product category entered is not found
			System.out.println(RED+ "Category entered does not exist"+RESET);// notify the user
			System.out.println(CYAN+"Do you want to create a new category?");// ask if they want to create a new category
			System.out.println(GREEN+"1. Yes");
			System.out.println("2. No"+RESET);
			int yesToNewCategory = scanner.nextInt();
			scanner.nextLine(); // consume leftover newline

			if (yesToNewCategory != 1) { 
				return;  // Exit if the user doesn't want to create a new category
			} else {
				System.out.println(GREEN+"Enter the new Category:"+RESET);
				productCategoryEntry = scanner.nextLine();

				// Save the list to a file named productlist.dat

			}
		}

		System.out.print(GREEN+"Enter Product Name: "+RESET);
		String productNameEntry = scanner.nextLine();

		System.out.print(GREEN+"Enter Product ID: "+RESET);
		String productIdEntry = scanner.nextLine();

		System.out.print(GREEN+"Enter Product Price: "+RESET);
		double productPriceEntry = scanner.nextDouble();
		scanner.nextLine();
		System.out.print(GREEN+"Enter Product Quantity: "+RESET);
		int  productQuantityEntry = scanner.nextInt();
		scanner.nextLine();

		addProduct(productCategoryEntry,productNameEntry, productIdEntry,productPriceEntry,productQuantityEntry);

		System.out.println(YELLOW+ "Product added successfully.");


	}

	public Product addProduct(String category,String productName,String productID,double price,int quantity) {
		Product product = new Product(category,productName, productID,price, quantity);



		// if category does not exist create new category and empty arraylist to add products
		productList.putIfAbsent(category, new ArrayList<>());
		// if category exist just add product as values to it
		productList.get(category).add(product);
		return product;

	}

	//method to remove product
	public void handleRemoveProduct() {
		System.out.print(GREEN+"Enter product ID or product name to be removed: "+RESET);
		String productToRemove = scanner.nextLine();
		boolean productRemoved = removeProduct(productToRemove);
		if(!productRemoved) {
			System.out.print(RED+"Product not Found!");
		}
	}




	public boolean removeProduct(String productIdOrName ) {
		boolean productRemoved = false;
		for(Map.Entry<String, List<Product>>entry:productList.entrySet()) {
			List<Product>products=entry.getValue();
			Iterator<Product> iterator = products.iterator();
			while(iterator.hasNext()) {
				Product product = iterator.next();

				if (product.getProductID().equalsIgnoreCase(productIdOrName) || product.getProductName().equalsIgnoreCase(productIdOrName) ) {
					iterator.remove();
					productRemoved = true;
					System.out.println(YELLOW +"Product removed!");
					break;// exiting the loop


				}
			}

		}return productRemoved;


	}
	//method to Search for a product"
	public Product viewProduct() {
		System.out.println(GREEN+"Enter the product name or productID to view"+RESET);
		String viewProductEntry = scanner.nextLine();
		boolean productFound = false;
		for(Map.Entry<String, List<Product>> entry: productList.entrySet()) {
			List<Product> products= entry.getValue();
			for(Product product : products) {
				if(viewProductEntry.equalsIgnoreCase(product.getProductID())|| viewProductEntry.equalsIgnoreCase(product.getProductName())){ 
					System.out.println(YELLOW+"Found product!!"+RESET);
					System.out.println("\n");
					System.out.println(GREEN+product);
					productFound= true;
					return product;
				}
			}
		}if(!productFound) {
			System.out.println(RED+"Found not product!!");
		}
		return null;
	}
	//method to view all product
	/*public void viewAllProduct() { 
		System.out.println(productList);
	}*/

	// Method to display all product in a specific format
	public void displayAllProduct() {
		// Method to display the inventory in the desired format with headings

		for (Map.Entry<String, List<Product>> entry : productList.entrySet()) {
			String category = entry.getKey();
			List<Product> products = entry.getValue();

			// Print the category on a new line
			System.out.println(RESET+"    \"" + YELLOW+ category +  "\" "+RESET);

			// Print the headings for the product details
			System.out.println(GREEN+ "        Product Name "+CYAN+" | " +GREEN + " Product ID " + CYAN+" | " +GREEN+ " Price "+ CYAN+" | "+GREEN+" Quantity "+ CYAN+" | " +GREEN+" Category "+RESET);

			// Iterate through the products in the category
			for (int i = 0; i < products.size(); i++) {
				// Print each product on a new line, formatted
				Product product = products.get(i);
				System.out.printf("        %-12s | %-10s | $%-14.2f | %-8d | %-10s%n",
						product.getProductName(), 
						product.getProductID(),
						product.getPrice(),
						product.getQuantity(),
						product.getCategory()
						);

				if (i < products.size() - 1) {
					System.out.println(); // Adds a blank line between products for clarity
				}
			}

			System.out.println("\n"); // Close the product list for the category
		}
		System.out.println( );
	}

	public Map<String, List<Product>> getAllProducts(){
		return productList;
	}
	public void setAllProducts(Map<String, List<Product>> products){
		productList = products;
	}

	// method to update product
	public void updateProduct() {
		Product productToUpdate = viewProduct();
		if(productToUpdate==null) {
			return;
		}

		boolean shouldContinue =true; 
		do {

			System.out.println(CYAN+"******************************");

			System.out.println("What will you like to update");
			System.out.println(CYAN+"******************************");
			System.out.println(GREEN+"1. Product Name");
			System.out.println("2. Product ID");
			System.out.println("3. Price");
			System.out.println("4. Quantity");
			System.out.println("5. Category");
			System.out.println(CYAN+"**************************"+RESET);
			try {
				int updateInput = Integer.parseInt(scanner.nextLine());

				if(updateInput >5 || updateInput<1)throw new InputMismatchException();

				switch(updateInput) { 


				case 1->{ 
					System.out.print(GREEN+"Enter the new product name: "+RESET);
					System.out.println("\n");
					String newProductName = scanner.nextLine();

					productToUpdate.setProductName(newProductName);
					System.out.println(YELLOW+"Product name updated!"+RESET);
				}


				case 2->{
					System.out.print(GREEN+"Enter the new product ID: "+RESET);
					System.out.println("\n");
					String newProductID = scanner.nextLine();

					productToUpdate.setProductID(newProductID);
					System.out.println(YELLOW+"Product ID updated!");
				}
				case 3->{
					System.out.print(GREEN+ "Enter the new price: "+RESET);
					System.out.println("\n");
					String newPrice = scanner.nextLine();

					productToUpdate.setPrice(Double.parseDouble(newPrice));
					System.out.println(YELLOW+"Product price updated!");
				}
				case 4->{
					System.out.print(GREEN+"Enter the new Quantity: "+RESET);
					System.out.println("\n");
					String newQuantity = scanner.nextLine();

					productToUpdate.setProductID(newQuantity);
					System.out.println(YELLOW+"Product Quantity updated!");
				}
				case 5->{
					System.out.println(GREEN+"Enter the new Category: \n"+RESET);
					String newCategory = scanner.nextLine();		
					productToUpdate.setCategory(newCategory);
					System.out.println(YELLOW+"Product ID updated!");
				}






				}
				System.out.println(CYAN+"*********************************");
				System.out.println("Would you like any other update?");
				System.out.println("*********************************"+RESET);
				System.out.println(GREEN+"1. Yes");
				System.out.println("2. No"+RESET);

				try {
					int option = Integer.parseInt(scanner.nextLine());

					if(option !=1) {
						shouldContinue = false;
					}

				}catch(NumberFormatException e) {
					shouldContinue=false;
					//e.printStackTrace();
				}

			}catch(InputMismatchException e) {//to catch errors when the user enter alphabet instead of numbers
				System.out.println("Please enter a number from 1 - 5");
				//e.printStackTrace();
			}catch(NumberFormatException e) { // to catch numbers related error user enter
				System.out.println("Please enter a number from 1 - 5");
				//e.printStackTrace();


			}catch(Exception e) { // to catch any other exception the above catch did not catch
				System.out.println("An error occured, please enter a number from 1-5");
			}


		}while(shouldContinue);


	}
	// method to display all category
	public void displayAllCategory() {
		Set<String>productCategories= getAllCategory();
		for(String category: productCategories) 
			System.out.println(GREEN + category+RESET);
	}
	public 	Set<String> getAllCategory(){
		return productList.keySet();
	}


	// method to remove a category
	public void removeCategory() {
		System.out.println(CYAN+"What Category will you like to remove?"+RESET);
		displayAllCategory();
		boolean categoryRemoved = false;
		System.out.println(CYAN+"*********************************"+RESET);
		String categoryToRemove = scanner.nextLine();
		System.out.println(CYAN+"*********************************"+RESET);

		for(String category : productList.keySet()) {
			if(category.equalsIgnoreCase(categoryToRemove)) {
				productList.remove(categoryToRemove);
				System.out.println(YELLOW+ "Category Removed!");
				categoryRemoved = true;
			}
		}
		if(!categoryRemoved) {
			System.out.println(RED +"Category not Found");
		}


	}



}