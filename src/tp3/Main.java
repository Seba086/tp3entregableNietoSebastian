package tp3;



public class Main {

	public static void main(String[] args) {
		
		GrafoDirigido grafo = new GrafoDirigido();
		final int SIZE = 1205;
		for(int i=1; i<SIZE; i++){
			grafo.addVertice(i);
		}
		for(int i=1; i<SIZE; i++){
			int j = (int) Math.floor(Math.random() *SIZE);	// SIZE = Adyacentes por Vertice
				for (int k = 0; k < j; k++) {
					int h = (int) Math.ceil(Math.random() * SIZE); // Elije como adyacente un n�mero dentro del SIZE
					grafo.addAdyacente(i ,h);
				}
	}
	
		System.out.println("Chequeo si existen ciclos con el m�todo DFS recursivo: " + grafo.dfs());
		System.out.println("Chequeo si existen ciclos con el m�todo BFS recursivo: " + grafo.dfsIterativo());

		/* Si se prueban los dos m�todos, DFS recursivo y DFS iterativo, con el mismo grafo con valores superiores a 1000 (en la constante SIZE), existe la posibilidad de que el m�todo DFS recursivo 
		 * arroje Stack Overflow dado que cada recursi�n la va apilando hasta llenar la memoria, sobre todo
		 * con valores muy altos. 
		 * 
		 * A diferencia de �ste, con el DFS iterativo y el uso de la pila, la �nica posibilidad de llegar a un
		 * error de Stack Overflow ser�a tirando valores extremadamente altos. Con este algoritmo iterativo,
		 * al no haber pasadas recursiones en memoria, por lo que es menos probable que crashee.
		 */
	
	}
}
