
public class Quotes {
	private static String name;
	private int SP_ID;
	private static int request_ID;
	private double price;
	private String description;
	private int quote_ID;
	private String status;
	
	public Quotes(String name, int SP_ID, int quote_ID, int request_ID, double price, String description, String Status) {
		this.name = name;
		this.price = price;
		this.SP_ID = SP_ID;
		this.quote_ID = quote_ID;
		this.description = description;
		this.status = status;
	}

	public int request_ID() {
		return request_ID;
	}
	
	public double getPrice() {
		return price;
	}

	public static String getname() {
		return name;
	}


	public Object getDescription() {
		return description;
	}
	
	public int SP_ID() {
		return SP_ID;
	}
	
	public int quote_ID() {
		return quote_ID;
	}


	public int getQuote_ID() {
		return quote_ID;
	}

	public static int getRequest_ID() {
		return request_ID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(boolean b) {
		this.status = "Quotes created";
	}

	

}
