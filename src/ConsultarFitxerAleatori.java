import java.io.*;
import java.util.*;

public class ConsultarFitxerAleatori {
	
	public ConsultarFitxerAleatori() {
		
	}
	public void ConsultarID() throws IOException {
		File fitxer = new File("D:/m6/fitxer.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");


		//Apuntador s'inicialitza apuntant a l'inici del fitxer
		int apuntador = 0, edat, id, seleccio;
		float preu;
		char nom[] = new char[50], cognom[] = new char[50], pais[] = new char[30], aux;

		//Demana a l'usuari que seleccioni el llibre pel seu identificador
		System.out.print("Introdueixi el ID de la persona: ");
		Scanner stdin = new Scanner (System.in);

		seleccio = stdin.nextInt();
		apuntador = (seleccio-1)*268;

		if (apuntador >= aleatoriFile.length()) {
			System.out.println("ERROR: ID incorrecte, no existeix aquesta persona");
		} else {//Apuntar a l'inici del llibre seleccionat al fitxer
			aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer
			//Llegeix ID
			id = aleatoriFile.readInt();
			//Llegeix Títol
			for(int i = 0; i<nom.length; i++) {
				aux = aleatoriFile.readChar();
				nom[i] = aux;
			}
			String noms = new String(nom);
			//Llegeix Autor
			for(int i = 0; i<cognom.length; i++) {
				aux = aleatoriFile.readChar();
				cognom[i] = aux;
			}
			String cognoms = new String(cognom);
			//Llegeix ISBN
			edat = aleatoriFile.readInt();
			
			//Llegeix Editorial
			for(int i = 0; i<pais.length; i++) {
				aux = aleatoriFile.readChar();
				pais[i] = aux;
			}
			String paisos = new String(pais);
			
			//Sortida de les dades de cada llibre
			System.out.println("ID: "+id+"\nNom: "+noms+"\nCognom: "+cognoms+"\nEdat: "+edat+"\nPais: "+paisos+"\n\n");
		}
		aleatoriFile.close();//Tancar el fitxer
	}
	
//	public void ConsultarCamp () throws IOException {
//		
//		File fitxer = new File("D:/m6/fitxer.txt");
//		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
//		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
//
//
//		//Apuntador s'inicialitza apuntant a l'inici del fitxer
//		int apuntador = 0, edat, id, seleccio;
//		float preu;
//		char nom[] = new char[50], cognom[] = new char[50], pais[] = new char[30], aux;
//
//		//Demana a l'usuari que seleccioni el llibre pel seu identificador
//		System.out.print("Selecciona el camp per el cual vols buscar: ");
//		System.out.println("1 ID - 2 nom - 3 cognoms -  edat - 4 pais");
//		Scanner stdin = new Scanner (System.in);
//
//		seleccio = stdin.nextInt();
//		
//		if (seleccio == 1) {
//			
//		}
//		apuntador = (seleccio-1)*268;
//
//		if (apuntador >= aleatoriFile.length()) {
//			System.out.println("ERROR: ID incorrecte, no existeix aquesta persona");
//		} else {//Apuntar a l'inici del llibre seleccionat al fitxer
//			aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer
//			//Llegeix ID
//			id = aleatoriFile.readInt();
//			//Llegeix Títol
//			for(int i = 0; i<nom.length; i++) {
//				aux = aleatoriFile.readChar();
//				nom[i] = aux;
//			}
//			String noms = new String(nom);
//			//Llegeix Autor
//			for(int i = 0; i<cognom.length; i++) {
//				aux = aleatoriFile.readChar();
//				cognom[i] = aux;
//			}
//			String cognoms = new String(cognom);
//			//Llegeix ISBN
//			edat = aleatoriFile.readInt();
//			
//			//Llegeix Editorial
//			for(int i = 0; i<pais.length; i++) {
//				aux = aleatoriFile.readChar();
//				pais[i] = aux;
//			}
//			String paisos = new String(pais);
//			
//			//Sortida de les dades de cada llibre
//			System.out.println("ID: "+id+"\nNom: "+noms+"\nCognom: "+cognoms+"\nEdat: "+edat+"\nPais: "+paisos+"\n\n");
//		}
//		aleatoriFile.close();//Tancar el fitxer
//	}
}