import java.lang.String;
import java.lang.StringBuilder;
import java.io.Console;

public class Decimal{
protected String number;

public Decimal(String s){
	int i;
	// To remove the leading zeroes if entered
	for(i=0;i<s.length()-1;i++){
		if(s.charAt(i)!='0')
		   break;
	}
	this.number = s.substring(i,s.length());
}
public void add(Decimal anum){
	this.number = Decimal.add(this,anum);
}
public void multiply(Decimal anum){
	this.number = Decimal.multiply(this, anum).getNum();
}

public static Decimal multiply(Decimal num, Decimal num2){
	Decimal greater;
        Decimal smaller;
        if(num.size()>=num2.size()){
                greater = num;
                smaller = num2;
        } else{
                greater = num2;
                smaller = num;
        }
	StringBuilder ans = new StringBuilder();
	String s1 = greater.getNum();
        String s2 = smaller.getNum();
	Decimal b = new Decimal("0");

	for(int i=smaller.size()-1;i>=0;i--){
		if(s2.charAt(i)!='0'){
			String s = Decimal.multiply(s1,s2.charAt(i)-'0');			
			Decimal temp = new Decimal(Decimal.padZeroes(s,(smaller.size()-i-1)));
			b.add(temp);
		}
	}
	return b;
}

public static String multiply(String s, int single_digit){
	int carry=0;
	StringBuilder ans = new StringBuilder();
	for(int i=s.length()-1;i>=0;i--){
		int n = s.charAt(i) - '0';
		int result = n * single_digit + carry;
		carry = result/10; 
		ans.append(result%10);
	}
	if(carry!=0){
		ans.append(carry);
	}
	return ans.reverse().toString();
}

public static String padZeroes(String s, int nzeroes){
	StringBuilder ans = new StringBuilder(s);
	for(int i=0;i<nzeroes;i++)
		ans.append('0');
	return ans.toString();
}

public static String add(Decimal num, Decimal num2){
	Decimal greater;
	Decimal smaller;

	// Finding the smaller or larger just on basis of size, not actual value
	if(num.size()>=num2.size()){
		greater = num;
		smaller = num2;
	} else{
		greater = num2;
		smaller = num;
	}

	int carry = 0;
	int i= greater.size()-1;
	String s1 = greater.getNum();
	String s2 = smaller.getNum();
	StringBuilder ans = new StringBuilder();
	for(int j=smaller.size()-1;j>=0;j--,i--){
		int digit1 = s1.charAt(i) - '0';
		int digit2 = s2.charAt(j) - '0';
		int result = digit1 + digit2 + carry;
		carry = result/10; 
		ans.append(result%10);
	}

	// Adding the carry over left after adding smaller number
	while(i>=0){
		int n = s1.charAt(i) - '0';
		int result = n + carry;
		ans.append(result%10);
		carry = result/10;
		i--;
	}
	if(carry>0){
		ans.append(carry);
	}
	if(ans.length()==0)
	   ans.append('0');
	ans.reverse();
	return ans.toString();
}

public int size(){
	return number.length();
}

public String getNum(){
	return number;
}
public static void main(String[] args){
	Console c = System.console();
	String num1 = c.readLine("Enter first decimal:");
	String num2 = c.readLine("Enter second decimal:");
	Decimal b1 = new Decimal(num1);
	Decimal b2 = new Decimal(num2);
	System.out.println("Num1: " + b1.getNum());
	System.out.println("Num2: " + b2.getNum());
	
	Decimal b3 = Decimal.multiply(b1,b2);
	System.out.println("Result: " + b3.getNum());
	System.out.println("Size:" +b3.getNum().length());

}
}
