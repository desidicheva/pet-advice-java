import javax.swing.JOptionPane;
/* 
PROJECT:Pet Advice
PURPOSE:Determine an appropriate pet for someone based on the type of  dwelling where they live and the number of hoursper day they are at home. 

*/
public class PetAdvice
{
	public static void main(String [] args)
	{
		int dwellingType;// user input apt (1), house (2), dorm (3)
		int hrsAtHome;	// user input for hours at home per day
		char userContinue = 'n';
		String userResponse = "n";
		
		do
		{
			dwellingType = getDwellingType();// method for dweeling type
			hrsAtHome = getHrsAtHome ();// method for dwelling hours at hrsAtHome
			// method for recommendeding a pet
			determinePet(dwellingType, hrsAtHome);	
			userResponse = JOptionPane.showInputDialog(null,
					"Enter Y to continue; anything else to stop.",
					"Continue Pet Advice",
					JOptionPane.QUESTION_MESSAGE);
			userContinue = userResponse.charAt(0);
		} while (userContinue == 'Y' || userContinue == 'y');
	}
/* 

	PURPOSE: Prompt user for valid values: 1 - apartment; 2 - house; 3 - dorm
*/	
	public static int getDwellingType()
	{
		int  intDwellingType; // variable for dwelling type input
		String strDwellingType;
		do
		{
			// print menu via dialog box and get user response
			strDwellingType = JOptionPane.showInputDialog(null, "Enter 1 for apartment, 2 foe house, or 3 for dorm.",
					"Dwelling Type", JOptionPane.QUESTION_MESSAGE);
			intDwellingType = Integer.parseInt(strDwellingType);
			if (intDwellingType < 1 || intDwellingType > 3)
			{
				JOptionPane.showMessageDialog(null, 
					"The value for dwelling type must be 1 for apartment, 2 foe house, or 3 for dorm",
					"Dwelling Type Error", 
					JOptionPane.ERROR_MESSAGE);
			}
		}while (intDwellingType < 1 || intDwellingType > 3);
		return intDwellingType;
	}
/* 
	PURPOSE: Prompt user for hours spent at home each day. Read user iput and displays a message.

*/	
	public static int getHrsAtHome()
	{
		int hrsAtHome;	// variable for number of hours spent at home
					    
		String strHoursAtHome;
		
		do
		{
		
			strHoursAtHome = JOptionPane.showInputDialog(null, "Enter the number of hours you spend at home.",
					"Hours at Home", JOptionPane.QUESTION_MESSAGE);
			hrsAtHome = Integer.parseInt(strHoursAtHome);
			if (hrsAtHome < 0 || hrsAtHome > 168)
			{
				JOptionPane.showMessageDialog(null, 
					"The number of hours per week must be between 0 and 168",
					"Hours at Home Error", 
					JOptionPane.ERROR_MESSAGE);
			}
		}while (hrsAtHome < 0 || hrsAtHome > 168);
		return hrsAtHome;
	}
/* 

	PURPOSE: Recommend and display a pet based on type of dwelling and the number of hours they are at home.
*/	
	public static void determinePet(int dwelling, int hrs)
	{
		String petType = "No pet"; //variable for pet type
		switch (dwelling)     // displays type of pet
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
