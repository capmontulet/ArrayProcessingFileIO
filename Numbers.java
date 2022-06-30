package lab2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

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
public class Numbers {
	
	//creates scanner object
	Scanner keyboard = new Scanner(System.in);
	
	
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor creates a default array size of 3, each element initialised to 0.0f
	 */
	public Numbers() {
		numbers = new Float[3];
		for(int i = 0; i<numbers.length;i++) {
			numbers[i]=0.0f;
		}
		numItems = 0;
	}

	/**
	 * Constructor that initialises the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		//creates array with size of given value, each element initialised to 0.0f
		numbers = new Float[size];
		for(int i = 0; i<numbers.length;i++) {
			numbers[i]=0.0f;
		}
		numItems = 0;
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		//if the array is full, message is displayed
		if(numbers.length == numItems) {
			System.out.println("Array full");
		}else {
		//value is added to array
		System.out.println("Enter value:");
		Float value = keyboard.nextFloat();
		numbers[numItems] = value;
		numItems++;
		}
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		//creates a total of all array elements
		float sum = 0.0f;
		for(int i=0; i<numItems;i++) {
			sum += numbers[i];
			}
		
		//divides sum of all elements by the size of the array to get the mean average
		float average = sum/numItems;
		
		//returns average
		return (float) average;
	}
	/**
	 * Prints the numbers on the array as a string
	 */
	@Override
	public String toString() {
		//StringBuilder class creates a string of all elements in array, except for if the element is 0.0f
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<numbers.length;i++) {
			if(numbers[i] != 0.0f) {
				builder.append(numbers[i] + "\n");
			}
		}
		//joined string is created
		String joined = builder.toString();
		//joined string returned
		return joined;
	}
	/**
	 * returns the average of elements in array, the minimum and maximum values in the array, and also returns modulo between those values.
	 */
	public void findMinMax() {
		//average is printed first
		System.out.print("Average is: ");
		System.out.printf("%.2f",calcAverage());
		
		//array is sorted from lowest to highest, minimum is first element, highest is last element
		Arrays.sort(numbers);
		float min = numbers[0];
		float max = numbers[numbers.length-1];
		
		//finding modulo for max and min
		float maxModMin = max % min;
		
		System.out.print(", Minimum value is: " + min + ", Maximum value is: " + max + ", max mod min is: ");
		System.out.printf("%.2f\n", maxModMin);
		
	}
	/**
	 * This method writes the current array into a text file. First an int to represent the length of the array, then a float on each line
	 * of the text file to represent each element of the array.
	 * @param fileName Is input by the user to specify name of file the array is saved to
	 */
	public void writeFile(String fileName) {
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(numbers.length+"\n");
		for(int i=0; i<numbers.length; i++) {
			writer.write(numbers[i].toString() + "\n");
		}
		writer.close();
		
		}catch(Exception ex) {
			return;
		}
	}
	/**
	 * This method reads a user specified text file and creates an array from the elements. If there is an existing array it appends 
	 * the contents of the text file onto it.
	 * @param fileName Is entered by the user to specifiy which file to read from
	 */
	public void readFile(String fileName) {
		numItems++;
		Scanner reader = null;
		try {
			reader = new Scanner(Paths.get(fileName));
		
		//length of file is taken
		int arrLength = reader.nextInt();
		//if the array in file is larger than array in memory, error is given
		if(arrLength>numbers.length) {
			System.out.println("File too large for array length");
		}else {
		//while the text file has tokens to read, it takes in float values only for elements initialised to 0.0f
		while(reader.hasNext()) {
			for(int i = 0; i<arrLength;i++) {
				for(int t = 0;t<numbers.length;t++) {
				if(numbers[t] == 0.0f) {
					//only takes in floats, and ignores non float characters in text file.
					numbers[t]= reader.nextFloat();
				}
				}
				numItems++;
		}
		if(reader != null) {
		reader.close();
		}
		}
		}
		} catch(IOException ioe) {
			System.out.println("***** File Not Found *****");
		} catch (Exception e) {	
			
		}
	
	}
	/**
	 * This method takes in multiple values and inserts them into array.
	 * @param valueNum Is entered by user to indicate how many elements they want to enter.
	 */
	public void multipleValues(int valueNum) {
		//if the array is full, message is displayed
		if(numbers.length == numItems) {
			System.out.println("Array full");
		}else {
			//if the array will be too full by the amount entered, message is displayed
			if(numbers.length<numItems+valueNum) {
				System.out.println("No room in array to add all values");
			}else {
				//for every element that is initialised to 0.0f, a value is taken from user.
		for(int i=0;i<valueNum;i++) {
			for(int t = 0;t<=numItems;t++) {
				if(numbers[t] == 0.0f) {
					System.out.print("Enter value: ");
					numbers[t]=keyboard.nextFloat();
				}
			}numItems++;
			
		}
		}
		}
		
	}
	
}
