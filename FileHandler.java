/**
 * FileHandler.java
 * 
 * KIT107 Assignment 2 -- FileHandler Implementation
 * 
 * @author Julian Dermoudy
 * @version	28/3/2026
 * 
 * FILE IS COMPLETE
 */


import java.io.*;


public class FileHandler implements FileHandlerInterface
{
    protected BufferedReader input; // input stream
    protected String fileName;      // name of datafile

	/**
	 * Constructor
	 * 
	 * @param FILENAME final String -- filename for dataset
	 * 
	 * Precondition: None
	 * Postcondition: The new instance will have its fileName field assigned
	 * 					the given value and its input field assigned null.
	 * Informally: Initialise a FileHandler.
	 */
    public FileHandler(final String FILENAME)
    {
        fileName = FILENAME;
        input = null;
    }
   
	/**
	 * openFile()
	 * 
	 * Precondition: fileName has been initialised to the name/path of an
     *                  existing, readable file.
	 * Postcondition: The nominated file is open for reading and the
     *                  BufferedReader object is assigned to the input
     *                  instance variable.  An exit status of 1 is given
	 * 					if there is an error opening the file.
	 * Informally: Open the datafile.
	 */
    public void openFile()
    {
        try
      	{
			// open the file
		    input = new BufferedReader(new FileReader(fileName));
		}
      	catch (IOException e)
		{
			// problem opening the file -- complain and quit!
		    System.err.println("Error opening " + fileName + " for loading");
		    System.exit(1);
		}
    }    
      
	/**
	 * closeFile()
	 * 
	 * Precondition: input refers to an open BufferedReader object.
	 * Postcondition: The file referred to by the input instance variable is
     *                  closed.
	 * Informally: Close the datafile.
	 */
    public void closeFile()
    {
        try
		{
			// close the file
			input.close();
		}
		catch (IOException e)
		{
			// problem opening the file -- complain!
			System.err.println("Error closing " + fileName + " -- " + e.toString());
		}
    }    
    
	/**
	 * readLine()
	 * 
     * @return String -- the next line of data from the comma-separated-value 
	 * 						(CSV) file
     * 
	 * Precondition: a CSV file (with comma-separated data) has been opened
     *                  for reading and its reference assigned to the input
     *                  instance variable.
	 * Postcondition: the next (non-comment) line from the CSV file is
     *                  returned (or null if end-of-file is reached).  An 
	 * 					exit status of 2 is given if there is an error when
	 * 					reading the file.
	 * Informally: Get the next line of data from the datafile.
	 */
	protected String readLine()
	{
   		String line;    // line from file

		// initialise variable
   		line = null;

   		try
   		{
            // get line from the file, skipping lines beginning with # (comments!)
   			line = input.readLine();
   			while ((line != null) && (line.indexOf('#') == 0)) // skip the comments
   			{
   				line = input.readLine();
   			}
   		}
		catch (IOException e)
		{
			// problem reading the file -- complain and quit!
            System.err.println("Error in " + fileName + " data");
            System.exit(2);
		}

	   	return line;
	}    
 
	/**
	 * readFile()
	 * 
     * @param collection Collection -- the collection of players to be constructed
	 * @param year int -- the year for the desired season to analyse
     * 
	 * Precondition: a text file with comma-separated values exists and the
     *                  program has read permission for it, the file's name
     *                  has been stored in the fileName instance variable,
     *                  and the given Collection parameter has been properly
     *                  constructed.
	 * Postcondition: the file is opened, read -- filling the collection
     *                  referred to on the parameter list up to LIMIT rows of
	 * 					data of the given year -- and closed.  An exit status
	 * 					of 3 is given if there is an error when instantiating
	 * 					the Player based upon a line of input.
	 * Informally: Read the data from the datafile for the given parameter and 
	 * 					store the data within the given collection parameter.
	 */
    public void readFile(Collection collection, int year)
    {
        final int LIMIT = Integer.MAX_VALUE;    // number of players to process; reduce to, e.g., 10 then 80 then 1200 when debugging
		final String DELIMITER = ",";			// comma separated data
		final int NUM_FIELDS = 31;				// number of fields in each row of data
        
        String line;        // line of data read from file
        String []tokens;    // line of data broken into fields separated by DELIMITER
        Player player;    	// player created from the line of data
        int count;          // count of number of players read from file so that stopping at LIMIT can be achieved

        // prepare for reading
        count = 0;
        openFile();

        // until end-of-file or LIMIT reached, read player's data, tokenise, and store in collection
        line = readLine();
        while ((line != null) && (count < LIMIT))
        {
			// split line of data into fields
            tokens = line.split(DELIMITER);
			if (tokens.length != NUM_FIELDS)
			{
				// not enough data on line -- complain and quit!
            	System.err.println("Insufficient fields on line " + count);
				System.err.println("Only " + tokens.length + " fields:");
				for (int i = 0; i < tokens.length; i++)
				{
					System.err.println(tokens[i]);
				}
				System.exit(3);
			}
			
			if (Integer.parseInt(tokens[0].substring(0,4)) == year)
			{
				count++;
				//System.out.println("Line " + count + " of " + LIMIT + " read"); // uncomment when debugging
				//System.out.println("\n\t" + line + "\n"); // uncomment when debugging
				
				// create Player using input values
				player = new Player(tokens[3], tokens[5], Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), 
								Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9]), Integer.parseInt(tokens[10]), 
								Integer.parseInt(tokens[11]), Integer.parseInt(tokens[12]), Integer.parseInt(tokens[13]), 
								Integer.parseInt(tokens[14]), Integer.parseInt(tokens[18]), Integer.parseInt(tokens[19]),
								Integer.parseInt(tokens[20]), Double.parseDouble(tokens[29])/100);

				// add the player to the collection
				collection.addPlayerToCollection(player);
			}
			else
			{
				//System.out.println("Ignored: \n\t" + line + "\n"); // uncomment when debugging
			}

			// move on to next line of data
            line = readLine();
        }

        // close the file
        closeFile();
    }
}