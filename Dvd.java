package inventory;

public class Dvd extends Product{
	private String artist, seal;
	private int albmMusicNmbr;
	
	public Dvd(String name, int quantidade, double valor, String artist,
			String seal, int albmMusicNmbr) {
		super(name, quantidade, valor);
		this.artist = artist;
		this.seal = seal;
		this.albmMusicNmbr = albmMusicNmbr;
		// TODO Auto-generated constructor stub
	}
	
	
	public String toString() {
		return super.toString() + "Artista : " + getArtist()
				+ "\nMusica numero: " + getAlbmMusicNmbr()
				+ "do album\n" + "Selo de gravacao: " + getSeal() +"\n";
	}
	
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSeal() {
		return seal;
	}
	public void setSeal(String seal) {
		this.seal = seal;
	}
	public int getAlbmMusicNmbr() {
		return albmMusicNmbr;
	}
	public void setAlbmMusicNmbr(int albmMusicNmbr) {
		this.albmMusicNmbr = albmMusicNmbr;
	}
	
	public double price() {
		return super.price();
	}
}
