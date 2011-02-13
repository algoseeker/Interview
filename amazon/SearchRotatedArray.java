import java.io.*;
import java.util.*;

public class SearchRotatedArray{
	static int position=-1;

	public static void main(String[] args){
		ArrayList<Integer> array = new ArrayList<Integer>();
		try{
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String s;
		while((s=reader.readLine())!=null){
			try{
			array.add(Integer.parseInt(s));
			} catch(NumberFormatException e){
				System.out.println("Improper number format");
				e.printStackTrace();
			}
		}
		Console c = System.console();
		if(c==null){
			System.err.println("No console");
			System.exit(1);
		}
		
		String search = c.readLine("Enter number to be searched: ");
		try{
		int k = Integer.parseInt(search);
		if(search(array,0,array.size()-1,k)){
			System.out.println("Found at " + position);				
			} else {
			 System.out.println("Not found");
			}
		} catch(NumberFormatException e){
			e.printStackTrace();
		}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public static boolean search(ArrayList<Integer> a, int start, int end, int key){
		int mid = (start+end)/2;
		if(a.get(mid)==key){
		 position = mid;
		 return true;
		} else if(start==end){
		  return false;
		}
		if(a.get(start)<=a.get(mid)){
			if(a.get(start)<=key && key<a.get(mid)){
			 return search(a,start,mid-1,key);
			} else{
			 return search(a,mid+1,end,key);
			}
		} else {
			if(a.get(mid)<key && key<=a.get(end)){
			  return search(a,mid+1,end,key);
			}else{
			  return search(a,start,mid-1,key);
			}
		}
	}
}
