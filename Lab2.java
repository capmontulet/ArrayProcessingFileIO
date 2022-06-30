package lab2;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Thomas Stanley
 * Student Number: 41037136      
 * Section #: 301 
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */
public class Lab2 {
	
	/**
	 * This method prints a main menu to the user, that exits once the corresponding option is selected.
	 */
	private static void displayMainMenu() {
		System.out.println("Please select one of the following:");
		System.out.println("1: Initialise a default array");
		System.out.println("2: To specify the max size of the array");
		System.out.println("3: Add value to an array");
		System.out.println("4: Display values in the array");
		System.out.println("5: Display average of the values, minumum value, maximum value, maximum modulo minimum");
		System.out.println("6: Enter multiple values");
		System.out.println("7: Read values from file");
		System.out.println("8: Save values to file");
		System.out.println("9: To Exit");
	}

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {
		//creating loop variable
		boolean loop = true;
		//creating new Numbers object
		Numbers numbers = new Numbers();
		//ensuring only numeric values are entered for whole menu
		while(loop==true) {
			try {
		//start of menu
			displayMainMenu();
			int option = numbers.keyboard.nextInt();
			
			//switch case for menu
			switch(option) {
			case 1:
				numbers = new Numbers();
				break;
			case 2:
				System.out.print("Enter new size of array: ");
				//user input is taken for array size
				int numbersLength = numbers.keyboard.nextInt();
				numbers = new Numbers(numbersLength);
				break;
			case 3:
				numbers.addValue(numbers.keyboard);
				break;
			case 4:
				System.out.println("Numbers are: \n" + numbers.toString());
				break;
			case 5: 
				numbers.findMinMax();
				break;
			case 6:
				System.out.print("How many values do you wish to add? " );
				int valueNum = numbers.keyboard.nextInt();
				numbers.multipleValues(valueNum);
				break;
			case 7:
				System.out.println("Please enter name of file: ");
				String fileNameInput = numbers.keyboard.next();
				numbers.readFile(fileNameInput);
				break;
			case 8:
				System.out.println("Please Enter Name of file: ");
				String fileNameOutput = numbers.keyboard.next();
				numbers.writeFile(fileNameOutput);
				break;
			case 9:
				System.out.println("Exiting...");
				numbers.keyboard.close();
				//loop condition is broken and is exited
				loop = false;
				break;
				default:
					System.out.println("Please Enter a value between '1' and '9'");
				
			}//end of switch
		//end of menu loop
		
		}catch(Exception e) {
			System.out.println("Invalid Input \n");
			numbers.keyboard.nextLine();
		}
			
		}//end of try catch
		
		
	}

}
