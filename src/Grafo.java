import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	// Propriedades da clase
	private boolean[][] matrizAdjacencias = null;
	
	//Métodos construtores da classe
	public Grafo(int qtdVertices) {
		matrizAdjacencias = new boolean[qtdVertices][qtdVertices];
		
	}
	// Métodos da classe
	public void construir(boolean aleatorio) {
		BufferedReader leitor = new BufferedReader(
								new InputStreamReader(System.in));
		
		
		for (int i = 0 ; i < (matrizAdjacencias.length - 1) ; i++) {
			for (int j = (i + 1) ; j < matrizAdjacencias.length ; j++) {
				boolean adjacencia = false;
				if (aleatorio) {
					adjacencia = (((int) (2 * Math.random())) == 1);
					
				}else {
					try {
					System.out.print("Digite <1> se " + i +
									"for vizinho de " + j + ": ");
					adjacencia = (Integer.parseInt(leitor.readLine()) == 1);
					}catch (Exception e) {}	
					
				}
					
				matrizAdjacencias[i][j] = adjacencia;
				matrizAdjacencias[j][i] = adjacencia;
			}
		}
	}
			private boolean procurarPercursoRecursivo(boolean visitado[],
													int inicio, int fim) {
			if (inicio == fim) {
				return true;
				
			}
			visitado[inicio] = true;
			for (int vizinho = 0 ; vizinho < matrizAdjacencias.length ; vizinho++) {
				if ((matrizAdjacencias[inicio][vizinho]) && (! visitado[vizinho])) {
					if (procurarPercursoRecursivo(visitado, vizinho, fim)) {
						System.out.print(vizinho + " <- ");
						return true;
					}
				}
			}
			return false;
			}
			public void procurarPercurso(int inicio, int fim) {
				if (procurarPercursoRecursivo(new boolean[matrizAdjacencias.length],
												inicio, fim)) {
					System.out.println(inicio);
				}else {
					System.out.println("Não encontrei um caminho!");
				}
			}
		}