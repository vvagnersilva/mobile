package Testes;

 class CustomerApplication { 
	public static void main (String [] args) { 

		CustomerDAO custDao = new CustomerDAOMemoryImp1 (); 

		// . . . other methods 
		//CustomerDAO custDao = CustomerDAO.getInstance(); 
		//CustomerDAO custDao = CustomerDAOFactory.getInstance(); 
		
	} 
}

