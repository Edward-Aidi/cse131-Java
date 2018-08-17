package recitation;

public class Die {
	
	public static void main(String[] args)
	{
		long x = 0;
		long y = 1;
		System.out.println(x);
		System.out.println(y);
		for(int i = 0; i < 98; i++)
		{
			long z = x + y;
			System.out.println(z);
			x = y;
			y = z;
		}
	}

}
