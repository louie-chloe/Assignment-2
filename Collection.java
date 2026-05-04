/**
 * Collection.java
 * 
 * KIT107 Assignment 2 -- Collection Implementation
 * 
 * @author <<Duc Thang Luu 737396>>
 * @version	<<date of completion>>
 */


public class Collection implements CollectionInterface
{
    // final instance variables
    protected final int MAX_TEAMS = 18;    // maximum number of AFL teams in the collection
    protected final int TEAM_WIDTH = 22;   // width used to line up histogram team names


    
    // instance variables
    protected Cluster []teams;    // array holding the team clusters
    protected int countTeams;     // number of team clusters currently stored


    
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
        teams = new Cluster[MAX_TEAMS];
        countTeams = 0;
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
       return countTeams == 0; // to get past the compiler, use: return true;
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
        int position;          // index where team is found or should be inserted
        String currentTeam;    // team name already stored at the current position
        Cluster newCluster;    // new cluster created for a team not yet in the collection
        int i;                 // loop counter used when shifting array elements
        position = 0;

        // find the first position where the existing team is not before p's team
        while ((position < countTeams)
                && (getTeamName(teams[position]).compareTo(p.getTeam()) < 0))
        {
            position++;
        }
		// if the team already exists, add the player to that cluster
        if ((position < countTeams)
                && (getTeamName(teams[position]).equals(p.getTeam())))
        {
            teams[position].addPlayerToCluster(p);
        }
        else
        {
            // shift teams right to make room for the new team cluster
            for (i = countTeams; i > position; i--)
            {
                teams[i] = teams[i - 1];
            }

            // create the new cluster, add the player, and store the cluster
            newCluster = new Cluster();
            newCluster.addPlayerToCluster(p);
            teams[position] = newCluster;
            countTeams++;
        }
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
        int i;              // loop counter for traversing the teams array
        String teamName;    // team name for the current histogram row
        int playerCount;    // number of players in the current team
        int j;              // loop counter for printing the stars
        String stars;       // row of stars for the current team

        System.out.println("Count of players per team:");
		if (isEmpty())
        {
            System.out.println("No data!");
        }
        else
        {
            for (i = 0; i < countTeams; i++)
            {
                teamName = getTeamName(teams[i]);
                playerCount = teams[i].countPlayers();
                stars = "";

				for (j=0, j < playerCount, j++){
					stars = stars + "*"
						}

				System.out.println(String.format("%" + TEAM_WIDTH + "s | %s %d",teamName, stars, playerCount));
			}
		}
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
        int i;                // loop counter for traversing the teams array
        Player teamBest;      // best player found in the current team
        Player overallBest;   // best player found in the whole collection
        int teamValue;        // requested value for the current team's best player
        int bestValue;        // requested value for the overall best player
        String result;        // final result returned to the caller

        result = "No data!";

		if (!isEmpty())
        {
            overallBest = null;

                // ask each team for its best player in the requested category
            for (i = 0; i < countTeams; i++)
				{
                teamBest = teams[i].most(x);
                if (teamBest != null)
                {
                    if (overallBest == null)
                    {
                        overallBest = teamBest;
                    }
                    else
                    {
                        teamValue = getCategoryValue(teamBest, x);
                        bestValue = getCategoryValue(overallBest, x);
                        if (teamValue >= bestValue)
                        {
                            overallBest = teamBest;
                        }
                    }
                }
            }
            if (overallBest != null){
				result = overallBest.tótring();
			}
		}
		return result
	}
	
 // to get past the compiler, use: return "";
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
        int i;              // loop counter for traversing the teams array
        boolean found;      // whether the requested team has been found

        if (isEmpty())
        {
            System.out.println("No data!");
        }
        else
        {
            i = 0;
            found = false;
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
        int i;// loop counter for traversing the teams array
        String result;// final printable form of the collection

        result = "";

        // join together the printable form of every cluster in order
        for (i = 0; i < countTeams; i++)
        {
            result = result + teams[i].toString();
        }

        return result;
    }


	/**
     * getTeamName()
     * 
     * @param c Cluster -- team cluster whose name is needed
     * @return String -- the name of the team stored in the cluster
     * 
     * Precondition: The cluster is non-empty.
     * Postcondition: The team name from the first player in the cluster is returned.
     * Informally: Get the name used to identify a cluster in the collection.
     */
	protected String getTeamName(Cluster c)
    {
        return c.getFirstPlayer().getTeam();
    }

   /**
     * getCategoryValue()
     * 
     * @param p Player -- player whose statistic is needed
     * @param x char -- category code
     * @return int -- the value of that category for the player
     * 
     * Precondition: The player has been constructed.
     * Postcondition: The requested statistic has been returned.
     * Informally: Convert the category code into the matching player field.
     */

   protected int getCategoryValue(Player p, char x)
   {
	   int value; // statistic value chosen from the player object
	   value = 0;
	   if (x == 'g')
        {
            value = p.getGoals();
        }
        else
        {
            if (x == 'd')
            {
                value = p.getDisposals();
            }
            else
            {
                if (x == 'm')
                {
                    value = p.getGames();
                }
                else
                {
                    if (x == 'c')
                    {
                        value = p.getClangers();
                    }
                    else
                    {
                        if (x == 'a')
                        {
                            value = p.getFreesAgainst();
                        }
                    }
                }
            }
        }

        return value;
    }
}

}
