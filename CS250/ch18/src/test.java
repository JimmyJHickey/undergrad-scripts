//Jimmy Hickey-8
//13-4-15

public class test {
	public static void main(String[] args){
		//create object
		NPSLinkedList<String> list = new NPSLinkedList<String>();
		
		//check if the list is empty
		if(list.isEmpty()==true){
			System.out.println("The list is empty.");}
		else{
			//check the size of the list if it is not empty
			System.out.println("The has " + list.size() + " elements.");}
		
		//add items to the list
		list.add("1");
		list.add("2");
		list.add("3");
		//check the size of the list
		System.out.println("The has " + list.size() + " elements.");
		
		//print the list
		for(int i=0; i < list.size(); i++){
			System.out.print(list.get(i)+ " ");
		}
		System.out.print("\n");
		
		//remove an item from the list
		list.remove("2");
		System.out.println("The has " + list.size() + " elements.");
		
		//print the list
				for(int i=0; i < list.size(); i++){
					System.out.print(list.get(i)+ " ");
				}
		System.out.print("\n");
	
		//add and remove an item at an index
		list.add(0, "one");
		list.remove(1);
		
		//print the list
			for(int i=0; i < list.size(); i++){
				System.out.print(list.get(i)+ " ");
			}
			System.out.print("\n");
		
		//check if the list contains an item
		System.out.println(list.contains("one"));
		
		//set an index to a value
		list.set(0, "two");
		
		//get an index of a value
		System.out.println(list.indexOf("two"));
		
		//print the list
			for(int i=0; i < list.size(); i++){
				System.out.print(list.get(i)+ " ");
			}
			System.out.print("\n");
	
			//clear the list and get the size
			list.clear();
			System.out.println(list.size());
	}
}
