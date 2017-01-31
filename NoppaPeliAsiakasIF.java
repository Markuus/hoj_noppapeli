package jatsipeli;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NoppaPeliAsiakasIF extends Remote {
	
	public void vastaanotaViesti(String viesti) throws RemoteException;
	
	public static void heitaKaikkiNopat() throws RemoteException {
	}
	
	public void heitaXNopat() throws RemoteException;
	
	public String yhteysTesti() throws RemoteException;

	public String annaNimi() throws RemoteException;

	public int getPisteet() throws RemoteException;
	
	
}