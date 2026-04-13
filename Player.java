/**
 * Player.java
 * 
 * KIT107 Assignment 2 -- Player Implementation
 * 
 * @author Julian Dermoudy
 * @version	28/3/2026
 * 
 * FILE IS COMPLETE
 */


public class Player implements PlayerInterface
{
	// instance variables
    protected String team;    	// team name
    protected String name;    	// player name
    protected int games;		// number of games played
    protected int disposals;   	// total disposals in the game
    protected int kicks;      	// total kicks in the game
    protected int marks;     	// total marks in the game
    protected int handballs;	// total handballs in the game
    protected int goals;     	// total goals kicked in the game
    protected int behinds;    	// total points kicked in the game
	protected int hitouts;		// total hitouts in the game
	protected int tackles;		// total tackles laid in the game
	protected int clangers;		// total bad mistakes made in the game
	protected int freesFor;		// total free kicks received in the game
	protected int freesAgainst;	// total free kicks given away in the game
	protected double playTime;	// percentage of game the player played
	protected int gameCount;	// number of games played in the season

	/**
	 * Constructor
	 * 
	 * @param t String -- team name
     * @param p String -- player's name
     * @param n int -- number of games played
     * @param d int -- number of disposals
     * @param k int -- number of kicks
     * @param m int -- number of marks
     * @param h int -- number of handballs
     * @param g int -- number of goals
     * @param b int -- number of behinds
     * @param o int -- number of hitouts
	 * @param s int -- number of tackles
	 * @param c int -- number of clangers
	 * @param ff int -- number of frees for
	 * @param fa int -- number of frees against
	 * @param pt double -- percentage of game played
	 * 
	 * Precondition: None
	 * Postcondition: The new instance will have its instance variables
     *                  initialised with the relevant parameters.
	 * Informally: Initialise a player.
	 */
    public Player(String t, String p, int n, int d, int k, int m, int h, 
					int g, int b, int o, int s, int c, int ff, int fa,
					double pt)
    {
		final int FIRST_GAME = 1;	// the first game is game #1 for the player

    	team = t;
    	name = p;
    	games = n;
    	disposals = d;
    	kicks = k;
    	marks = m;
    	handballs = h;
    	goals = g;
    	behinds = b;
		hitouts = o;
		tackles = s;
		clangers = c;
		freesFor = ff;
		freesAgainst = fa;
		playTime = pt;
		gameCount = FIRST_GAME;
    }

     /**
	 * getTeam()
	 * 
	 * @return String -- the value in the team field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's team field is returned.
	 * Informally: Get the team field.
	 */
    public String getTeam()
    {
        return team;
    }

	/**
	 * setTeam()
	 * 
	 * @param t String -- String to be stored in team field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's team field is assigned the given
	 * 					value.
	 * Informally: Set the team field.
	 */
    public void setTeam(String t)
    {
        team = t;
    }

    /**
	 * getName()
	 * 
	 * @return String -- the value in the name field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's name field is returned.
	 * Informally: Get the name field.
	 */
    public String getName()
    {
        return name;
    }

	/**
	 * setName()
	 * 
	 * @param n String -- String to be stored in name field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's name field is assigned the given
	 * 					value.
	 * Informally: Set the name field.
	 */
    public void setName(String n)
    {
        name = n;
    }

    /**
	 * getGames()
	 * 
	 * @return int -- the value in the games field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's games field is returned.
	 * Informally: Get the games field.
	 */
    public int getGames()
    {
        return games;
    }

	/**
	 * setGames()
	 * 
	 * @param n int -- int to be stored in games field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's games field is assigned the given
	 * 					value.
	 * Informally: Set the games field.
	 */
    public void setGames(int n)
    {
        games = n;
    }

    /**
	 * getDisposals()
	 * 
	 * @return int -- the value in the disposals field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's disposals field is returned.
	 * Informally: Get the disposals field.
	 */
    public int getDisposals()
    {
        return disposals;
    }

	/**
	 * setDisposals()
	 * 
	 * @param n int -- int to be stored in disposals field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's disposals field is assigned the given
	 * 					value.
	 * Informally: Set the disposals field.
	 */
    public void setDisposals(int n)
    {
        disposals = n;
    }

