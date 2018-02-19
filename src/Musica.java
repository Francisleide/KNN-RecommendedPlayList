import java.util.ArrayList;

public class Musica {
	private double energia;
	private int popularidade;
	private double liveness;
	private double speechiness;
	private String titulo;
	private String cantor;
	private ArrayList<Distancias> distancias;
	public double getEnergia() {
		return energia;
	}
	public void setEnergia(double energia) {
		this.energia = energia;
	}
	public int getPopularidade() {
		return popularidade;
	}
	public void setPopularidade(int popularidade) {
		this.popularidade = popularidade;
	}
	public double getLiveness() {
		return liveness;
	}
	public void setLiveness(double liveness) {
		this.liveness = liveness;
	}
	public double getSpeechiness() {
		return speechiness;
	}
	public void setSpeechiness(double speechiness) {
		this.speechiness = speechiness;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCantor() {
		return cantor;
	}
	public void setCantor(String cantor) {
		this.cantor = cantor;
	}
	public ArrayList<Distancias> getDistancias() {
		return distancias;
	}
	public void setDistancias(ArrayList<Distancias> distancias) {
		this.distancias = distancias;
	}
	
	
	
	
	
}
