
public interface ISet {

	//Adds an item to the set. Duplicates are not added
	public void add(Object item);
	
	//Returns true in an item is in the set, false if not
	public boolean in(Object item);
	
	//Returns an array of objects that are in the set and returns an empty array if the set is of size 0
	public Object[] toArray();
	
	//Create and return a new set from the items contained in the elements array. 
	public ISet fromArray(Object[] elements);
	
	//Return a new set that contains items in both "this" set and the other set
	public ISet intersection(ISet other);
	
	//Return a new set that contains the union of items in "this" set and the other set
	public ISet union(ISet other);
}