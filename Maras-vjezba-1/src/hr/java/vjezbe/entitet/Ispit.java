package hr.java.vjezbe.entitet;

import java.time.LocalDateTime;

public class Ispit {
	private Integer ocjena;
	private LocalDateTime datumIVrijeme;
	private Student student ;
	private Predmet predmet;
	
	public Ispit(Integer ocjena, LocalDateTime datumIVrijeme, Student student, Predmet predmet) {
		
		this.ocjena = ocjena;
		this.datumIVrijeme = datumIVrijeme;
		this.student = student;
		this.predmet = predmet;
	}
	
	public Integer getOcjena() {
		return ocjena;
	}

	public void setOcjena(Integer ocjena) {
		this.ocjena = ocjena;
	}

	public LocalDateTime getDatumIVrijeme() {
		return datumIVrijeme;
	}

	public void setDatumIVrijeme(LocalDateTime datumIVrijeme) {
		this.datumIVrijeme = datumIVrijeme;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	
}
