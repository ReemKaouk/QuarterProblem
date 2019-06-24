
import java.util.ArrayList;
import java.util.List;

public class Coin{
	
	public String type;
	
	//constructor
	public Coin(String s){
		this.type = s;
	}

	//get the year of the quarter
	public int GetYear(){
		String s = this.type;
		return Integer.parseInt(s.substring(s.length()-4));
	}
	
	//counting quarters
	public static int CountQuarters(List<Coin> A){
		int counter = 0; 
		for(int i=0; i<A.size();i++){
			if(A.get(i).type.charAt(0) == 'q'){
				counter++; //counting quarters
			}
		}
		return counter;
	}
	
	public static boolean isQuarterEquivalent(List<Coin> A, List<Coin> B){
		if(CountQuarters(A)!=CountQuarters(B)){
			return false; //equal number of quarters to be in same order
		}
		
		int y1[] = new int[CountQuarters(A)];
		int y2[] = new int[CountQuarters(B)];
		int index = 0;
		int index1 = 0;
		for(int i=0;i<A.size();i++){
			if(A.get(i).type.charAt(0) == 'q'){ //if quarter coin get the year and add to an array
				y1[index] = A.get(i).GetYear();
				index++;
			}
		}
		for(int j=0;j<B.size();j++){
			if(B.get(j).type.charAt(0) == 'q'){ //if quarter coin get the year and add to an array
				y2[index1] = B.get(j).GetYear();
				index1++;
			}
		}
		
		for(int k=0;k<y1.length-1;k++){
			if(y1[k+1]-y1[k] != y2[k+1]-y2[k]){//the quarters in the two lists are not in the same order
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void print(List<Coin> A){
		for(int i=0;i<A.size();i++){
			System.out.println(A.get(i).type);
		}
		System.out.println();
	}
	
	public static void main(String[] args){
	
		List<Coin> A = new ArrayList<Coin>();
		List<Coin> B = new ArrayList<Coin>();
		
		System.out.println();
		A.add(new Coin("quarter1976"));
		A.add(new Coin("quarter1979"));
		A.add(new Coin("nickel1870"));
		A.add(new Coin("quarter1980"));
		//A.add(new Coin("nickel1990"));
		print(A);
		B.add(new Coin("quarter1963"));
		B.add(new Coin("quarter1966"));
		B.add(new Coin("quarter1967"));
		//B.add(new Coin("quarter1990"));
		print(B);
		System.out.println(isQuarterEquivalent(A,B)); //returns true
		
	}
}

