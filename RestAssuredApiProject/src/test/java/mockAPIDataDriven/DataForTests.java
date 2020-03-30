package mockAPIDataDriven;

import org.testng.annotations.DataProvider;

public class DataForTests {
	
	@DataProvider(name="DataForPostFromClass")				//Using TestNG @DataProvider with name of DataForPost that we will pass to the function to use
	public Object [][] dataForPost() {						//This function is returning the array with the data
		
		return new Object [][] {							//Returning the array with the data
			{"lonny", "Dy", 3},
			{"Bova", "Io", 1},
			{"Dicko", "Jo", 2}
		};														
	}
	
	@DataProvider(name="DataToDeleteFromClass")				//Setting an DataProvider with a name DataToDelete 
	public Object[]dataForDelete() {			
		
		return new Object[] {								//Returning an array of ID's to delete
			12,14,13										//The ID numbers to delete - this is static - need to add the numbers manually 
		};
	}

}
