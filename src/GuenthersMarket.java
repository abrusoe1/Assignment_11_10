import java.util.*;

public class GuenthersMarket {
	
	public static double avgCost (ArrayList<Double> purchase)
	{
		double sum = 0d;
		for (double d : purchase)
		{
			sum += d;
		}
		double avg = 1.0d * sum  / purchase.size();
		return avg;
	}
	
	public static void highestCostIndex (ArrayList<String>purchase) 
	{
		ArrayList <Double> expensive = new ArrayList <Double> ();
		for (int i = 0; i < purchase.size(); i++)
		{
			String[] prepforexpensive = purchase.get(i).split("\\$"); //This string name will make more sense once you hit line 24
			String prepforexpensive1 = prepforexpensive[1];
			double prepforexpensive2 = Double.valueOf(prepforexpensive1);
			expensive.add(prepforexpensive2);
		}
		
		int expensiveindex = expensive.indexOf(Collections.max(expensive));
		System.out.println("The index of the most expensive item is: " + expensiveindex);
	}
	
	public static void lowestCostIndex (ArrayList<String>purchase)
	{
		ArrayList <Double> cheap = new ArrayList <Double> ();
		for (int i = 0; i < purchase.size(); i++)
		{
			String[] prepforcheap = purchase.get(i).split("\\$");
			String prepforcheap1 = prepforcheap[1];
			double prepforcheap2 = Double.valueOf(prepforcheap1);
			cheap.add(prepforcheap2);
		}
		
		int cheapindex = cheap.indexOf(Collections.min(cheap));
		System.out.println("The index of the cheapest item is: " + cheapindex);
	}

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner (System.in);
		ArrayList <String> cart = new ArrayList <String> ();
		ArrayList <Double> cartprice = new ArrayList <Double> ();
		ArrayList <String> purchase = new ArrayList <String> ();
		
		HashMap <String, Double> produce = new HashMap <String, Double>();
			produce.put("apple", 0.99d);
			produce.put("banana", 0.59d);
			produce.put("cauliflower", 1.59d); //Longest string (tied with dragonfruit) at 11 chars
			produce.put("dragonfruit", 2.19d);
			produce.put("elderberry", 1.79d); //Your mother was a hamster
			produce.put("figs", 2.09d);
			produce.put("grapefruit", 1.99d);
			produce.put("honeydew", 3.49d);
			
		System.out.println("Welcome to Guenther's Market!");
		
		boolean shopping = true;
		while (shopping)
		{	
			System.out.println(); //Start loop here
			System.out.println("Item         Price");
			System.out.println("==================");
			System.out.println("apple        $" + produce.get("apple"));
			System.out.println("banana       $" + produce.get("banana"));
			System.out.println("cauliflower  $" + produce.get("cauliflower"));
			System.out.println("dragonfruit  $" + produce.get("dragonfruit"));
			System.out.println("elderberry   $" + produce.get("elderberry"));
			System.out.println("figs         $" + produce.get("figs"));
			System.out.println("grapefruit   $" + produce.get("grapefruit"));
			System.out.println("honeydew     $" + produce.get("honeydew"));
			System.out.println();
			System.out.print("What item would you like to order? ");
			String orderinput = scnr.next();
	//		System.out.println(order);
			String order = orderinput.toLowerCase();
			if (produce.containsKey(order))
			{
				System.out.println("Adding " + order + " to cart at $" + produce.get(order));
				cart.add(order);
				cartprice.add(produce.get(order));
//				System.out.println(cart);        //Test; Collections.sort(); will take care of the [] later
//				System.out.println(cartprice);   //Test; Collections.sort(); will take care of the [] later
				System.out.println();
			
				boolean keepgoing = true;
				while (keepgoing)
				{
					System.out.print("Would you like to answer anything else (y/n)? ");
					String cont = scnr.next();
				

					if(cont.equalsIgnoreCase("n"))
					{
						keepgoing = false;
						shopping = false;
					}
					else if (cont.equalsIgnoreCase("y"))
					{
						keepgoing = false;
					}
					else
					{
						System.out.print("Try again. ");
					}
				}
			}
			else
			{
				System.out.println("Sorry, we don't have those. Please try again.");
			}

		}
		
		for (int i = 0; i < cart.size(); i++)
		{
			purchase.add(cart.get(i) + " $" + cartprice.get(i));
		}
		
		Collections.sort(purchase);
		System.out.println();
		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got:");
		
			for (String j : purchase)
			{
				System.out.println(j);
			}
		System.out.println("Average price per item in order was $" + avgCost(cartprice));
		highestCostIndex(purchase);
		lowestCostIndex(purchase);
			
		scnr.close();
	}
}
//While loop for asking what to order, broken when customer enters "n"
//Another, nested loop for when something aside from those 8 strings (ignore case) is entered

//static Double avg
//static Double sum