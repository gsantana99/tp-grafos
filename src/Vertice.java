import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	private short id;
	private short grau;
	private short grauEntrada;
	private List<Vertice> verticesAdjacentes;
	
	public Vertice(short id) {
		this.id = id;
		this.grau = 0;
		this.grauEntrada = 0;
		this.verticesAdjacentes = new ArrayList<Vertice>();
	}
	
	public short getId() {
		return id;
	}
	
	public short getGrau() {
		return this.grau;
	}
	
	public void setGrau(short grau) {
		this.grau = grau;
	}
	
	public short getGrauEntrada() {
		return this.grauEntrada;
	}
	
	public void addAdjacente(Vertice v) {
		this.verticesAdjacentes.add(v);
		this.grau = (short) verticesAdjacentes.size();
	}
	
	public void incrementaGrau(short k) {
		this.grau += k;
	}
	
	public List<Vertice> getAdjacentes(){
		return this.verticesAdjacentes;
	}
	
}
