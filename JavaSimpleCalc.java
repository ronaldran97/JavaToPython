public class JavaSimpleCalc {

	public static void main(String[] args) {
	
		switch(args[0]) {		

		case "+" : add((Integer.parseInt(args[1])),(Integer.parseInt(args[2])));
			break;
	
		case "-" : subtract((Integer.parseInt(args[1])),(Integer.parseInt(args[2])));
			break;

		case "x" : multiply((Integer.parseInt(args[1])),(Integer.parseInt(args[2])));
			break;

		case "/" :divide((Double.parseDouble(args[1])),(Double.parseDouble(args[2])));
			break;
		
		}
	}

	private static int add(int x, int y) {
		int sum = x + y;
		System.out.println(sum + " is the sum");
			return sum;
	}

	private static int subtract(int x, int y) {
		int difference = x - y;
		System.out.println(difference + " is the difference");
			return difference;
	}

	private static int multiply(int x, int y) {
		int product = x * y;
		System.out.println(product + " is the product");
			return product;
	}

	private static double divide(double x, double y) {
		double quotent = x / y;
		if (y == 0) {
			System.out.println("Undefined");
			return quotient;
		} else {
			System.out.println(quotient + " is the quotient");
			return quotient;
		}
	}
}
