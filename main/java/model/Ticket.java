package model;

public class Ticket {

	private int idticket;
	
	private String titre;
	
	private String description;
	
	private String departement;
	
	private String etat;

	
	public Ticket() {
	
	}

	public Ticket(String titre, String description, String departement, String etat) {
		this.titre = titre;
		this.description = description;
		this.departement = departement;
		this.etat = etat;
	}
	
	public Ticket(String titre, String description, String departement) {
		this.titre = titre;
		this.description = description;
		this.departement = departement;
	}

	public int getIdticket() {
		return idticket;
	}

	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
