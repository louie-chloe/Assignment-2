/**
 * FileHandlerInterface.java
 * 
 * KIT107 Assignment 2 -- FileHandler Specification
 * 
 * @author Julian Dermoudy
 * @version	23/3/2026
 * 
 * FILE IS COMPLETE
 */


public interface FileHandlerInterface
{
    //public FileHandler(final String FILENAME);
    public void openFile();
    public void closeFile();
    public void readFile(Collection collection, int year);
}