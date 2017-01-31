package jatsipeli;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.ArrayList;

public class NoppaPeliPalvelin extends UnicastRemoteObject implements NoppaPeliPalvelinIF {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		System.setProperty("java.rmi.server.hostname","0.0.0.0");
		try {

			
			NoppaPeliPalvelin npeli = new NoppaPeliPalvelin();
			Naming.rebind("NoppaPeli", npeli);
			System.out.println("npeli bindattu");
		}
		catch(Exception x) {
			System.out.println(x);
		}
	}
	
	private static ArrayList<NoppaPeliAsiakasIF> noppaPeliAsiakkaat; 
	protected NoppaPeliPalvelin() throws RemoteException {
		noppaPeliAsiakkaat = new ArrayList<NoppaPeliAsiakasIF>();
	}
	
	public synchronized void rekisteroiNoppaPeliAsiakas(NoppaPeliAsiakasIF noppaPeliAsiakas) throws RemoteException {
		this.noppaPeliAsiakkaat.add(noppaPeliAsiakas);
		System.out.println("Rekisteröity pelaaja: " + noppaPeliAsiakas.annaNimi());
	}
		
	public String naytaPelaajat() throws RemoteException {
		String pelaajat = "";
		for(int i=0; i<noppaPeliAsiakkaat.size(); i++) {
			pelaajat = pelaajat + noppaPeliAsiakkaat.get(i).annaNimi() + "\n";
		}
		return pelaajat;
	}
	
	public String naytaPisteet() throws RemoteException {
		String pistetaulu = "";
		for(int i=0; i<noppaPeliAsiakkaat.size(); i++) {
			pistetaulu = pistetaulu + noppaPeliAsiakkaat.get(i).annaNimi() + ": " + noppaPeliAsiakkaat.get(i).getPisteet() + "\n";
		}
		return pistetaulu;
	}

	@Override
	public void lahetaViesti(String string) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
