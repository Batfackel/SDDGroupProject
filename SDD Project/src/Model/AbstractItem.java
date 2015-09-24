package Model;

/*
 * Interface that can be used to build new items 
 */

/**
 *
 * @author Michael McGregor
 */
public interface AbstractItem {
    public int getItem();
    public void setItem(int item);
    public void timeout();
}
