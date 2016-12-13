public class TooLargeArea extends Exception
{

	String msg = "The area calculated exceeds the limits ";
	public TooLargeArea()
	{
		System.out.println(msg);

	}

	public TooLargeArea(String t)
	{
		super(t);
	}
	public String getMessage()
	{
		return msg;
	}

	public String toString()
	{
		String out;
		out= super.toString()+"TooLargeAreaException occured";
		return out;
	}


}