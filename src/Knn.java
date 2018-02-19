import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Knn {
	
	public ArrayList<Musica> carregaArray(String nomeArq){
		ArrayList<Musica> todasMusicas = new ArrayList<>();
		try{
			FileReader meuArq = new FileReader(nomeArq);
			BufferedReader lerArq = new BufferedReader(meuArq);
			String conteudo = lerArq.readLine();
			while(conteudo != null){
				String objeto[] = new String[6];
				objeto = conteudo.split(",");
				
				Musica musica = new Musica();
				musica.setTitulo(objeto[0]);
				musica.setCantor(objeto[1]);
				musica.setPopularidade(Integer.parseInt(objeto[2]));
				musica.setEnergia(Float.parseFloat(objeto[3]));
				musica.setSpeechiness(Float.parseFloat(objeto[4]));
				musica.setLiveness(Float.parseFloat(objeto[5]));
				todasMusicas.add(musica);
				
				conteudo = lerArq.readLine();
				
			}
			meuArq.close();
		}catch (IOException e) {
			System.out.println("Erro na abertura do arquivo: "+ e.getMessage());
		}
		return todasMusicas;
	}
	
	public int qualK(ArrayList<Musica> playLists){
		int sizePlaylist = playLists.size(); 
		if(sizePlaylist < 10){
			return sizePlaylist;
		}else{
			if(sizePlaylist/10 < 1.9){
				return sizePlaylist;
			}else{
				return sizePlaylist/10;
			}
		}
		//return 0;
	}
	public ArrayList<Musica> calcDistancias(ArrayList<Musica> musicas){
		ArrayList<Distancias> distancias;
		double dist;
		Distancias distancia;
		for(int i=0; i<musicas.size(); i++){
			distancias = new ArrayList<>();
			for(int j=0; j<musicas.size(); j++){
				if(i==j){
					continue;
				}else{
					dist=Math.sqrt(Math.pow(musicas.get(i).getPopularidade()-musicas.get(j).getPopularidade(),2)+
							Math.pow(musicas.get(i).getEnergia()-musicas.get(j).getEnergia(),2)+
							Math.pow(musicas.get(i).getLiveness()-musicas.get(j).getLiveness(),2)+
							Math.pow(musicas.get(i).getSpeechiness()-musicas.get(j).getSpeechiness(), 2));
							distancia = new Distancias();
							distancia.setDistancia(dist);
							distancia.setMusica(musicas.get(j));
							//System.out.println("Distancia: "+dist);
							distancias.add(distancia);
							//System.out.println("Dentro de distancia ta ino a musica: "+distancias.get(j).getMusica().getTitulo());
							//System.out.println("Musica da posucação i: "+musicas.get(i).getTitulo());
							//System.out.println("Musica da posicao j: "+musicas.get(j).getTitulo());
							
				}
			}
			musicas.get(i).setDistancias(distancias);
		}
		return musicas;
	}
	
	public ArrayList<Musica> ordenaVetores(ArrayList<Musica> musicas){
		for(int i=0; i<musicas.size(); i++){
			ArrayList<Distancias> distancias = new ArrayList<>();
			distancias = musicas.get(i).getDistancias();
			Collections.sort(distancias, new ComparadorDistancias());
			for(int j=0; j<musicas.get(i).getDistancias().size(); j++){
				//musicas.get(i).getDistancias().get(j).
				
			}
		}
		return musicas;
	}
	public ArrayList<PlayList> knn(int k, ArrayList<Musica> musicas ){
		ArrayList<PlayList> playlists = new ArrayList<>();
		PlayList play ;
		ArrayList<Musica> musicasArray=null;
		for(int i=0; i<musicas.size()-1; i++){
			musicasArray = new ArrayList<>();
			for(int j=0; j<k; j++){
				musicasArray.add(musicas.get(i).getDistancias().get(j).getMusica());
				//System.out.println(musicasArray.get(j).getTitulo());
			//	
				//playlists.set(i,musicasArray);
			}
			play = new PlayList();
			play.setMusicas(musicasArray);
			playlists.add(play);
			
		}
		
		//System.out.println(playlists.size());
		return playlists;
	}
}
