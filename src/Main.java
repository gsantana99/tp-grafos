import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	private static short[][] matrizAdj = null;
	private static List<Vertice> vertices = new ArrayList<Vertice>();

	public static void main(String[] args) {
		leEntrada();
		Grafo g = new Grafo(matrizAdj, vertices);
		System.out.println(g.isAdjacente(g.getVertices().get(0), g.getVertices().get(2)));
		System.out.println(g.getGrau(g.getVertices().get(0)));
		System.out.println(g.isRegular(g));
		System.out.println(g.isIsolado(g.getVertices().get(0)));
		System.out.println(g.isPendente(g.getVertices().get(0)));
		System.out.println(g.isNulo(g));
		System.out.println(g.isCompleto(g));
		System.out.println();
		printaMatriz(matrizAdj);
	}

	private static void leEntrada() {
		try {
			FileReader fr = new FileReader("entrada.txt");
			BufferedReader br = new BufferedReader(fr);
			int numVertices = Integer.parseInt(br.readLine());
			matrizAdj = new short[numVertices][numVertices];
			String[] conexoes = new String[numVertices];
			String linha = br.readLine();
			for (int i = 0; i < numVertices; i++) {
				conexoes[i] = linha.substring(linha.lastIndexOf(' ') + 1, linha.indexOf(';'));
				linha = br.readLine();
				vertices.add(new Vertice((short) i));
			}
			int i = 0;
			while (i < numVertices) {
				List<String> listaConexoes = new ArrayList<String>(Arrays.asList(conexoes[i].split("-")));
				// System.out.println(listaConexoes);
				if (listaConexoes.size() > 1) {
					listaConexoes.remove(0);
					// System.out.println(listaConexoes);
					for (int j = 0; j < numVertices; j++) {
						if (listaConexoes.contains(j + "")) {
							if (i == j) {
								matrizAdj[i][j] += 2;
								vertices.get(i).addAdjacente(vertices.get(j));
							} else {
								matrizAdj[i][j] += 1;
								matrizAdj[j][i] += 1;
								vertices.get(i).addAdjacente(vertices.get(j));
								vertices.get(j).addAdjacente(vertices.get(i));
							}
						} else {
							matrizAdj[i][j] += 0;
						}
					}
				}
				i++;
			}
			short somaX = 0;
			for (int k = 0; k < numVertices; k++) {
				for (int y = 0; y < matrizAdj[0].length; y++) {
					somaX += matrizAdj[k][y];
				}
			//	System.out.println(somaX);
				vertices.get(k).setGrau(somaX);
				somaX = 0;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printaMatriz(short[][] matrizAdj) {
		for (int i = 0; i < matrizAdj[0].length; i++) {
			for (int j = 0; j < matrizAdj[1].length; j++) {
				System.out.print(matrizAdj[i][j] + " ");
			}
			System.out.println();
		}
	}
}
