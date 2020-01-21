import java.io.*;
import java.util.Scanner;

public class EscriuFitxerAleatori {
	
	int contador;
	
	public EscriuFitxerAleatori(int contador) {
		
		this.contador = contador;
	}
	
	public void escriureDadesExemple() throws IOException {
		File fitxer = new File("D:/m6/fitxer.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori per llegir
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		//Les dades per inserir
		String nom[] = {"Pepe", "Jose", "Izan", "David", "Oscar"};
		String cognoms[] = {"Alfredo Thomas", "Garcia Jonson", "Lorca Martinez", "Letrado Fernandez", "Jimenez Gil"};
		int edat[] = {19, 37, 31, 45, 35};
		String pais[] = {"España", "España", "França", "UK", "Holanda"};
		
		//Construeix un buffer (memòria intermèdia) de strings
		StringBuffer buffer = null;

		aleatoriFile.seek(aleatoriFile.length());
		
		for (int i=0; i<nom.length; i++) {
			aleatoriFile.writeInt(contador);//1 enter ocupa 4 bytes
			contador++;
			//50 caràcters a 2bytes/caràcter 100 bytes
			buffer = new StringBuffer (nom[i]);
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			//25 caràcters a 2bytes/caràcter 50 bytes
			buffer = new StringBuffer (cognoms[i]);
			buffer.setLength(50);
			aleatoriFile.writeChars(buffer.toString());
			//1 enter ocupa 4 bytes
			aleatoriFile.writeInt(edat[i]);
			//30 caràcters a 2bytes/caràcter 60 bytes
			buffer = new StringBuffer (pais[i]);
			buffer.setLength(30);
			aleatoriFile.writeChars(buffer.toString());
		}
		aleatoriFile.close();
	}
	
	public void escriureDades() throws IOException {
		
		File fitxer = new File("D:/m6/fitxer.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori per llegir
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		
		aleatoriFile.seek(aleatoriFile.length());
		//Construeix un buffer (memòria intermèdia) de strings
		StringBuffer buffer = null;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escriu el nom:");
		String nom = teclado.nextLine();
		
		System.out.println("Escriu els cognoms");
		String cognoms = teclado.nextLine();
		
		System.out.println("Escriu la edat:");
		int edat = Integer.valueOf(teclado.nextLine());
		
		System.out.println("Escriu el pais de origen:");
		String pais = teclado.nextLine();
		
		aleatoriFile.writeInt(contador);//1 enter ocupa 4 bytes
		//50 caràcters a 2bytes/caràcter 100 bytes
		buffer = new StringBuffer (nom);
		buffer.setLength(50);
		aleatoriFile.writeChars(buffer.toString());
		//25 caràcters a 2bytes/caràcter 50 bytes
		buffer = new StringBuffer (cognoms);
		buffer.setLength(50);
		aleatoriFile.writeChars(buffer.toString());
		//1 enter ocupa 4 bytes
		aleatoriFile.writeInt(edat);
		//30 caràcters a 2bytes/caràcter 60 bytes
		buffer = new StringBuffer (pais);
		buffer.setLength(30);
		aleatoriFile.writeChars(buffer.toString());
		
		aleatoriFile.close();
	}
}