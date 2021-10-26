public class test10
{
	public static void main(String[] args)
	{
	    double sum = 0.0;
	    int i = 0;
	    for(i=1;i<=100;i++)
	    {
	    	if(i%2 == 1)
            {
            	sum += 1.0/i;
            }
            else
            {
            	sum -= 1.0/i;
            }
	    }
	    System.out.println("sum="+sum);
	}
}