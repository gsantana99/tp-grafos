import java.util.List;

public class Grafo {
	
	private short[][] matrizAdj;
	private List<Vertice> vertices;
	
	public Grafo(short[][] matrizAdj, List<Vertice> vertices) {
		this.matrizAdj = matrizAdj;
		this.vertices = vertices;
	}
	
	public short[][] getMatrizAdj(){
		return this.matrizAdj;
	}
	
	public List<Vertice> getVertices(){
		return this.vertices;
	}
	
	public boolean isAdjacente(Vertice v1, Vertice v2) {
		if(vertices.get(v1.getId()).getAdjacentes().contains(v2)) {
			return true;
		}
		return false;
	}
	
	public int getGrau(Vertice v) {
		return v.getGrau();
	}
		
	public boolean isRegular(Grafo g) {
		boolean isRegular = false;
		short grauV0 = g.getVertices().get(0).getGrau();
		for (int i = 1; i < g.getVertices().size(); i++) {
			if(grauV0 == g.getVertices().get(i).getGrau()) {
				isRegular = true;
			} else {
				isRegular = false;
				break;
			}
		}
		return isRegular;
	}
	
	public boolean isIsolado(Vertice v) {
		if(getGrau(v) == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isPendente(Vertice v) {
		if(getGrau(v) == 1) {
			return true;
		}
		return false;
	}
	
	public boolean isNulo(Grafo g) {
		byte somaGraus = 0;
		for (int i = 0; i < g.getVertices().size(); i++) {
			somaGraus += g.getVertices().get(i).getGrau();
		}
	//	System.out.println(somaGraus);
		if(somaGraus == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isCompleto(Grafo g) {
		byte somaGraus = 0;
		for (int i = 0; i < g.getVertices().size(); i++) {
			somaGraus += g.getVertices().get(i).getGrau();
		}
		byte numArestas = (byte) (somaGraus / 2);
	//	System.out.println(numArestas);
		if(numArestas == (((vertices.size()-1)*vertices.size())/2)) {
			return true;
		}
		return false;
	}
	
	/*
	public boolean isConexo(Grafo g) { }
	
	public boolean isBipartido(Grafo g) { }
	
	public Grafo getComplementar(Grafo g) { }
	
	public boolean isEuleriano(Grafo g) { }
	
	public boolean isUnicursal(Grafo g) { }
	
	public boolean hasCiclo(Grafo g) { }
	
	public int getGrauEntrada(Vertice v) { }
	
	public void ordenacaoTopologica(Grafo g) { hasCiclo(Grafo g); }
	
	public Grafo getTransposto(Grafo g) { }
	
	public boolean isFConexo(Grafo g) { }
	*/
	
}
