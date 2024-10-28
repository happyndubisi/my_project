package personl_project.my_project;

import java.util.Scanner;

public class Main extends Color{
	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
		InventoryFileHandling inventory =new InventoryFileHandling(scanner);
		
		
		do {
			try {
		System.out.println(CYAN +"**************************");
		System.out.println("****Store Management******");
		System.out.println("**************************");
		System.out.println(GREEN +"1. Add a product");
		System.out.println("2. Remove a product");
		System.out.println("3. Update a product");
		System.out.println("4. Search for a product");
		System.out.println("5. View all product");
		System.out.println("6. Show all category");
		System.out.println("7. Remove category");
		System.out.println("8. Exit");
		System.out.println(CYAN +"**************************"+RESET);
		
		
		int input = Integer.parseInt(scanner.nextLine());
		if(input > 8 || input<1)throw new NumberFormatException();
		
		System.out.println(CYAN +"**************************"+ RESET);
		
		
		
		
		switch(input) {
		
		case 1 ->  inventory.handleAddProduct();
            
		case 2 -> inventory.handleRemoveProduct();
			
		case 3 -> inventory.updateProduct();
		
		case 4 -> inventory.viewProduct();
			
		case 5 -> inventory.displayAllProduct();
		
		case 6 -> inventory.displayAllCategory();
		
		case 7 -> inventory.removeCategory();
		
		case 8 -> {scanner.close();
		inventory.saveProductListToFile();
		System.exit(0);}
		}System.out.println("\n");
			}catch(NumberFormatException e) {
				System.out.println("Please enter a number from 1 - 8");
				//e.printStackTrace();
			
				
			}catch(Exception e) {
				System.out.println("An error occured, please enter a number from 1-8");
			}
		}while(true);
		
		
		
		
		
		
		
	}

}
