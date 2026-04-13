/**
 * Collection.java
 * 
 * KIT107 Assignment 2 -- Collection Implementation
 * 
 * @author <<your name and student ID number>>
 * @version	<<date of completion>>
 */


public class Collection implements CollectionInterface
{
    // final instance variables
COMPLETE ME!

    
    // instance variables
COMPLETE ME!

    
	/**
	 * Constructor
	 * 
	 * Precondition: None
	 * Postcondition: The new instance will have its instance variable(s)
     *                  initialised.
	 * Informally: Initialise the Collection of player clusters ('teams').
	 */
    public Collection()
    {
COMPLETE ME!
    }

	/**
	 * isEmpty()
	 * 
	 * @return boolean -- whether the collection is empty
	 * 
	 * Precondition: None
	 * Postcondition: True is returned if the Collection is empty; false is
     *                  returned otherwise.
	 * Informally: Check whether the Collection is empty.
	 */
    public boolean isEmpty()
    {
COMPLETE ME! // to get past the compiler, use: return true;
    }

    /**
	 * addPlayerToCollection()
	 * 
	 * @param p Player -- the player to add to this collection
	 * 
	 * Precondition: The given Player parameter has been constructed
	 * Postcondition: The given Player has been added to the Collection and,
     *                  in particular to the appropriate cluster of players
     *                  based on the team name.
	 * Informally: Add a player to the appropriate 'team' in the
     *                  Collection.
	 */
    public void addPlayerToCollection(Player p)
    {
COMPLETE ME!
    }

    /**
	 * showPlayerHistogram()
	 * 
	 * Precondition: None
	 * Postcondition: The Collection is traversed cluster by cluster.  A
     *                  row comprising cluster name, a star for each
     *                  player in the cluster, and the total number of
     *                  players in the cluster is printed.  The message
     *                  "No data!" should be printed if the Collection is 
     *                  empty.
	 * Informally: Print the horizontal histogram of players per team
	 */
    public void showPlayerHistogram()
    {
COMPLETE ME!
    }

    /**
	 * most()
	 * 
	 * @param x char -- the category to search: frees-(a)gainst, (c)langers, 
     *                      (d)isposals, (g)oals, or ga(m)es
     *
     * @return String -- the printable form of the identified output
     *  
     * Precondition: None.
	 * Postcondition: All players in all teams in the Collection are searched to
     *                  find the player with the largest value in the given 
     *                  category (x).  The message "No data!" is returned if the 
     *                  Collection is empty.  In the case of a tie, the player
     *                  found last is the one whose data is returned.
	 * Informally: Search every player in the cluster for a value in the given
     *                  category and print the name and URL for all that match.
     */
    public String most(char x)
    {
COMPLETE ME! // to get past the compiler, use: return "";
    }

    /**
	 * summarise()
	 * 
     * @param t String -- the name of the desired team
     * 
	 * Precondition: None
	 * Postcondition: The Collection is traversed cluster by cluster.  The
     *                  aggregated statistics of all players for the chosen
     *                  team is calculated and printed.  The message "No data!" 
     *                  should be printed if the Collection is empty; the
     *                  message "Team (t) not found!" should be printed if the
     *                  Collection is not empty but there is no team with the
     *                  given team name present.
	 * Informally: Process the entire Collection displaying the combined
     *                  statistics for the given team.
	 */
    public void summarise(String t)
    {
COMPLETE ME! 
    }

	/**
	 * toString()
	 * 
	 * @return String -- printable form of the Collection of players
	 * 
	 * Precondition: None
	 * Postcondition: A printable (String) form of the Collections's 
     *                  players data is returned, one player per line.  If
     *                  there are no players then "" is returned.
	 * Informally: Convert the Collection of players data to a multi-line
     *                  String.
	 */
    public String toString()
    {
COMPLETE ME! // to get past the compiler, use: return "";
    }
}