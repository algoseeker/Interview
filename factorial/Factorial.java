import java.io.Console;

public class Factorial{
	public static void main(String[] args){
		Console console = System.console();
		String input = console.readLine("Enter number whose factorial is to be computed: ");
		try{
			Integer num = Integer.parseInt(input);
			Decimal result = new Decimal(num.toString());;
		   	for(Integer i = num-1;i>=1;i--){
				Decimal temp = new Decimal(i.toString()); 
				result.multiply(temp);
			}
			System.out.println("Factorial is " + result.getNum());
			System.out.println("Size is " + result.getNum().length());
			
		   } catch(NumberFormatException e){
				e.getMessage();
		   }
	}
}
