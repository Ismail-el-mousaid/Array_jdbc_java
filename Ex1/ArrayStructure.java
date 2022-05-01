package Ex1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayStructure {

	int[] tab = new int[20];
	
	public List<int[]> list = new ArrayList<>();
	
	public void remplire() {
		for(int i=0; i<tab.length; i++) {
			System.out.println("Donner element "+i);
			Scanner sc = new Scanner(System.in);
			tab[i] = sc.nextInt();
		}
	}
	

	public class ArrayStructureIterator implements Iterator<Integer> {
		
		private int index = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			if(index<tab.length -1)
				return true;
			return false;
		}
		
		@Override
		public Integer next() {
			// TODO Auto-generated method stub*
			if(index<tab.length) {
				int a = tab[index];
				index ++;
				return a;
			}
			else {
				throw new NoSuchElementException();
			}	
		}
		
	}
	
	
	
	
}
