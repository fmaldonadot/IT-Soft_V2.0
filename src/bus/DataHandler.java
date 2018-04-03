package bus;

import java.util.*;
import java.util.Map.Entry;
import java.io.Serializable;

public class DataHandler <Key , AnyIP> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map< Key , AnyIP> mylist = new HashMap< Key , AnyIP>();

	public Map<Key, AnyIP> getMylist() {
		return mylist;
	}
	public void setMylist(Hashtable<Key, AnyIP> mylist) {
		this.mylist = mylist;
	}
	
	public DataHandler(){}
	public DataHandler(Map<Key, AnyIP> mylist) {
		super();
		this.mylist = mylist;
	}
	
	public void clear() {
		mylist.clear();
	}
	public boolean containsKey(Object arg0) {
		return mylist.containsKey(arg0);
	}
	public boolean containsValue(Object arg0) {
		return mylist.containsValue(arg0);
	}
	public Set<Entry<Key, AnyIP>> entrySet() {
		return mylist.entrySet();
	}
	public boolean equals(Object arg0) {
		return mylist.equals(arg0);
	}
	public AnyIP get(Object arg0) {
		return mylist.get(arg0);
	}
	public int hashCode() {
		return mylist.hashCode();
	}
	public boolean isEmpty() {
		return mylist.isEmpty();
	}
	public Set<Key> keySet() {
		return mylist.keySet();
	}
	public AnyIP add(Key arg0, AnyIP arg1) {
		return mylist.put(arg0, arg1);
	}
	public void putAll(Map<? extends Key, ? extends AnyIP> arg0) {
		mylist.putAll(arg0);
	}
			
	public AnyIP remove(Object arg0) {
		return mylist.remove(arg0);
	}
	
	public int remove( String sin ) //By Social Security
	{
		
		for ( Key curr : this.mylist.keySet() )
		{
			if ( this.mylist.get(curr).toString().contains(sin) )
			{
				this.mylist.remove(curr);
				return this.mylist.size();
			}
		}
		
		return -1;
		
	}
	public AnyIP search( String sin ) //By Social Security
	{
		
		for ( Key curr : this.mylist.keySet() )
		{
			if ( this.mylist.get(curr).toString().contains(sin) )
			{
				return this.mylist.get(curr);
			}
		}
		
		return null;
		
	}
	
	public int size() {
		return mylist.size();
	}
	public Collection<AnyIP> values() {
		return mylist.values();
	}
	
	public void display()
	{
		for(Key curr : mylist.keySet())
		{
			System.out.println(mylist.get(curr));
		}
		
	}
	
	// Modify Map
	public void modify( AnyIP emp , String sin)
	{
		for ( Key curr : this.mylist.keySet() )
		{
			if ( this.mylist.get(curr).toString().contains(sin) )
			{
				this.mylist.put(curr, emp);
				return;
			}
		}
			
	}
	
	public ArrayList<AnyIP> returnList()
	{
		ArrayList<AnyIP> templist = new ArrayList<AnyIP>();
		
		for ( Key curr : this.mylist.keySet() )
		{
			templist.add( this.mylist.get(curr) );			
		}		
		return templist;
	}
	// Check Unique SIN
	public boolean isUnique( String sin )
	{
		return this.mylist.containsValue(sin);
		
	}	
	
//

}
