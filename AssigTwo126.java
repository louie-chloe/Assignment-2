/**
 * AssigTwo126.java
 * 
 * KIT107 Assignment 2 -- Harness Class
 * 
 * @author Julian Dermoudy
 * @version	28/3/2026
 * 
 * FILE IS COMPLETE
 */


import java.util.Scanner;


public class AssigTwo126
{
	/**
	 * main() -- entry point
	 * 
	 * @param args String[] -- command line arguments
	 * 
	 * Precondition: None
	 * Postcondition: A title will be displayed, a dataset read and stored,
	 * 					and then results will be shown on the screen for the
	 * 					specified searches.
	 * Informally: Read the datafile, store it, process it, and produce the
	 * 					results.
	 */
    public static void main(String []args)
    {
		final String FILENAME = "stats.csv";	// Filename of the file holding the dataset
		final int MIN_YEAR = 2012;				// earliest year of data
		final int MAX_YEAR = 2025;				// latest year of data

		FileHandler myFile;		// object for A2-related file handling
		Collection collection;	// collection of data within the program
		Scanner sc;				// scanner for input
		int year;				// year for analysis
		String team;			// team name for summary
		String dummy;			// dummy String to empty the input stream

		// produce title
		System.out.println();
		System.out.println("AFL Player Statistics");
		System.out.println("=====================\n");

		// initialise scanner
		sc = new Scanner(System.in);

		// obtain year for analysis, defaulting to maximum if invalid
		System.out.print("Which year's data (between " + MIN_YEAR + " and " + MAX_YEAR + ") do you wish to analyse? ");
		year = sc.nextInt();
		dummy = sc.nextLine(); // remove <Enter> key from input pipeline
		if ((year < MIN_YEAR) || (year > MAX_YEAR))
		{
			year = MAX_YEAR;
		}
		System.out.println("The year of analysis will be " + year + ".\n");

		// initialise collection and read in dataset for specified year
		collection = new Collection();
		myFile = new FileHandler(FILENAME);
		myFile.readFile(collection, year);

		System.out.println(collection.toString());  // comment when development is finished

		// produce histogram of frequencies of players per team
		collection.showPlayerHistogram();

		// produce results of searches based on different categories
		System.out.println("Most goals in " + year + " scored by:\n\t " + collection.most('g'));
		System.out.println("Most disposals in " + year + " by:\n\t " + collection.most('d'));
		System.out.println("Most experienced player in " + year +":\n\t " + collection.most('m'));
		System.out.println("Most clangers made in " + year +" by:\n\t " + collection.most('c'));
		System.out.println("Poorest sport in " + year +":\n\t " + collection.most('a'));

		// obtain team name for team to be summarised
		System.out.println();
		System.out.print("For which team would you like to see the " + year + " summary? ");
		team = sc.nextLine();

		// produce season summary for specified team
		System.out.println("\n" + team + "'s performance in " + year + " can be summarised as follows:");
		collection.summarise(team);

		sc.close();
    }
}