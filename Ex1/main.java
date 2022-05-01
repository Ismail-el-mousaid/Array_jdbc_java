package Ex1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStructure a = new ArrayStructure();
		
		a.remplire();
		
		ArrayStructure.ArrayStructureIterator it = a.new ArrayStructureIterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		

	}

}
