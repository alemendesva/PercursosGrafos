import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
	public static void main(String[] args) {
		BufferedReader leitor = new BufferedReader(
								new InputStreamReader(System.in));
				
		
		Grafo objGrafo = new Grafo(5);
		int inicio = 0;
		int fim = 0;
		
		objGrafo.construir(false);
		
		do {
			try {
			System.out.print("Digite o vértice inicial: ");
			inicio = Integer.parseInt(leitor.readLine());
			
			System.out.print("Digite o vértice final: ");
			fim = Integer.parseInt(leitor.readLine());
			}catch (Exception e) {}
			
			objGrafo.procurarPercurso(inicio, fim);
		}while (inicio != fim);
	}

}
