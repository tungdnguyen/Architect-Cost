import java.util.*;
public class  Customers
{
	
	public String type=" ";
	public int score=0;

	public void setType(String ty)
	{
		type=ty;
	}

	public void setScore(int sc)
    {
		score=sc;
	}

	public String getType()
	{
		return type;
	}

	public int getScore()
	{
		return score;
	}
	
	public Vector customerData()
	{
		Vector v=new Vector();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the type and the score");
		String line = scan.nextLine();
		while(line!="done")
	{
		StringTokenizer tok = new StringTokenizer(line," ");
		String ty = tok.nextToken();
		int sco = Integer.parseInt(tok.nextToken());
		Customers c1=new Customers();
		c1.setType(ty);
		c1.setScore(sco);
		v.add(c1);

		Scanner scan2 = new Scanner(System.in);
		System.out.println("Please enter the type and the score");
		line = scan2.nextLine();
		if(line.equals("done"))
		{
			break;
		}

	}

	for(int i=0; i<v.size();i++)
	{
		Object o = v.elementAt(i);
		Customers ob = (Customers) o;
		System.out.println("The customer is:"+"type="+ob.getType()+"score="+ob.getScore());
	}

	return v;


	}
}
