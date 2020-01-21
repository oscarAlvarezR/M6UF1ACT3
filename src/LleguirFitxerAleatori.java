import java.io.*;

public class LleguirFitxerAleatori {
	
	public LleguirFitxerAleatori() {
		
	}
	public  void LlegirFitxer() throws IOException {
		File fitxer = new File("D:/m6/fitxer.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");
		
		//Apuntador s'inicialitza apuntant a l'inici del fitxer
		int apuntador = 0, edat, id;
		float preu;
		char nom[] = new char[50], cognom[] = new char[50], pais[] = new char[30], aux;
		
		//Recorrer el fitxer llibres
		for (;;) {
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
			//S'ha de posicionar l'apuntador al següent llibre
			apuntador += 268;
			//Si coincideix on s'està apuntat amb el final del fitxer, sortim
			if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
		}
		aleatoriFile.close();//Tancar el fitxer
	}
}