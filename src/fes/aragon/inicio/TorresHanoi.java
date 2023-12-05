package fes.aragon.inicio;

import fes.aragon.utilerias.dinamicas.pila.Pila;

/**
 * Clase que resuelve Torres de Hanoi
 * @author Darxus
 *
 */
public class TorresHanoi {

	public static void main(String[] args) {
		
		System.out.print("Torres de Hanoi recursivo: \n");
		TorresHanoi.torreRecursivo(2, "A", "B", "C");
		System.out.println();
		TorresHanoi.torreCuatroPilas(2, "A", "B", "C");
		System.out.println();
		TorresHanoi.torreUnaPila(2, "A", "B", "C");
		
	}
	/**
	 * Metodo que muestra los pasos para resolver las torres de Hanoi de manera recursiva
	 * @param n parametro que indica el numero de discos 
	 * @param origen parametro que indica la columna del origen de los discos
	 * @param aux parametro que indica la columna auxiliar 
	 * @param destino parametro que indica la columna destino, a donde se moverán
	 */
	public static void torreRecursivo(int n, String origen, String aux, String destino) {
		
		if(n<1) {
			System.out.println("Ingresar números mayores a 0");
		}else {
			if (n == 1) {
				System.out.println("Mover un disco de " + origen + " a " + destino);
			} else {
				TorresHanoi.torreRecursivo(n - 1, origen, destino, aux);
				System.out.println("Mover un disco de " + origen + " a " + destino);
				TorresHanoi.torreRecursivo(n - 1, aux, origen, destino);
			}
		}

	}
	/**
	 * Metodo que muestra los pasos para resolver las torres de Hanoi usando cuatro pilas
	 * @param n parametro que indica el numero de discos
	 * @param origen parametro que indica la columna origen 
	 * @param aux parametro que indica la columna auxiliar
	 * @param destino parametro que indica la columna destino, a donde llegarán los discos
	 */
	public static void torreCuatroPilas(int n, String origen, String aux, String destino) {
		boolean band = false;
		Pila<Integer> pilaN = new Pila<>();
		Pila<String> pilaO = new Pila<>();
		Pila<String> pilaD = new Pila<>();
		Pila<String> pilaA = new Pila<>();
		String varAux;
		System.out.println("Torres de Hanoi con 4 pilas: \n");

		while (n > 0 && band == false) {
			while (n > 1) {
				pilaN.insertar(n);
				pilaO.insertar(origen);
				pilaD.insertar(destino);
				pilaA.insertar(aux);

				n--;
				varAux = destino;
				destino = aux;
				aux = varAux;
			}
			System.out.println("Mover un disco de " + origen + " a " + destino);
			band = true;
			if (!pilaN.estaVacia() && !pilaO.estaVacia() && !pilaD.estaVacia() && !pilaA.estaVacia()) {
				try {
					n = pilaN.extraer();
					origen = pilaO.extraer();
					destino = pilaD.extraer();
					aux = pilaA.extraer();
					System.out.println("Mover un disco de " + origen + " a " + destino);

					n--;
					varAux = origen;
					origen = aux;
					aux = varAux;
					band = false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
	/**
	 * Metodo que muestra los pasos para resolver las Torres de Hanoi usando una pila
	 * @param n parametro que indica el numero de discos
	 * @param origen parametro que indica la columna de origen
	 * @param aux parametro que indica la columna auxiliar
	 * @param destino parametro que indica la columna destino, a donde se moverán
	 */
	public static void torreUnaPila(int n, String origen, String aux, String destino) {

		Pila<AtributosHanoi> pila = new Pila<>();
		boolean band = false;
		String varAux;

		System.out.println("Torres de Hanoi con 1 pila: \n");
		while (n > 0 && band == false) {
			while (n > 1) {
				pila.insertar(new AtributosHanoi(n,origen,aux,destino));

				n--;
				varAux = destino;
				destino = aux;
				aux = varAux;
				
			}
			System.out.println("Mover un disco de " + origen + " a " + destino);
			band = true;
			
			if (!pila.estaVacia()) {
				try {
					n=pila.elementoSuperior().getN();
					origen = pila.elementoSuperior().getOrigen();
					destino = pila.elementoSuperior().getDestino();
					aux = pila.extraer().getAux();
					
					
					System.out.println("Mover un disco de " + origen + " a " + destino);

					n--;
					varAux = origen;
					origen = aux;
					aux = varAux;
					band = false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}
}
