package ar.edu.unlam.pb1.dominio;

public class ControlBiometrico {
	String nombre;
	int cantidadRegistrosIngreso;
	Usuario usuarios[];
	Registro ingresos[];
	
	
	public ControlBiometrico(String nombre,int cantidadUsuarios) {
		this.nombre=nombre;
		this.usuarios=new Usuario[cantidadUsuarios];
		this.ingresos=new Registro[50000];
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public boolean registrarUsuario(Usuario usuario) {
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]==null) {
				usuarios[i]=usuario;
				return true;
			}
		}
		return false;
	}
	
	public Usuario obtenerUsuarioPorsuNumero(int numUsuario) {
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].getNumUsuario()==numUsuario) {
				return usuarios[i];
			}
		} return null;
	}
	
	public Usuario obtenerUsuarioGerenteDeMayorSueldo() {
		Usuario gerentes[]=new Usuario[usuarios.length];
		int j=0;
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].getEmpleado().equals(TipoEmpleado.GERENTE)) {
				gerentes[j]=usuarios[i];
				j++;
			}
		}
		
		ordenarSueldoDescendente(gerentes);
		Usuario gerenteMayorSueldo=gerentes[0];
		
		return gerenteMayorSueldo;
		
	}
	
	public static void ordenarSueldoDescendente(Usuario usuariosOrdenar []) {
		Usuario aux;
		for(int i=0;i<usuariosOrdenar.length;i++) {
			for(int j=0;j<usuariosOrdenar.length-1;j++) {
				if(usuariosOrdenar[j]!=null && usuariosOrdenar[j+1]!=null && usuariosOrdenar[j].getSueldo()<usuariosOrdenar[j+1].getSueldo()) {
					aux=usuariosOrdenar[j];
					usuariosOrdenar[j]=usuariosOrdenar[j+1];
					usuariosOrdenar[j+1]=aux;
				}
			}
		}
	}
	
	public static void ordenarNumUserDescendente(Registro usuariosOrdenar []) {
		Registro aux;
		for(int i=0;i<usuariosOrdenar.length;i++) {
			for(int j=0;j<usuariosOrdenar.length-1;j++) {
				if(usuariosOrdenar[j]!=null && usuariosOrdenar[j+1]!=null && usuariosOrdenar[j].getNumEmpleado()<usuariosOrdenar[j+1].getNumEmpleado()) {
					aux=usuariosOrdenar[j]; 
					usuariosOrdenar[j]=usuariosOrdenar[j+1];
					usuariosOrdenar[j+1]=aux;
				}
			}
		}
	}
	
	public Registro[] obtenerRegistrosDeUnMesOrdenados(int mes) {
		Registro registrosMes[]=new Registro[50000];
		int j=0;
		for(int i=0;i<ingresos.length;i++) {
			if(ingresos[i]!=null && ingresos[i].getMes()==mes) {
				registrosMes[j]=ingresos[i];
				j++;
			}
		}
		
		ordenarNumUserDescendente(registrosMes);
		
		return registrosMes;
		
	}
	
	public boolean registrarIngreso(int dia, int mes, int numUser) {
		if(obtenerUsuarioPorsuNumero(numUser)!=null && validarFecha(dia,mes)) {
			for(int i=0;i<ingresos.length;i++) {
				if(ingresos[i]==null) {
					ingresos[i]=new Registro(numUser,dia,mes);
					return true;
				}
			}
		} return false;
	}
	
	public static boolean validarFecha(int dia, int mes) {
		if(dia<0 || dia>31) {
			return false;
		}
		
		if(mes<0 || mes>12) {
			return false;
		}
		
		if(mes==2 && dia>28) {
			return false;
		}
		
		if(mes<=6) {
			if(mes%2==0 && dia>30) {
				return false;
			}
		}
		
		if(mes>=6) {
			if(mes%2!=0 && dia>30) {
				return false;
			}
		}
		
		
		return true;
	}

}
