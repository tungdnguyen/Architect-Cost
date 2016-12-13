public class TooLargeVolume extends Exception
{
	String msg = "The volume calculated exceeds the limits";

	public TooLargeVolume()
	{
		System.out.println(msg);

	}

	public TooLargeVolume(String t)
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
		out = super.toString()+"TooLargeVolumeException occurred";
		return out;
	}
}