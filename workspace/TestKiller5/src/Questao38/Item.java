package Questao38;

public class Item 
{
	private String desc;
	public String getDescription()
	{
		return desc;
	}
	public void setDescription(String d)
	{
		desc = d;
	}
	
	public static void modifyDesc(Item item, String desc)
	{
		item = new Item();
		item.setDescription(desc);		
	}
	
	public static void main(String[] yahoo) 
	{
		Item it = new Item();
		it.setDescription("Gobstopper");
		Item it2 = new Item();
		it2.setDescription("Fizzylifting");
		modifyDesc(it, "Scrumdiddlyumptious");
		
		System.out.println(it.getDescription());
		System.out.println(it2.getDescription());
	}
}
