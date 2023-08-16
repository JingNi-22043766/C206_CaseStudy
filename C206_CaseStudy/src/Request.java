
public class Request {
	
	
    private int CustId;
    private String requestDate;
    private String description;
    private String EstStartDate;
    private int EstBudet;

    
	public Request(int custid, String requestDate, String description, String EstStartDate, int  budget) {
		this.CustId = custid;
		this.requestDate = requestDate;
		this.description = description;
		this.EstStartDate = EstStartDate;
		this.EstBudet = budget;
	}


			public int getCustId() {
				return CustId;
			}

			public String getrequestDate() {
				return requestDate;
			}

			public String getdescription() {
				return description;
			}

			public String getEstStartDate() {
				return EstStartDate;
			}
			
			public int getEstBudet() {
				return EstBudet;
				
			}	
		}


