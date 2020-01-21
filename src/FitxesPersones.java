import java.io.IOException;
import java.util.Scanner;


public class FitxesPersones {

	public static void main(String[] args) throws IOException {

		Scanner teclado = new Scanner(System.in);

		int contador = 1;
		boolean salir = false;
		boolean escrit = false;

		EscriuFitxerAleatori escriu = new EscriuFitxerAleatori(contador);
		LleguirFitxerAleatori llegir = new LleguirFitxerAleatori();
		ConsultarFitxerAleatori consultar = new ConsultarFitxerAleatori();

		while (!salir) {

			System.out.println("0 Salir del programa");
			System.out.println("1 Guardar fitxa persona");
			System.out.println("2 Llegir totes les fitxes");
			System.out.println("3 Consultar mitjançant posicio");
			System.out.println("4 Consultar segons un camp");
			System.out.println("5 Escriure Fitxes d'Exemple");

			int seleccio = Integer.valueOf(teclado.nextLine());
			System.out.println();

			while (seleccio < 0 || seleccio > 5) {

				System.out.println("ERROR");
				System.out.println("0 Salir del programa");
				System.out.println("1 Guardar fitxa persona");
				System.out.println("2 Llegir totes les fitxes");
				System.out.println("3 Consultar mitjançant posicio");
				System.out.println("4 Consultar segons un camp");
				System.out.println("5 Escriure Fitxes d'Exemple");
				seleccio = Integer.valueOf(teclado.nextLine());
				System.out.println();
			}


			if (seleccio == 1) {

				escriu.escriureDades();
				contador++;
				escrit = true;
				System.out.println();

			} else if (seleccio == 3) {

				if (escrit) {

					consultar.ConsultarID();

				} else {

					System.out.println("El fitxer esta buit");
					System.out.println();
				}

			} else if (seleccio == 4) {

				if (escrit) {

					System.out.println("NO IMPLEMENTAT");
//					consultar.

				} else {

					System.out.println("El fitxer esta buit");
					System.out.println();
				}

			} else if (seleccio == 5) {

				escriu.escriureDadesExemple();
				contador += 5;
				escrit = true;
				System.out.println();

			} else if (seleccio == 2){

				if (escrit) {

					llegir.LlegirFitxer();

				} else {

					System.out.println("El fitxer esta buit");
					System.out.println();
				}


			} else  {

				salir = true;
			}
		}


	}

}
