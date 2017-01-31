package jatsipeli;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Jatsi pelin asiakas.
 * @author Tommi
 *
 */
public class NoppaPeliAsiakas extends UnicastRemoteObject implements NoppaPeliAsiakasIF, Runnable  {
	
	private NoppaPeliPalvelinIF noppaPeliPalvelin;
	private static String nimi = null;
	private static int pisteet = 0;
	private static int heittojenMaara = 0;
	protected NoppaPeliAsiakas(String nimi, NoppaPeliPalvelinIF noppaPeliPalvelin) throws RemoteException {
		this.nimi = nimi;
		this.noppaPeliPalvelin = noppaPeliPalvelin;
		noppaPeliPalvelin.rekisteroiNoppaPeliAsiakas(this);
		//new NoppaPeliPelaaja();
	}
	
	
	
	
	private static Scanner scan = new Scanner(System.in);
	private static String osoite;
	public static void main(String[] args) {
		osoite = annaOsoite();
		//System.setSecurityManager(new RMISecurityManager());
		String kohde = "rmi://" +osoite +"/NoppaPeli";
			try {
				NoppaPeliPalvelinIF  j = (NoppaPeliPalvelinIF)Naming.lookup(kohde);
				System.out.println("Yhteys muodostettu kohteeseen " + osoite);
				new Thread(new NoppaPeliAsiakas(syotaNimi(), j)).start();
				System.out.println("Tervetuloa pelaamaan " + nimi + "!");
				
			}
			catch(Exception x) {
				System.out.println(x);
			}
	}
	private static String annaOsoite() {
		System.out.println("Anna kohde osoite: ");
		String x = scan.nextLine();
		return x;
	}
	private static String syotaNimi() {
		System.out.println("Anna nimesi: ");
		String nimi = scan.nextLine();
		return nimi;
	}
	public String annaNimi() throws RemoteException {
		return nimi;
	}
	
	public int annaPisteet() throws RemoteException {
		return NoppaPeliPelaaja.getPisteet();
	}
	

	@Override
	public void heitaKaikkiNopat() throws RemoteException {
		 //TODO Auto-generated method stub
		
	}
	@Override
	public void heitaXNopat() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String yhteysTesti() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void run() {

		Scanner scanner = new Scanner(System.in);
		int valinta;
		
		while(true) {
			System.out.println("\nNoppapelin toiminnallisuudet:\n");
			System.out.println("1.) Heit‰ nopat");
	        System.out.println("2.) N‰yt‰ tilanne");
	        System.out.println("3.) N‰yt‰ pelaajat");
	        System.out.println("4.) Lopeta");
		
	        valinta = scanner.nextInt();
		
		switch(valinta) {
		
		case 1:
			System.out.println("\n\nHeitet‰‰n kaikki nopat...");
			try {
				NoppaPeliPelaaja.heitaKaikkiNopat();
				NoppaPeliPelaaja.laskePisteet();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("\n\n\nPisteet:\n");
			try {
				System.out.println(noppaPeliPalvelin.naytaPisteet());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			break;
		case 3:
			System.out.println("\n\n\nPelaajat:\n");
			try {
				System.out.println(noppaPeliPalvelin.naytaPelaajat());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("Poistutaan noppapelist‰...");
			System.exit(0);
			break;
			
		default:
			System.out.println("V‰‰r‰ valinta");
		
		}
		}
	}
	public int getPisteet() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void vastaanotaViesti(String viesti) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}