    /**
	 * getKicks()
	 * 
	 * @return int -- the value in the kicks field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's kicks field is returned.
	 * Informally: Get the kicks field.
	 */
    public int getKicks()
    {
        return kicks;
    }

	/**
	 * setKicks()
	 * 
	 * @param n int -- int to be stored in kicks field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's kicks field is assigned the given
	 * 					value.
	 * Informally: Set the kicks field.
	 */
    public void setKicks(int n)
    {
        kicks = n;
    }

    /**
	 * getMarks()
	 * 
	 * @return int -- the value in the marks field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's marks field is returned.
	 * Informally: Get the marks field.
	 */
    public int getMarks()
    {
        return marks;
    }

	/**
	 * setMarks()
	 * 
	 * @param n int -- int to be stored in marks field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's marks field is assigned the given
	 * 					value.
	 * Informally: Set the marks field.
	 */
    public void setMarks(int n)
    {
        marks = n;
    }

    /**
	 * getHandballs()
	 * 
	 * @return int -- the value in the handballs field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's handballs field is returned.
	 * Informally: Get the handballs field.
	 */
    public int getHandballs()
    {
        return handballs;
    }

	/**
	 * setHandballs()
	 * 
	 * @param n int -- int to be stored in handballs field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's handballs field is assigned the given
	 * 					value.
	 * Informally: Set the handballs field.
	 */
    public void setHandballs(int n)
    {
        handballs = n;
    }

    /**
	 * getGoals()
	 * 
	 * @return int -- the value in the goals field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's goals field is returned.
	 * Informally: Get the goals field.
	 */
    public int getGoals()
    {
        return goals;
    }

	/**
	 * setGoals()
	 * 
	 * @param n int -- int to be stored in goals field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's goals field is assigned the given
	 * 					value.
	 * Informally: Set the goals field.
	 */
    public void setGoals(int n)
    {
        goals = n;
    }

    /**
	 * getBehinds()
	 * 
	 * @return int -- the value in the behinds field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's behinds field is returned.
	 * Informally: Get the behinds field.
	 */
    public int getBehinds()
    {
        return behinds;
    }

	/**
	 * setBehinds()
	 * 
	 * @param n int -- int to be stored in behinds field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's behinds field is assigned the given
	 * 					value.
	 * Informally: Set the behinds field.
	 */
    public void setBehinds(int n)
    {
        behinds = n;
    }

    /**
	 * getHitouts()
	 * 
	 * @return int -- the value in the hitouts field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's hitouts field is returned.
	 * Informally: Get the hitouts field.
	 */
    public int getHitouts()
    {
        return hitouts;
    }

	/**
	 * setHitouts()
	 * 
	 * @param n int -- int to be stored in hitouts field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's hitouts field is assigned the given
	 * 					value.
	 * Informally: Set the hitouts field.
	 */
    public void setHitouts(int n)
    {
        hitouts = n;
    }

    /**
	 * getTackles()
	 * 
	 * @return int -- the value in the tackles field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's tackles field is returned.
	 * Informally: Get the tackles field.
	 */
    public int getTackles()
    {
        return tackles;
    }

	/**
	 * setTackles()
	 * 
	 * @param n int -- int to be stored in tackles field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's tackles field is assigned the given
	 * 					value.
	 * Informally: Set the tackles field.
	 */
    public void setTackles(int n)
    {
        tackles = n;
    }

    /**
	 * getClangers()
	 * 
	 * @return int -- the value in the clangers field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's clangers field is returned.
	 * Informally: Get the clangers field.
	 */
    public int getClangers()
    {
        return clangers;
    }

	/**
	 * setClangers()
	 * 
	 * @param n int -- int to be stored in clangers field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's clangers field is assigned the given
	 * 					value.
	 * Informally: Set the clangers field.
	 */
    public void setClangers(int n)
    {
        clangers = n;
    }

    /**
	 * getFreesFor()
	 * 
	 * @return int -- the value in the freesFor field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's freesFor field is returned.
	 * Informally: Get the freesFor field.
	 */
    public int getFreesFor()
    {
        return freesFor;
    }

