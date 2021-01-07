package application;

public class Apprenant extends User {
	private String Filiaire;
	public Apprenant() {
		super();
	}
	public Apprenant(int id, String nom, String prenom, int age,String Filiaire,String password){
		super(id, nom, prenom, age,password);
		this.Filiaire = Filiaire;
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
