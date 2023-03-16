package inventory;

public class Cd extends Product{
	private double duration;
	private int classification;
	private String studio;
	
	public Cd(String name, int quantidade, double valor, Double duration,
			  int classification, String studio) {
		super(name, quantidade, valor);
		this.studio = studio;
		this.duration = duration;
		this.classification = classification;
		
	}
	
	
	public String toString() {
		return super.toString() + "Duração do CD: " + getDuration()
				+ "\nClassificação: " + getClassification()
				+ "\nEstudio: " + getStudio() +"\n";
	}
	
	
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public int getClassification() {
		return classification;
	}
	public void setClassification(int classification) {
		this.classification = classification;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	
	public double price() {
		return (super.price() - (super.price()*0.05));
	}
	
}
