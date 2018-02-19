import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Knn knn = new Knn();
		ArrayList<Musica> playLists = new ArrayList<>();
		playLists = knn.carregaArray("C:\\Users\\fran\\Documents\\musics.csv");
		int k = knn.qualK(playLists);
		System.out.println("Tamanho de k: "+k);
	for(int i=0; i<playLists.size(); i++){
			System.out.printf("%s\n", playLists.get(i).getCantor());
			System.out.printf("%s\n", playLists.get(i).getEnergia());
			System.out.printf("%s\n", playLists.get(i).getLiveness());
			System.out.printf("%s\n", playLists.get(i).getSpeechiness());
		}
		
		//ArrayList<Distancias> distancias = new ArrayList<>();
		playLists = knn.calcDistancias(playLists);
		System.out.println("Olá mundo");
		//for(int i = 0; i<playLists.size(); i++){
			//System.out.println("Tamanho do elemento :  "+playLists.get(0).getDistancias().size());
			for(int j=0; j<playLists.get(0).getDistancias().size(); j++){
				System.out.println("Titulo "+j+ ": "+playLists.get(0).getDistancias().get(j).getMusica().getTitulo());
				System.out.println("Distância dele pra essa música: "+playLists.get(0).getDistancias().get(j).getDistancia());
				
			}
		//}
			System.out.println("Depois da ordenação!----------------------");
			playLists = knn.ordenaVetores(playLists);
			for(int j=0; j<playLists.get(0).getDistancias().size(); j++){
				System.out.println("Titulo "+j+ ": "+playLists.get(0).getDistancias().get(j).getMusica().getTitulo());
				System.out.println("Distância dele pra essa música: "+playLists.get(0).getDistancias().get(j).getDistancia());
				
			}
		
		

	}

}
