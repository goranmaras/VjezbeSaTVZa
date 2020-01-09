package hr.java.vjezbe.entitet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student {
	private String ime;
	private String prezime;
	private String jmbag;
	private LocalDate datumRodjenja;
	
	public Student(String ime, String prezime, String jmbag, LocalDate datumRodjenja) {
		
		this.ime = ime;
		this.prezime = prezime;
		this.jmbag = jmbag;
		this.datumRodjenja = datumRodjenja;
	}
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbag() {
		return jmbag;
	}
	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
}
