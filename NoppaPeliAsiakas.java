package noppaPeli;

import java.rmi.Naming;
import java.rmi.RemoteException;
//import java.rmi.RMISecurityManager;
import java.util.Scanner;

/**
 * Noppa pelin asiakas.
 * @author Tommi
 *
 */
public class NoppaPeliAsiakas {
	private static Scanner scan = new Scanner(System.in);
	private static String osoite;
	static int valinta;
	/**
	 * Main metodi.
	 * @param args argumentit
	 */
	public static void main(String[] args) throws RemoteException {
		osoite = annaOsoite();
		//System.setSecurityManager(new RMISecurityManager());
		String kohde = "rmi://" +osoite +"/NoppaPeli";
			try {
				NoppaPeli  j = (NoppaPeli)Naming.lookup(kohde);
				System.out.println(j.yhteysTesti() +" " +osoite);
				System.out.println("Valitse pelaaja numerosi: (1 tai 2) ");
				valinta=scan.nextInt();
				//System.out.println(j.);
				//Scanner scanner = new Scanner(System.in);
				int valinta;
				
				while(true) {
					System.out.println("\nNoppapelin toiminnallisuudet:\n");
					System.out.println("1.) Heit‰ nopat");
			        System.out.println("2.) N‰yt‰ tilanne");
			        System.out.println("3.) Lopeta");
				
			        valinta = scan.nextInt();
				
				switch(valinta) {		
				case 1:
					System.out.println("\n\nHeitet‰‰n kaikki nopat...");
					if(valinta == 1) {
						j.P1heitaKaikkiNopat();
						j.P1laskePisteet();
					}
					else {
						j.P2heitaKaikkiNopat();
						j.P2laskePisteet();
					}
					break;
				case 2:
					System.out.println("\n\n\nPisteet:\n");
					j.getTilanne();
					break;
				case 3:
					System.out.println("Poistutaan noppapelist‰...");
					System.exit(0);
					break;
					
				default:
					System.out.println("V‰‰r‰ valinta");
				
				}
				}
				
			}
			catch(Exception x) {
				System.out.println(x);
			}
			
	}
	/**
	 * Pyyt‰‰ k‰ytt‰j‰lt‰ kohde osoitetta.
	 * @return kohde osoite
	 */
	private static String annaOsoite() {
		System.out.println("Anna kohde osoite: ");
		String x = scan.nextLine();
		return x;
	}
	/**
	 * Pyyt‰‰ pelaajan nime‰.
	 * @return pelaajan antama nimi
	 */
	private String annaNimi() {
		System.out.println("Anna nimesi: ");
		String nimi = scan.nextLine();
		return nimi;
	}
	/**
	 * Luo uuden pelin.
	 */
	private static void luoPeli() {
		
	}
	/**
	 * Liitt‰‰ pelaajan peliin numero i.
	 * @param i pelin numero.
	 */
	private static void liityPeliin(int i) {
		
	}
	/**
	 * Listaa avoimet pelit ja pelaajien m‰‰r‰n.
	 */
	private void avoimetPelit() {
		
	}
	
}