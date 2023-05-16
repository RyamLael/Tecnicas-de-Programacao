package Lista4Qst3;

public class Fatura {
	Item item = new Item();
	
	private int quantitem;
	private float valortotal;
	
	public Fatura(int itemid,String description, float price, int quantitem) {
		
		item.setId(itemid);
		item.setDescription(description);
		
		if(price>0)
			item.setPrice(price);
		else 
			item.setPrice(0);
		
		if(quantitem>0) 
			this.quantitem=quantitem;
		else
			this.quantitem=0;
	}
	
	public int getQuantItem() {
		return quantitem;
	}
	
	public void setQuantItem(int quantitem) {
		this.quantitem=quantitem;
	}
	
}
