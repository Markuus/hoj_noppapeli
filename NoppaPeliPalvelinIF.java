package jatsipeli;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NoppaPeliPalvelinIF extends Remote {
	void rekisteroiNoppaPeliAsiakas(NoppaPeliAsiakasIF noppaPeliAsiakas) throws RemoteException;

	void lahetaViesti(String string) throws RemoteException;

	String naytaPelaajat() throws RemoteException;

	String naytaPisteet() throws RemoteException;
}
