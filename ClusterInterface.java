/**
 * ClusterInterface.java
 * 
 * KIT107 Assignment 2 -- Cluster Specification
 * 
 * @author Julian Dermoudy
 * @version	23/3/2026
 * 
 * FILE IS COMPLETE
 */


public interface ClusterInterface
{
    //public Cluster();
    public boolean isEmpty();
    public void addPlayerToCluster(Player p);
    public Player getFirstPlayer();
    public int countPlayers();
    public Player most(char x);
    public String summary();
    public String toString();
}