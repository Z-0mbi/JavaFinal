package model;

public class BasketInit {
	String title;
	int price;
	
	public BasketInit(String title,int price) {
		this.title=title;
		this.price=price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String toString(){
		return "Goods{"+
				"title='"+title+"'"+
				",price="+price+"}";
				
	}
}
