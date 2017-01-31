package jatsipeli;

import java.util.Random;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.*;

/**
 * Jatsi pelin palvelin.
 * @author Tommi
 *
 */
public class NoppaPeliPelaaja extends UnicastRemoteObject implements NoppaPeliAsiakasIF {
	private static int n1 = 1;
	private static int n2 = 2;
	private static int pisteet;
	private int heitonNro;
	private int pelaajanNro=1;
	static Random satunnainen = new Random();
	
	/**
	 * Olion luominen
	 * @throws RemoteException
	 */
	public NoppaPeliPelaaja() throws RemoteException  {
		this.heitonNro=1;
		this.pelaajanNro=pelaajanNro;
		pelaajanNro++;
		NoppaPeliPelaaja.pisteet=0;
		NoppaPeliPelaaja.n1=0;
		NoppaPeliPelaaja.n2=0;
	}
	
	/**
	 * Yhteyden testaamiseen.
	 */
	public String yhteysTesti() throws RemoteException {
		return "Yhteys palvelimeen.";
	}
	/**
	 * Heitt‰‰ kaikki nopat.
	 */
	public static void heitaKaikkiNopat() throws RemoteException {
		NoppaPeliPelaaja.n1=satunnainen.nextInt(6) + 1;
		NoppaPeliPelaaja.n2=satunnainen.nextInt(6) + 1;
		System.out.println("Heitetyt nopat: " +NoppaPeliPelaaja.n1 +", " +NoppaPeliPelaaja.n2);
	}

	
	/**
	 * Pisteiden lasku metodi.
	 */
	public static int laskePisteet() {
		int tulos = 0;
		tulos = n1 + n2;
		pisteet += tulos;
		System.out.println("Heiton tulos: " + tulos);
		System.out.println("Kokonaispisteet: " + pisteet);
		return pisteet;
	}
	
	private void asetaPelaajaMaara() {
		
	}
	public void lisaaPisteet() {
		NoppaPeliPelaaja.pisteet=NoppaPeliPelaaja.pisteet+laskePisteet();
	}
	public int getPelaajaMaara() {
		return pelaajanNro-1;
	}
	public int getHeitonNro() {
		return this.heitonNro;
	}
	public static int getPisteet() {
		return pisteet;
	}
	public int getNoppa1() {
		return NoppaPeliPelaaja.n1;
	}
	public int getNoppa2() {
		return NoppaPeliPelaaja.n2;
	}
	private void heitaNoppa1() {
		NoppaPeliPelaaja.n1 = satunnainen.nextInt(6) + 1;
	}
	private void heitaNoppa2() {
		NoppaPeliPelaaja.n2 = satunnainen.nextInt(6) + 1;
	}

	@Override
	public void heitaXNopat() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vastaanotaViesti(String viesti) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String annaNimi() {
		// TODO Auto-generated method stub
		return null;
	}
}
