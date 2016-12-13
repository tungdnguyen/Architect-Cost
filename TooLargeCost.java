public class TooLargeCost extends Exception
{
	String msg = "The cost calculated exceeds the limits";

	public TooLargeCost()
	{
		System.out.println(msg);
	}

	public TooLargeCost(String t)
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
		out = super.toString()+"TooLargeCostException occurred";
		return out;
	}
}