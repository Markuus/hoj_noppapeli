package jatsipeli;

import java.rmi.*;
import java.rmi.server.*;
/**
 * Ehkä turha luokka.
 * @author Tommi
 *
 */
public class Noppa extends UnicastRemoteObject implements NoppaPeliAsiakasIF {

	protected Noppa() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void heitaKaikkiNopat() throws RemoteException {
		// TODO Auto-generated method stub
		
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
	public void vastaanotaViesti(String viesti) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String annaNimi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPisteet() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
