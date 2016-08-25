package Testes;

public abstract class Personx {
	
	public  Personx(int id) {
	}

	public abstract int getid(); 

	public abstract String getContactDetails() ;
	 
	public abstract void setContactDetails(String contactDetails); 
	 
	public abstract String getName(); 
	 
	public abstract void setName(String name) ;
	 
	public abstract Personx getPerson(int id) throws Exception ;

	public abstract void createPerson(int id) throws Exception; 

	public abstract Personx deletePerson(int id) throws Exception; 

	public abstract void updatePerson(Personx p) throws Exception; 
}