	/**
	 * setFreesFor()
	 * 
	 * @param n int -- int to be stored in freesFor field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's freesFor field is assigned the given
	 * 					value.
	 * Informally: Set the freesFor field.
	 */
    public void setFreesFor(int n)
    {
        freesFor = n;
    }

    /**
	 * getFreesAgainst()
	 * 
	 * @return int -- the value in the freesAgainst field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's freesAgainst field is returned.
	 * Informally: Get the freesAgainst field.
	 */
    public int getFreesAgainst()
    {
        return freesAgainst;
    }

	/**
	 * setFreesAgainst()
	 * 
	 * @param n int -- int to be stored in freesAgainst field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's freesAgainst field is assigned the given
	 * 					value.
	 * Informally: Set the freesAgainst field.
	 */
    public void setFreesAgainst(int n)
    {
        freesAgainst = n;
    }

    /**
	 * getPlayTime()
	 * 
	 * @return double -- the value in the playTime field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's playTime field is returned.
	 * Informally: Get the playTime field.
	 */
    public double getPlayTime()
    {
        return playTime;
    }

	/**
	 * setPlayTime()
	 * 
	 * @param p double -- double to be stored in playTime field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's playTime field is assigned the given
	 * 					value.
	 * Informally: Set the playTime field.
	 */
    public void setPlayTime(double p)
    {
        playTime = p;
    }

   /**
	 * getGameCount()
	 * 
	 * @return int -- the value in the gameCount field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's gameCount field is returned.
	 * Informally: Get the gameCount field.
	 */
    public int getGameCount()
    {
        return gameCount;
    }

	/**
	 * setGameCount()
	 * 
	 * @param n int -- int to be stored in gameCount field of player
	 * 
	 * Precondition: None
	 * Postcondition: the current object's gameCount field is assigned the given
	 * 					value.
	 * Informally: Set the gameCount field.
	 */
    public void setGameCount(int n)
    {
        gameCount = n;
    }

	/**
	 * update()
	 * 
	 * @param p Player -- player object which contains values to add to the current 
	 * 						object
	 * 
	 * Precondition: the current object and the given object have been properly
	 * 					initialised.
	 * Postcondition: the current object has been increased by the values from the
	 * 					given object.
	 * Informally: Update the current object with additional stats.
	 */
	public void update(Player p)
	{
		// total AFL games could be presented out of order; just store the greatest
		if (p.getGames() > getGames())
		{
			setGames(p.getGames());
		}

		// update all values by adding those from parameter p
		setDisposals(getDisposals() + p.getDisposals());
		setKicks(getKicks() + p.getKicks());
		setMarks(getMarks() + p.getMarks());
		setHandballs(getHandballs() + p.getHandballs());
		setGoals(getGoals() + p.getGoals());
		setBehinds(getBehinds() + p.getBehinds());
		setHitouts(getHitouts() + p.getHitouts());
		setTackles(getTackles() + p.getTackles());
		setClangers(getClangers() + p.getClangers());
		setFreesFor(getFreesFor() + p.getFreesFor());
		setFreesAgainst(getFreesAgainst() + p.getFreesAgainst());
		setPlayTime(getPlayTime() + p.getPlayTime());
		setGameCount(getGameCount() + 1);	// increment number of games played this season
	}

	/**
	 * toString()
	 * 
	 * @return String -- printable form of the player's data
	 * 
	 * Precondition: None
	 * Postcondition: A printable (String) form of the player's data is
     *                  returned.
	 * Informally: Convert a player's data to a String.
	 */
    public String toString()
    {
        return name + " (" + team + ") with " + games + " AFL game(s) had " + disposals + " disposals\n"
			+ "\tMarks: " + marks + "; kicks: " + kicks + "; handballs: " + handballs + " (including " + clangers + " clangers!)\n"
			+ "\tReceived: " + freesFor + " and gave away " + freesAgainst + " free kicks\n"
			+ "\tKicked: " + goals + "." + behinds + "." + (goals * 6 + behinds) + " and played " + String.format("%.2f", playTime/gameCount*100) + "% of their " + gameCount + " game(s).\n";
    }
}