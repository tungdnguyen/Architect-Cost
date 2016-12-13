import java.util.*;
import java.io.*;
public class FigureCost
{
	public static void main (String[]args)
	{
			ArrayList<Figure> arr = new ArrayList<Figure>();
			ArrayList<String> cost = new ArrayList<String>();
			//declare for stream
			OutputStreamWriter filestream;
			String filename;
			FileOutputStream file;
			ArrayList<String> stringarray = new ArrayList<String>();
			//user input
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter the shape the length(or radius) and the asked value separated by space or type done");
			String line = scan.nextLine();

			while(line!="done")
			{
				StringTokenizer stok = new StringTokenizer(line," ");
				String shape = stok.nextToken();
				String len = stok.nextToken();
				Double leng = Double.parseDouble(len);
				//asked value
				String as = stok.nextToken();
				//check what kind of shape to assign object and add to array
				if(shape.equals("Cube"))
				{
					Cube cub1 = new Cube("Cube",as,leng);
					arr.add(cub1);
				}
				else if(shape.equals("Sphere"))
				{
					Sphere sph1 = new Sphere("Sphere",as,leng);
					arr.add(sph1);
				}
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Please enter the shape the length(or radius) and the asked value separated by space or type done");
					line = scan2.nextLine();
					if(line.equals("done"))
					{
						break;
					}
			}
					Customers cus = new Customers();
					Vector v = new Vector();
					v= cus.customerData();
					for(Figure a: arr)
					{
						try
						{
							cost=a.costToDraw(v);

						}
						catch(TooLargeCost p)
						{
							System.out.println(p.getMessage());
						}
						catch(IOException ioe)
						{
							System.out.println("Something wrong with the file");
						}
						finally
						{
							System.out.println(a.toString());
							stringarray.add(a.toString());

							for(String g: cost)
							{
								System.out.println(g);
								stringarray.add(g);
							}
						}

					}						

			try
			{

					filename="output.txt";
					file = new FileOutputStream(filename,false);
					filestream= new OutputStreamWriter(new BufferedOutputStream(file));
					for(String w: stringarray)
					{
						filestream.write(w);
						filestream.write("\n");
					}





					Scanner ste = new Scanner(System.in);
					System.out.println("Type readfile if you want to have the text file read and displayed or type no if you want the program terminated:");
					String stream = ste.nextLine();

					if(stream.equals("no"))
					{
						System.out.println("System existing");
						System.exit(0);
					}

					if(stream.equals("readfile"))
					{
						FileInputStream file2=new FileInputStream(filename);
						BufferedReader filereader2=new BufferedReader(new InputStreamReader(file2)); 

						String reading=" ";
				
				
						while((reading=filereader2.readLine())!=null) 
						{
					
				 			System.out.println(reading);
	
						}
					}

				file.close();
				filestream.flush();
			}

			catch(IOException ioe)
			{
				System.out.println("Something wrong");
			}


	}
}
