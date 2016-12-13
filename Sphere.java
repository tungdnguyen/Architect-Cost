import java.util.*;
public class Sphere extends Figure implements INT3
{
	double radius;
	String ask;

	public Sphere()
	{
		super();
		radius = 5.00;
		ask="area";
	}

	public Sphere(String m, String la, double ra)
	{
		super(m);
		radius = ra;
		ask = la;

	}
 
	public double calculateArea() throws TooLargeArea 
	{
		double area = 4*Math.pow(radius,2)*Math.PI;
		if(area>1000)
			throw new TooLargeArea();
		else
			return area;
	}

	public double calculateVolume() throws TooLargeVolume
	{
		double volume = Math.pow(radius,3)*Math.PI*(4/3);
		if (volume>10000)
			throw new TooLargeVolume();
		else
			return volume;
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

						price = are*20.00;
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
						price = are*40.00;
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
						price = are*40.00;
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
						price = are*60.00;
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
						price = volu*40.00;
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
						price = volu*80.00;
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
						price = volu*100.00;
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
						price = volu*120.00;
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
		out = super.toString()+" "+"The radius is" + radius +" "+"And the parameter asked for is"+" "+ask;
		return out;
	}
}
