/**
 * Cluster.java
 * 
 * KIT107 Assignment 2 -- Cluster Implementation
 * 
 * @author <<Duc Thang Luu 737396>>
 * @version	<<date of completion>>
 */


public class Cluster implements ClusterInterface
{
    // instance variables
    protected Node firstPlayer; // first node in the linked list of players




	/**
	 * Constructor
	 * 
	 * Precondition: None
	 * Postcondition: The new instance will have its instance variable(s)
     *                  initialised.
	 * Informally: Initialise the cluster of players.
	 */
    public Cluster()
    {
        firstPlayer = null;
    }

	/**
	 * isEmpty()
	 * 
	 * @return boolean -- whether the cluster is empty
	 * 
	 * Precondition: None
	 * Postcondition: True is returned if the Cluster is empty; false is
     *                  returned otherwise.
	 * Informally: Check whether the Cluster is empty.
	 */
    public boolean isEmpty()
    {
       return firstPlayer == null;
    }

    /**
	 * addPlayerToCluster()
	 * 
	 * @param p Player -- the player to add to this cluster
	 * 
	 * Precondition: The given Player parameter has been constructed.
	 * Postcondition: The given Player has been added to the Cluster of
     *                  players preserving the alphabetical order and
     *                  secondarily ordering by games played.
	 * Informally: Add a player to the Cluster.
	 */
    public void addPlayerToCluster(Player p)
    {
        Node newNode; // new node to store the player when an insert is needed
		Node previous; // node before the current position in the list
		Node current; // node currently being exanmied in the list
		Player currentPlayer; // player stored in the current node
		int comparison; // comparison result between current name and new name`
		boolean finished; // whether the correct action has been completed

		newNode = new Node(p);

		// if the list is empty, the new player becomes the first node
		if (isEmpty()){
			firstPlayer = newNode;
		}
		else{
			previous = null;
			current = firstPlayer;
			fisnishes = false;

			// move through the list until the player is updated or inserted
			while ((current != null) && (!finished)){
				currentPlayer = (Player) current.getData();
				comparison = currentPlayer.getName().compareTo(p.getName());

				if (comparison == 0){
					// same player name: combine the new game's statistics
					currentPlayer.update(p);
					finished = true;
				}
				else{
					if (comparison > 0){
						// current player comes after the new player alphabetically'
						// so insert the new player before the current node
						if (previous == null){
							newNode.setnext(firstPlayer);
							firstPlayer = newNode;
						}
						else{
							newNode.setNext(current);
							previous.setNext(newNode);
						}
						finished = true;
					}
					else{
						// keep looking further down the list
						previous = current;
						current = current.getNext();
					}
				}
			}
			// if the ned was rreached, the player belongs at the end of the list
			if(!finished){
				previous.setNext(newNode);
			}
		}
						
    }

 	/**
	 * getFirstPlayer()
	 * 
	 * @return Player -- the first player in the cluster
	 * 
	 * Precondition: None
	 * Postcondition: the first player in the cluster is returned if the
     *                  cluster is non-empty; null is returned otherwise.
	 * Informally: Get the first player in thge cluster.
	 */
    public Player getFirstPlayer()
    {
       Player answer; // first player in the cluster
		answer = null;
		if (!isEmpty()){
			answer = (Player) firstPlayer.getData();
		}
		return answer;
    }

   /**
	 * countPlayers()
	 * 
	 * @return int -- the number of players in the cluster
	 * 
	 * Precondition: None
	 * Postcondition: The number of players in the Cluster has been counted and
     *                  returned.
	 * Informally: Produce a count of players within the current Cluster.
	 */
    public int countPlayers(){
      Node current; // current node visit in the list
	  int count; // number of players in the cluster
      count = 0;
	  current = fisrtPlayer;

		// count node in the linked list
		while (current != null){
			count++;
			current = current.getNext();
		}
		return count;
	}

    /**
	 * most()
	 * 
	 * @param x char -- the category to search ('g'oals, 'd'isposals, 'c'langers,
     *                      frees 'a'gainst, or ga'm'es)
     * @return Player -- the player with the highest value in the specified
     *                      category
     * 
     * Precondition: None.
	 * Postcondition: All players in the Cluster are searched for the given maximum
     *                  in the category indicated (x) and the player with the
     *                  highest is returned.  If there are multiple players then the
     *                  last found is returned; if there are no data then null is
     *                  returned.
	 * Informally: Find the player in the Cluster with the maximum value in the 
     *                  given category.
	 */
    public Player most(char x)
    {
       Node current;// current node being visited in the list
	   Player currentPlayer;// player stored in the current node
	   Player bestPlayer;//player with the highest value
	   int currentValue;//category value for current player
	   int bestValue;//best category
		
       bestPlayer = null;
		
	   if (!isEmpty()){
		   current = firstPlayer;
		   
		   while (current != null){
			   currentPlayer = (Player) current.getData();
			   currentValue = getCatergoryValue(currentPlayer, x);
			   
			   if (bestPlayer == null){
				   bestlayer = currentPlayer;
			   }
			   else{
				   bestValue = getCategoryValue(bestPlayer, x);
				   if (currentValue >= bestValue){
					   
					   bestPlayer = currentPlayer;
				   }
			   }
			   current = current.getNext();
		   }
	   }
	   return bestPlayer;
    }

