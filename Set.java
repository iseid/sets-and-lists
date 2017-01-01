
public class Set extends LinkedList implements ISet {

	public void add(Object item) {
		if(this.in(item) == false) {
			super.add(item);
		}
	}

	@Override
	public boolean in(Object item) {
		Node curr = head;
		while(curr != null) {
			if(item.equals(curr.getItem())) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] temp =new Object[this.size];
		int i=0;
		if(size == 0) {
			return temp;
		}
		for (Node current = head; current != null; current = current.getNext()) {
			temp[i++] = current.getItem();
		}
		return temp;
	}

	@Override
	public ISet fromArray(Object[] elements) {
		ISet s = new Set();
		if(elements.length == 0) {
			return s;
		}
		for(int i=0;i<elements.length;i++) {
			s.add(elements[i]);
		}
		return s;
	}

	@Override
	public ISet intersection(ISet other) {
		Object[] obj1 = other.toArray();
		Object[] obj2 = this.toArray();
		ISet temp = new Set();
		for(int i=0;i<obj1.length;i++) {
			for(int j=0;j<obj2.length;j++) {
				if(obj1[i].toString().equals(obj2[j].toString())==true) {
					temp.add(obj1[i]);
				}
			} 
		}
		return temp;   
	}

	@Override
	public ISet union(ISet other) {
		Object[] setTemp = other.toArray();
		Object[] temp = this.toArray();
		int i=0;
		int j=0;
		ISet s = new Set();
		while(i<setTemp.length && j<temp.length) {
			s.add(setTemp[i++]);
			s.add(temp[j++]);
		}
		while(i<setTemp.length) {
			s.add(setTemp[i++]);
		}
		while(j<temp.length) {
			s.add(setTemp[i++]);
		}
		return s;
	}

	public static void main(String[] args) {

		ISet tester = new Set();

		String [] s1 = {"Isaac", "Bill", "Jim", "Darnell", "Sunset"};
		String [] s2 = {"Isaac", "Giles", "Johan", "Joe", "Ben"};
		ISet main1 = tester.fromArray(s1);
		ISet main2 = tester.fromArray(s2);
		System.out.println(main1);
		System.out.println();
		System.out.println( main2);
		//print out sets
		
		System.out.println();

		ISet main3 = main1.intersection(main2);
		System.out.println("Intersection of the sets: " + main3);
		//prints the intersection correctly
		
		System.out.println();
		
		ISet main5 = main1.union(main2);
		System.out.println("Union of the sets: " + main5);
		//prints the union properly
		
		System.out.println();

		String[] dog = {};
		ISet main4 = tester.fromArray(dog);
		System.out.println("Does the empty set print correctly? " + main4);
		//empty set prints a set of size 0
		
		System.out.println();

		String[] cat = {"Isaac", "Isaac", "Hello"};
		ISet main6 = tester.fromArray(cat);
		System.out.println(main6);
		//does not print duplicate entries

	}
}