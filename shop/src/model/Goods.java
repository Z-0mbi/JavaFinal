package model;

public class Goods {
	int id;
	String title;
	int price;
	
	public Goods(int id,String title,int price) {
		this.id=id;
		this.title=title;
		this.price=price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
	}
	public int getPrice() {
		return price;
	}
	
	public String toString(){
		return "Goods{"+
				"id="+id+
				",title='"+title+"'"+
				",price="+price+"}";
				
	}
}
