import java.util.*;

public class Tuple{
private int row;
private int col;
private int value;

public Tuple(int row, int col, int value){
this.row = row;
this.col = col;
this.value = value;
}

public int getRow(){
	return row;
}

public int getCol(){
	return col;
}

public int getValue(){
	return value;
}

@Override
public String toString(){
	return "[" + row + ","+ col +","+ value+ "]";
}
}
