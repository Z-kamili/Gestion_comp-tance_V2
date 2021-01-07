package application;

public class Gestion_user_competance {
	
	private String title;
	private String N1;
	private String N2;
	private String N3;
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String isN1() {
		return N1;
	}
	public void setN1(String n1) {
		N1 = n1;
	}
	public String isN2() {
		return N2;
	}
	public void setN2(String n2) {
		N2 = n2;
	}
	public String isN3() {
		return N3;
	}
	public void setN3(String n3) {
		N3 = n3;
	}
	public Gestion_user_competance(String n1, String n2, String n3){
		super();
		N1 = n1;
		N2 = n2;
		N3 = n3;
	}
	
	
	

}
