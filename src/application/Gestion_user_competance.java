package application;

public class Gestion_user_competance {
	
	private int id_user;
	private int id_comp;
	private boolean N1;
	private boolean N2;
	private boolean N3;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_comp() {
		return id_comp;
	}
	public void setId_comp(int id_comp) {
		this.id_comp = id_comp;
	}
	public boolean isN1() {
		return N1;
	}
	public void setN1(boolean n1) {
		N1 = n1;
	}
	public boolean isN2() {
		return N2;
	}
	public void setN2(boolean n2) {
		N2 = n2;
	}
	public boolean isN3() {
		return N3;
	}
	public void setN3(boolean n3) {
		N3 = n3;
	}
	public Gestion_user_competance(int id_user, int id_comp, boolean n1, boolean n2, boolean n3,String title){
		super();
		this.id_user = id_user;
		this.id_comp = id_comp;
		N1 = n1;
		N2 = n2;
		N3 = n3;
		this.title = title;
	}
	
	public void  Clear_Data() {
		this.N1 = false;
		this.N2 = false;
		this.N3 = false;
	}
	
	
	

	
	
	
	

}
