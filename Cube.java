import java.util.*;

public class Cube extends Figure implements INT3
{
	double length;
	String ask;

	public Cube()
	{
		super();
		ask="area";
		length=10.0;
	}
	public Cube(String n,String l, double le)
	{
		super(n);
		ask=l;
		length=le;
	}
	public double calculateArea() throws TooLargeArea
	{
		double area = 6*Math.pow(length,2);
		if(area>1000) 
		{
			throw new TooLargeArea();
		}
		else 
		{
			return area;
		}
	}

	public double calculateVolume() throws TooLargeVolume
	{
		double volume = Math.pow(length,3);
		if (volume>10000)
		{
			throw new TooLargeVolume();
		}
		else 
		{
			return volume;
		}
	}

	public Vector secretData()
	{
		Impl a = new Impl();
		Vector b = new Vector();
		b =a.secretData();
		return b;
	}
	
	public ArrayList<String> costToDraw(Vector c) throws TooLargeCost
	{
		
	
		ArrayList<String> fin = new ArrayList<String>();
		double are; 
		double volu;
		double price =0.0;		
		String str;
		for(int k=0;k<c.size();k++)
		{

			System.out.println();
		}



	try{

		if(ask.equals("area"))
		{
			are = calculateArea();
			for(int i=0;i<c.size();i++)
			{
				Object o = c.elementAt(i);
				Customers cus = (Customers) o;

				if(cus.getType().equals("Architect"))
				{
					if(cus.getScore()>=600)
					{

						price = are*10.00;
						if (price>400000)
						{

							throw new TooLargeCost();
						}
						else 
						{
							str = "The area price for architect, score >=600 is"+price;
							fin.add(str);
						}
					}

					if(cus.getScore()<600)
					{
						price = are*20.00;
						if (price>400000)
						{
							throw new TooLargeCost();
						}
						else 
						{

							str = "The area price for architect, score <600 is"+price;
							fin.add(str);
						}

					}
				}

				if(cus.getType().equals("Other"))
				{
					if(cus.getScore()>=600)
					{
						price = are*20.00;
						if (price>400000)
						{

							throw new TooLargeCost();
						}
						else 
						{
							str = "The area price for other, score >=600 is"+price;
							fin.add(str);
						}

					}
					if(cus.getScore()<600)
					{
						price = are*30.00;
						String one3;
						if (price>400000)
						{

							throw new TooLargeCost();
						}
						else 
						{
							str = "The area price for other, score < 600 is"+price;
							fin.add(str);
						}

					}
				}


			}
		}


		if(ask.equals("volume"))
		{
			volu = calculateVolume();
			for(int i=0;i<c.size();i++)
			{
				Object o = c.elementAt(i);
				Customers cus = (Customers) o;

				if(cus.getType().equals("Architect"))
				{
					if(cus.getScore()>=600)
					{
						price = volu*20.00;
						if (price>400000)
						{
							throw new TooLargeCost();
						}
						else 
						{
							str = "The volume price for architect, score >=600 is"+price;
							fin.add(str);
						}

					}

					if(cus.getScore()<600)
					{
						price = volu*40.00;
						if (price>400000)
						{

							throw new TooLargeCost();
						}
						else 
						{

							str = "The volume price for architect, score <600 is"+price;
							fin.add(str);
						}
					}
				}

				if(cus.getType().equals("Other"))
				{
					if(cus.getScore()>=600)
					{
						price = volu*50.00;
						if (price>400000)
						{

							throw new TooLargeCost();
						}
						else 
						{

							str = "The volume price for other, score >=600 is"+price;
							fin.add(str);
						}
					}
					if(cus.getScore()<600)
					{
						price = volu*60.00;
						if (price>400000)
						{

							throw new TooLargeCost();
						}
						else 
						{
							str = "The volume price for other, score <600 is"+price;
							fin.add(str);
						}
					}
				}


			}
		}
	}
	catch(TooLargeArea e)
	{
		System.out.println(e.getMessage());
		str="The area cost is"+price;
		fin.add(str);
	}
	catch(TooLargeVolume l)
	{
		System.out.println(l.getMessage());
		str="The volume cost is"+price;
		fin.add(str);
	}
	catch(TooLargeCost p)
	{
		System.out.println(p.getMessage());
	}

		finally
		{

			return fin;

		}


	}
	
	public String toString()
	{
		String out;
		out = super.toString()+" "+"The length is" + length+" "+"And the parameter ask for is"+" "+ ask;
		return out;
	}

}