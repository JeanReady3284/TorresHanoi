package fes.aragon.inicio;

public class AtributosHanoi {

	private int n;
	private String origen;
	private String aux;
	private String destino;

	public AtributosHanoi(int n, String origen, String aux, String destino) {
		super();
		this.n = n;
		this.origen = origen;
		this.aux = aux;
		this.destino = destino;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
