/**
 * PlayerInterface.java
 * 
 * KIT107 Assignment 2 -- Player Specification
 * 
 * @author Julian Dermoudy
 * @version	26/3/2026
 * 
 * FILE IS COMPLETE
 */


public interface PlayerInterface
{ 
    //public Player(String t, String p, int n, int d, int k, int m, int h, int g, int b, int o, int s, int c, int ff, int fa, double pt);
    public String getTeam();
    public void setTeam(String s);
    public String getName();
    public void setName(String s);
    public int getGames();
    public void setGames(int n);
    public int getDisposals();
    public void setDisposals(int n);
    public int getKicks();
    public void setKicks(int n);
    public int getMarks();
    public void setMarks(int n);
    public int getHandballs();
    public void setHandballs(int n);
    public int getGoals();
    public void setGoals(int n);
    public int getBehinds();
    public void setBehinds(int n);
    public int getHitouts();
    public void setHitouts(int n);
    public int getTackles();
    public void setTackles(int n);
    public int getClangers();
    public void setClangers(int n);
    public int getFreesFor();
    public void setFreesFor(int n);
    public int getFreesAgainst();
    public void setFreesAgainst(int n);
    public double getPlayTime();
    public void setPlayTime(double p);
    public int getGameCount();
    public void setGameCount(int n);
    public void update(Player p);
    public String toString();
}