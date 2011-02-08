/*
You are given a array with rows sorted and column sorted. You have to print entire array in sorted order.
e.g.
0 2 3 4
0 3 4 5
1 4 5 6
2 5 6 7
*/

import java.io.*;
import java.util.*;

public class SortArray{

	static boolean[][] inSet;
	static int rows;
	static int columns;

	public static void main(String[] args){
		// Read the 2D array values from a file
		try{
		Scanner scanner = new Scanner(new FileReader(new File("input.txt")));
		rows = scanner.nextInt();
		columns = scanner.nextInt();
		int[][] array = new int[rows][columns];
		inSet = new boolean[rows][columns];
		int i=0;
		int j=0;
		while(scanner.hasNext()){
			array[i][j]=scanner.nextInt();
			inSet[i][j] = false;
			j++;
			if(j==columns){
				i++;
				j=0;
			}
		}
		
		// checking if read the array properly
		print(array);
		
		// call the sorting function
		sort(array);

		} catch(IOException e){
			e.printStackTrace();
		}
	}


	public static void sort(int[][] array){
		MinHeap heap = new MinHeap();
		String output="";
		if(rows<=0 || columns<=0)
			return;
		heap.insert(new Tuple(0,0,array[0][0]));
		inSet[0][0]=true;
		
		while(!heap.isEmpty()){
		  Tuple smallest = heap.extractMin();
		  int row = smallest.getRow();
		  int col = smallest.getCol();
		  inSet[row][col]=false;
		  if(row+1<rows && !inSet[row+1][col]){
		  	heap.insert(new Tuple(row+1,col,array[row+1][col]));
		  	inSet[row+1][col] = true;
		  }
		  if(col+1<columns && !inSet[row][col+1]){
		  	heap.insert(new Tuple(row,col+1,array[row][col+1]));
		  	inSet[row][col+1] = true;
		  }
		  output += smallest.getValue() + " ";	
		}
		System.out.println(output);	
	}


	public static void print(int[][] array){
		String output="";
		for(int[] row:array){
			for(int val:row){
				output+= " " + val;
			}
			output+= "\n";
		}
		System.out.println(output);
	}
}
