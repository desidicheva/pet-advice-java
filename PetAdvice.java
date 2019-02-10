import javax.swing.JOptionPane;
/* P E T   A D V I C E  
AUTHOR: 	R Grant
DATE CREATED: 1/99
PURPOSE: 	Determine an appropriate pet for someone based on the type of 
			dwelling where they live and the number of hours
			per day they are at home. 
			This solution demonstrates the 'if' and 'switch' statements. 
ARGUMENTS: None
*/
public class PetAdvice
{
	public static void main(String [] args)
	{
		int dwellingType;// user input indicating  apt (1), house (2), dorm (3)
		int hrsAtHome;	// user input; hours this person stays at home per day:
		char userContinue = 'n';
		String userResponse = "n";
		
		do
		{
			dwellingType = determineDwellingType();// determine if user lives in  apt, house, or dorm
			hrsAtHome = determineHrsAtHome ();// determine number of hrs person is home/day
			// determine and print recommended pet
			determinePet(dwellingType, hrsAtHome);	
			userResponse = JOptionPane.showInputDialog(null,
					"Enter Y to continue; anything else to stop.",
					"Continue Pet Advice",
					JOptionPane.QUESTION_MESSAGE);
			userContinue = userResponse.charAt(0);
		} while (userContinue == 'Y' || userContinue == 'y');
	}
/* 
	AUTHOR: 		R Grant
	DATE CREATED: 	1/99
	PURPOSE: 		Prompt user for valid values to indicate type of dwelling. Read and edit user
					input. If input is valid, return the input to calling method. If input is invalid,
					display a message and end the application.
	ARGUMENTS: 		None
	RETURN: 		int representing the type of dwelling; 1 - apartment; 2 - house; 3 - dorm
*/	
	public static int determineDwellingType()
	{
		int  intDwellingType; // variable to store user input after converted to int
		String strDwellingType;
		do
		{
			// print menu via dialog box and get user response
			strDwellingType = JOptionPane.showInputDialog(null, "Enter 1 (apartment), 2 (house), or 3 (dorm).",
					"Dwelling Type", JOptionPane.QUESTION_MESSAGE);
			intDwellingType = Integer.parseInt(strDwellingType);
			if (intDwellingType < 1 || intDwellingType > 3)
			{
				JOptionPane.showMessageDialog(null, 
					"The value for dwelling type must be 1 (apartment), 2 (house), or 3 (dorm)",
					"Dwelling Type Error", 
					JOptionPane.ERROR_MESSAGE);
			}
		}while (intDwellingType < 1 || intDwellingType > 3);
		return intDwellingType;
	}
/* 
	AUTHOR: 		R Grant
	DATE CREATED: 	1/99
	PURPOSE: 		Prompt user for valid  hours spent at home each day. 
					Read and edit user input. If input is valid, return the input to calling method. 
					If input is invalid, display a message and end the application.
	ARGUMENTS: 		None
	RETURN: 		int representing number of hours spent per day at home.
*/	
	public static int determineHrsAtHome()
	{
		int hrsAtHome;	// user input indicating number of hours spent at
					    // home per day
		String strHoursAtHome;
		
		do
		{
			// print menu via dialog box and get user response
			strHoursAtHome = JOptionPane.showInputDialog(null, "Enter the number of hours per week you are home.",
					"Hours at Home", JOptionPane.QUESTION_MESSAGE);
			hrsAtHome = Integer.parseInt(strHoursAtHome);
			if (hrsAtHome < 0 || hrsAtHome > 168)
			{
				JOptionPane.showMessageDialog(null, 
					"The number of hours per week you are home must be between 0 and 168 inclusive",
					"Hours at Home Error", 
					JOptionPane.ERROR_MESSAGE);
			}
		}while (hrsAtHome < 0 || hrsAtHome > 168);
		return hrsAtHome;
	}
/* 
	AUTHOR: 		R Grant
	DATE CREATED: 	1/99
	PURPOSE: 		Recommend and display a pet based on type of dwelling a person 
					lives in and the number of hours they are at home each day.
	ARGUMENTS: 		int representing dwelling - code indicating type of dwelling 
									1 - apartment
									2 -house
									3 - dormitory
					int hrs - minimum hours user spends at home each day
	RETURN: None
*/	
	public static void determinePet(int dwelling, int hrs)
	{
		String petType = "No pet"; //temp variable to hold pet recommendation
		switch (dwelling)     // recommend and display type of pet
		{
			case 1:  //dwelling is apartment
				if (hrs >= 10)
					petType ="cat";
				else
					petType = "hamster";
				break;
			case 2:  //dwelling is house
				if (hrs >= 18)
					petType = "pot bellied pig";
				else
				if (hrs >= 10)
					petType = "dog";
				else	
					petType = "snake";
				break;
			case 3:  //dwelling is dorm				 
				if (hrs >= 6)
					petType =  "fish";
				else
					petType = "ant farm";
				break;
		}
		JOptionPane.showMessageDialog(null, 
				"You should get a " + petType +"!",
				"Recommended Pet", JOptionPane.INFORMATION_MESSAGE);
	}
}