package application;

public class compétance {
	private int id;
	private String title;
	private String Filiaire;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getFiliaire() {
		return Filiaire;
	}
	public void setFiliaire(String filiaire) {
		Filiaire = filiaire;
	}
	public compétance(int id, String title, String filiaire) {
		super();
		this.id = id;
		this.title = title;
		Filiaire = filiaire;
	}
}
