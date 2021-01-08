package application;

public class Apprenant extends User {
	private String Filiaire;
	private String Role;
	public Apprenant() {
		super();
	}
	public Apprenant(int id,String nom, String email, int age,String Filiaire,String password,String Role){
		super(id, nom, email, age,password);
		this.Filiaire = Filiaire;
		this.Role = Role;
	}
	public Apprenant(String nom, String email, int age,String Filiaire,String password,String Role){
		super(nom, email, age,password);
		this.Filiaire = Filiaire;
		this.Role = Role;
	}
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getFiliaire() {
		return Filiaire;
	}
	public void setFiliaire(String filiaire) {
		Filiaire = filiaire;
	}
	
	public void Update() {
		
		//code source.
		
	}
	
	

}
