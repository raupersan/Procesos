package ejercicio5;

public class Filosofo extends Thread{
	private String estado;

	public Filosofo(String estado) {
		super();
		this.estado = estado;
	}

	@Override
	public void run() {
		
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Estado actual: " + estado ;
	}
	
}