    /**
	 * summary()
	 * 
	 * @return String -- the summary of statistics for the current Cluster (i.e. team)
	 * 
	 * Precondition: None
	 * Postcondition: A String has been returned which is the summary of the current
     *                  team's statistics, or "" if the cluster is empty.
	 * Informally: Produce a summary of the current Cluster.
	 */
    public String summary()
    {
        Node current;         // current node being visited in the list
        Player currentPlayer; // player stored in the current node
        int disposals;        // combined disposals for the whole team
        int marks;            // combined marks for the whole team
        int kicks;            // combined kicks for the whole team
        int handballs;        // combined handballs for the whole team
        int hitouts;          // combined hitouts for the whole team
        int tackles;          // combined tackles for the whole team
        int clangers;         // combined clangers for the whole team
        int freesFor;         // combined free kicks received by the whole team
        int freesAgainst;     // combined free kicks given away by the whole team
        int goals;            // combined goals for the whole team
        int behinds;          // combined behinds for the whole team
        String result;        // final summary string

        result = "";// to get past the compiler, use: return "";

		if (!isEmpty())
        {
            disposals = 0;
            marks = 0;
            kicks = 0;
            handballs = 0;
            hitouts = 0;
            tackles = 0;
			clangers = 0;
            freesFor = 0;
            freesAgainst = 0;
            goals = 0;
            behinds = 0;
            current = firstPlayer;

			while (current != null)
            {
                currentPlayer = (Player) current.getData();
                disposals = disposals + currentPlayer.getDisposals();
                marks = marks + currentPlayer.getMarks();
                kicks = kicks + currentPlayer.getKicks();
				handballs = handballs + currentPlayer.getHandballs();
                hitouts = hitouts + currentPlayer.getHitouts();
                tackles = tackles + currentPlayer.getTackles();
                clangers = clangers + currentPlayer.getClangers();
                freesFor = freesFor + currentPlayer.getFreesFor();
                freesAgainst = freesAgainst + currentPlayer.getFreesAgainst();
                goals = goals + currentPlayer.getGoals();
                behinds = behinds + currentPlayer.getBehinds();
                current = current.getNext();
			}
			// build the final multi-line summary string
			result = "\tThere were: " + disposals + " disposals (Marks: " + marks
                + "; kicks: " + kicks + "; handballs: " + handballs
                + "; hitouts: " + hitouts + ")\n"
                + "\tTackles: " + tackles + " Clangers: " + clangers + "\n"
                + "\tFree kicks: " + freesFor + " for and " + freesAgainst
                + " against\n"
                + "\tScoring: " + goals + "." + behinds + " for a total of "
                + (goals * 6 + behinds) + " points.";

				
    }

	/**
	 * toString()
	 * 
	 * @return String -- printable form of the Cluster of players
	 * 
	 * Precondition: None
	 * Postcondition: A printable (String) form of the players data is
     *                  returned, one player per line.  If there are no
     *                  players then "" is returned.
	 * Informally: Convert the Cluster of players data to a multi-line
     *                  String.
	 */
    public String toString()
    {
        Node current;     // current node being visited in the list
        String result;    // final printable form of the cluster

        result = "";
        current = firstPlayer;

        // add each player's printable form to the result string
        while (current != null)
        {
            result = result + current.getData().toString();
            current = current.getNext();
        }

        return result;
    }

    /**
	 * getCategoryValue()
	 *p player -- player whose statistics is neeeded
	 *x char -- category code
	 *@return int -- the value of that category for the player
	 */


    protected int getCaregoryValue(Player p, char x){
		int value; // statistic value choose from player object
		value = 0
		if (x =='g'){
			value = p.getGoals();
		}
		else{
			if (x == 'd'){
				value = p.get.Disposal();
			}
			else{
				if (x == 'm'){
					value = p.getGames();
				}
				else{
					if (x == 'c'){
						value = p.getClangers();
					}
					else{
						if (x == 'a'){
							value = p.getFreesAgainst();
						}
					}
				}
			}
		}

		return value;
	}
}

