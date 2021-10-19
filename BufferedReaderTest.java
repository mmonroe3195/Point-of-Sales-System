
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class BufferedReaderTest {
private static int i = 0;
	public static void main(String[] args) 
	{

		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/menu.csv"));


			String line = br.readLine();
			String [] prices = new String [12];
			String [] names= new String [12];
			String [] description= new String [12];
			
			while(line != null)
			{

				String [] lineArray = line.split(",");
				
				line = br.readLine();
				if(lineArray.length > 1)
				{
					names [i] = lineArray[0];
					prices [i] = lineArray[1];
					description [i] = lineArray [2];
					i++;
					
				}
				else
					continue;
				
				
			}
			System.out.println("names array: \n");
			
			for(int x = 0; x < names.length; x++)
				System.out.println(names[x]);
			
			System.out.println("\nprice array: \n");
			for(int x = 0; x < prices.length; x++)
				System.out.println(prices[x]);
	
			System.out.println("\ndescrip array: \n");
			for(int x = 0; x < description.length; x++)
				System.out.println(description[x]);
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}





