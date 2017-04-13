package tp3;
import java.util.ArrayList;

public class GrafoDirigido {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();

	public boolean dfsIterativo() {
		reiniciarVertices();
		for (Vertice vertice : vertices) {

			Pila q = new Pila();
				vertice.setVisitado(true);
				q.apilar(vertice);

				while (!q.isEmpty()) {
					Vertice vert = q.tope();
					q.desapilar();
					for (Vertice w : vert.getAdyacentes()) {
						if (!w.isVisitado()) {
							w.setVisitado(true);
							q.apilar(w);
						} else if (w.isVisitado() && !w.isTerminado()) {
							return true;
						} else if ((w.isVisitado()) && (!w.isTerminado())) {
							w.setTerminado(true);
						}
					}
				}
			
		}
		return false;
	}

	public boolean dfs() {
		
		reiniciarVertices();
		for (Vertice adyacente : this.vertices) {
			if (!adyacente.isVisitado()) {
				if(dfsRecursivo(adyacente)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfsRecursivo(Vertice v) {
		
		v.setVisitado(true);
		for (Vertice adyacente : v.getAdyacentes()) {
			
			if ((adyacente.isVisitado()) && (!adyacente.isTerminado())) {
				return true;	
			}
			
			if (!adyacente.isVisitado()) {
				dfsRecursivo(adyacente);
			}
		}

		v.setTerminado(true);
		return false;
	}

	protected Vertice getVertice(int u) {
		return this.getElemByEtiqueta(u);
	}

	public Vertice getElemByEtiqueta(int u) {
		Vertice answer = new Vertice(u);
		for (Vertice v : this.vertices) {
			if (v.getEtiqueta() == u) {
				answer = v;
			}
		}
		return answer;
	}

	private void reiniciarVertices() {
		for (Vertice v : this.vertices) {
			v.setVisitado(false);
			v.setTerminado(false);
		}
	}
	
	public void addVertice(int i) {
		Vertice v = new Vertice(i);
		this.vertices.add(v);
	}
	
	public void addAdyacente(int u, int v) {
		this.getElemByEtiqueta(u).addAdyacente(this.getElemByEtiqueta(v));

	}
}
