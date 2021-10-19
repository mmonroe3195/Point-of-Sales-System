
import java.io.BufferedReader;
import java.io.FileReader;

public class GetDifferentFoods 
{
	public static String callAps() 
	{
		String [] item = new String [4];
		String x;
		StringBuilder build = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/menu.csv"));
			for(int l = 0; l < 5; l++)
			{
				x = br.readLine();
				for(int i = 0; i < 3; i++)
				{
					item = x.split(",");
					if(item.length > 1)
						build.append(item[i] + "\n");
					
					else
					{
						build.append(item[0]);
						break;
					}
				}
				build.append("\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return build.toString();
	}
	
	public static String callEntre() 
	{
		String [] item = new String [4];
		String x;
		StringBuilder build = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/menu.csv"));
			for(int l = 0; l < 10; l++)
			{
				x = br.readLine();
				if(l < 5)
					continue;
				
				
				for(int i = 0; i < 3; i++)
				{
					item = x.split(",");
					if(item.length > 1)
						build.append(item[i] + "\n");
				
					else
					{
						build.append(item[0]);
						break;
					}
				}
				build.append("\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return build.toString();
	}
	public static String callDessert() 
	{
		String [] item = new String [4];
		String x;
		StringBuilder build = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/menu.csv"));
			for(int l = 0; l < 15; l++)
			{
				x = br.readLine();
				if(l < 10)
					continue;
				
				for(int i = 0; i < 3; i++)
				{
					item = x.split(",");
					if(item.length>1)
						build.append(item[i]+"\n");
					
					else
					{
						build.append(item[0]);
						break;
					}
				}
				build.append("\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return build.toString();
	}
	
	
}


