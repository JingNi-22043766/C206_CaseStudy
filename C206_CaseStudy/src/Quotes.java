
public class Quotes {
	private String name;
	private int SPID;
	private double price;
	private String description;
	private int quote_ID;
	
	public Quotes(String name, int SPID, int quote_ID, double price, String description) {
		this.name = name;
		this.price = price;
		this.SPID = SPID;
		this.quote_ID = quote_ID;
		this.description = description;
	}


	public double getPrice() {
		return price;
	}

	public String getname() {
		return name;
	}


	public Object getDescription() {
		return description;
	}
	
	public int SPID() {
		return SPID;
	}
	
	public int quote_ID() {
		return quote_ID;
	}


	public void setStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
