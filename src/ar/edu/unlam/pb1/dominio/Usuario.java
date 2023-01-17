package ar.edu.unlam.pb1.dominio;

public class Usuario {
	private int numUsuario;
	private String apellido;
	private TipoEmpleado empleado;
	private double sueldo;
	
	public Usuario(int numUsuario, String apellido, TipoEmpleado empleado, double sueldo) {
		super();
		this.numUsuario = numUsuario;
		this.apellido = apellido;
		this.empleado = empleado;
		this.sueldo = sueldo;
	}
	

	@Override
	public String toString() {
		return "Usuario [numUsuario=" + numUsuario + ", apellido=" + apellido + ", empleado=" + empleado + ", sueldo="
				+ sueldo + "]";
	}


	public int getNumUsuario() {
		return numUsuario;
	}

	public void setNumUsuario(int numUsuario) {
		this.numUsuario = numUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoEmpleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(TipoEmpleado empleado) {
		this.empleado = empleado;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	

}
