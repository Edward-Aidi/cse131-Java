package roundtables;

public class Add {
	
	public static int add(int x, int y) {
		if (y == 0)
			return x;
		else 
			return add(x+1,y-1);
	}

	public static void main(String[] args) {
		System.out.println(add(10,3));
	}

}
