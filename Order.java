
import java.io.FileWriter;
import java.io.IOException;

public class Order 
{
	private String name;
	private String food;
	private int orderNum;
	private String subTotal;
	private String tax;
	private String total;

	public Order(int num, String Food, String custName, String SubTotal, String Tax, String Total)
	{
		orderNum = num;
		food = Food;
		name = custName;
		subTotal = SubTotal;
		tax = Tax;
		total = Total;
	}
	public static void addToCSV(Order toAdd, FileWriter write)
	{
		try
		{
			
			write.append(toAdd.toString() + "\n");
			write.flush();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public String toString()
	{
		StringBuilder build = new StringBuilder();
		build.append(orderNum + "," + food + "," + name + "," + subTotal + "," + tax + "," + total);
		return build.toString();
		
	}	
}



