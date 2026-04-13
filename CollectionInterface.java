/**
 * CollectionInterface.java
 * 
 * KIT107 Assignment 2 -- Collection Specification
 * 
 * @author Julian Dermoudy
 * @version	23/3/2026
 * 
 * FILE IS COMPLETE
 */


public interface CollectionInterface
{
    //public Collection();
    public boolean isEmpty();
    public void addPlayerToCollection(Player p);
    public void showPlayerHistogram();
    public String most(char x);
    public void summarise(String t);
    public String toString();
}