package hr.java.vjezbe.glavna;
import hr.java.vjezbe.entitet.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.text.DateFormatter;

public class Glavna {

	public static void main(String[] args) {
		
		Scanner skener = new Scanner(System.in);
		
		String sifra,ime,prezime,titula;
		Profesor[] profesorpolje = new Profesor[2];
		
		String blabla;
		String aaaa;
		
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Unesite "+(i+1)+". profesora--");
			System.out.println("Unesite šifru profesra: ");
			sifra = skener.next();
			System.out.println("Unesite ime profesora: ");
			ime = skener.next();
			System.out.println("Unesite prezime profesora: ");
			prezime = skener.next();
			System.out.println("Unesite titulu profesora: ");
			titula = skener.next();
			profesorpolje[i] = new Profesor(sifra,ime,prezime,titula);
			
		}
		
		
		String sifraPredmeta,nazivPredmeta,brojStudenata;
		Integer brojEctsBodova;
		Integer odabirProfesora;
		Predmet[] predmetpolje = new Predmet[3];
		
		for (int j = 0; j < 3; j++) {
			System.out.println("Unesite " + (j+1) + ". predmet--");
			System.out.println("Unesite šifru predmeta: ");
			sifraPredmeta = skener.next();
			System.out.println("Unesite naziv predmeta: ");
			nazivPredmeta = skener.next();
			System.out.println("Unesite broj ECTS bodova za predmet '" + nazivPredmeta + "': ");
			brojEctsBodova = skener.nextInt();
			System.out.println("Odaberite profesora: \n");
			
			for (int i = 0; i < profesorpolje.length; i++) 
			{System.out.println((i+1) + ". " + profesorpolje[i].getIme() + " " + profesorpolje[i].getPrezime());}
			
			System.out.println("Odabir >>");
			odabirProfesora = skener.nextInt();
			System.out.println("Unesite broj studenata za predmet '"+nazivPredmeta+"' :");
			brojStudenata = skener.next();
			predmetpolje[j] = new Predmet(sifraPredmeta, nazivPredmeta, brojEctsBodova, profesorpolje[odabirProfesora-1]);
 		}
//		IspisivanjePredmeta(predmetpolje);
		
		
		String imeStudenta,prezimeStudenta,JmbagStudenta;
		String datumRodjenja = null ;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate datumRodjenjaStudenta;
		
		Student[] studentpolje = new Student[2];
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Unesite "+(i+1)+". studenta");
			System.out.println("Unesite ime studenta: ");
			imeStudenta = skener.next();
			System.out.println("Unesite prezime studenta: ");
			prezimeStudenta = skener.next();
			System.out.println("Unesite datum rodjenja studenta "+imeStudenta+" "+
					prezimeStudenta+" u formatu (dd.MM.yyyy.): ");
			datumRodjenja = skener.next();
			datumRodjenjaStudenta = LocalDate.parse(datumRodjenja,formatter);
			
			System.out.println("Unesite JMBAG studenta: "+imeStudenta+" "+prezimeStudenta
					+":");
			JmbagStudenta = skener.next();
			studentpolje[i] = new Student(imeStudenta, prezimeStudenta, JmbagStudenta, datumRodjenjaStudenta);
			
		}
		
		Integer unosPredmeta,unosStudenta;
		Integer unosOcjene;
		LocalDateTime datumVrijemeIspita;
		String unosDatumVrijemeIspita = null;
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy.'T'HH:mm");
		
		
		Ispit[] ispitpolje= new Ispit[1];
		
		
		for (int i = 0; i < 1; i++) {
			System.out.println("Unesite "+(i+1)+". ispitni rok: ");
			System.out.println("Odaberite predmet: ");
			for (int k = 0; k < predmetpolje.length; k++) {
				System.out.println((k+1)+". "+predmetpolje[k].getNaziv());
			}
			System.out.println("Odabir >>");
			unosPredmeta = skener.nextInt();
			
			
			System.out.println("Odaberite studenta: ");
			for (int k = 0; k < studentpolje.length; k++) {
				System.out.println((k+1)+". "+studentpolje[k].getIme()+" "+studentpolje[k].getPrezime());
			}
			System.out.println("Odabir >>");
			unosStudenta = skener.nextInt();
			
			
			System.out.println("Unesite ocjenu ispitu (1-5): ");
			unosOcjene = skener.nextInt();
			
			System.out.println("Unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.'T'HH:mm): ");
			unosDatumVrijemeIspita = skener.next();
			datumVrijemeIspita = LocalDateTime.parse(unosDatumVrijemeIspita, formatter1);
			ispitpolje[i]=new Ispit(unosOcjene, datumVrijemeIspita, studentpolje[unosStudenta-1], predmetpolje[unosPredmeta-1]);
		}
		
		for (int i = 0; i < ispitpolje.length; i++) {
			System.out.println("Student "+ispitpolje[i].getStudent().getIme()+" "+ispitpolje[i].getStudent().getPrezime()+
					" je ostvario ocjenu "+OcjeneIspita(ispitpolje[i].getOcjena())+" na predmetu "+ispitpolje[i].getPredmet().getNaziv());
		}
		
		
		
		
		
		
		 
		
	}
	
//	public static void IspisivanjePredmeta(Predmet[] predmeti) {
//	for (int i = 0; i < predmeti.length; i++) {
//		System.out.println(predmeti[i].getNaziv()+predmeti[i].getSifra()+predmeti[i].getBrojEctsBodova()
//				+predmeti[i].getNositelj().getIme()+predmeti[i].getNositelj().getPrezime());
//	}	
//	}
	public static String OcjeneIspita(Integer i) {
		if(i==1)
		return "Nedovoljan";
		else if(i==2)
			return "Dovoljan";
		else if(i==3)
			return "Dobar";
		else if(i==4)
			return "Vrlo Dobar";
		else
			return "Odlican";
	}
	
}
