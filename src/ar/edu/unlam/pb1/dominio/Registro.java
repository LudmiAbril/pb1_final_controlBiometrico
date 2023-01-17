package ar.edu.unlam.pb1.dominio;

public class Registro {
	private int numEmpleado;
	private int dia;
	private int mes;
	
	public Registro(int numEmpleado, int dia, int mes) {
		this.numEmpleado = numEmpleado;
		this.dia = dia;
		this.mes = mes;
	}
	
	

	@Override
	public String toString() {
		return "Registro [numEmpleado=" + numEmpleado + ", dia=" + dia + ", mes=" + mes + "]";
	}



	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	

}
