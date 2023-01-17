package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.ControlBiometrico;
import ar.edu.unlam.pb1.dominio.Registro;
import ar.edu.unlam.pb1.dominio.TipoEmpleado;
import ar.edu.unlam.pb1.dominio.Usuario;

public class Main {
	public static void main(String[] args) {
	Scanner teclado=new Scanner(System.in);

	System.out.println("ingrese el nombre del dispositivo:");
	String nombreDispositivo=teclado.next();
	System.out.println("ingrese la cantidad de usuarios que se pueden registrar:");
	int cantidadUsuariosQueSePuedenRegistrar=teclado.nextInt();
	
	ControlBiometrico dispositivo= new ControlBiometrico(nombreDispositivo,cantidadUsuariosQueSePuedenRegistrar);
	int opcion;
	do {
	
	System.out.println("Bienvenido al dispositivo " + dispositivo.getNombre() + ", Ingrese la opcion de acuerdo a la operacion que desee realizar:"
			+ "\n1 - Registrar un Usuario"
			+ "\n2 - Obtener un usuario por su numero de usuario"
			+ "\n3 - Obtener al usuario gerente de mayor sueldo"
			+ "\n4 - Registrar el ingreso de un usuario"
			+ "\n5 - Obtener todos los ingresos de un mes especifico"
			+ "\n9 - salir");
	
	opcion=teclado.nextInt();
	
	switch(opcion) {
	case 1:
		registrarUsuario(teclado,dispositivo);
		break;
		
	case 2:
		obtenerUsuarioPorNumeroDeUsuario(teclado,dispositivo);
		break;
		
	case 3:
		obtenerUsuarioGerenteDeMayorSueldo(dispositivo);
		break;
		
	case 4:
		registrarElIngresoDeUnUsuario(teclado,dispositivo);
		break;
		
	case 5:
		obteneringresosDeUnMesEspecifico(teclado,dispositivo);
		break;
		
	case 9:
		System.out.println("gracias por usar el sistema");
		break;
		
	default:
		System.out.println("opcion incorrecta, vuelva intentarlo");
		break;

	}
	
	}while(opcion!=9);
	
	}
	
	public static void registrarUsuario(Scanner teclado,ControlBiometrico dispositivo) {
		System.out.println("ingrese el numero del usuario");
		int numUsuario=teclado.nextInt();
		System.out.println("ingrese el apellido del usuario");
		String apellido=teclado.next();
		
		int opcion;
		do {
		System.out.println("ingrese el tipo de usuario:"
				+ "\n1 - ADMINISTRATIVO"
				+ "\n2 - GERENTE"
				+ "\n3 - OPERARIO");
		opcion=teclado.nextInt();
		}while(opcion<1 || opcion>3);
		
		TipoEmpleado tipo=TipoEmpleado.values()[opcion-1];
		
		System.out.println("ingrese el sueldo");
		double sueldo=teclado.nextDouble();
		
		Usuario user=new Usuario(numUsuario,apellido,tipo,sueldo);
		
		if(dispositivo.registrarUsuario(user)) {
			System.out.println("se registro el usuario");
		}else {
			System.out.println("error");
		}
		
	}
	
	public static void obtenerUsuarioPorNumeroDeUsuario(Scanner teclado,ControlBiometrico dispositivo) {
		System.out.println("ingrese el numero del usuario");
		int numUser=teclado.nextInt();
		System.out.println(dispositivo.obtenerUsuarioPorsuNumero(numUser).toString());
	}
	
	public static void obtenerUsuarioGerenteDeMayorSueldo(ControlBiometrico dispositivo) {
		System.out.println(dispositivo.obtenerUsuarioGerenteDeMayorSueldo().toString());
	}
	
	public static void registrarElIngresoDeUnUsuario(Scanner teclado,ControlBiometrico dispositivo) {
		System.out.println("ingrese el numero del usuario");
		int numUser=teclado.nextInt();
		System.out.println("ingrese el mes");
		int mes=teclado.nextInt();
		System.out.println("ingrese el dia");
		int dia=teclado.nextInt();
		
		if(dispositivo.registrarIngreso(dia, mes, numUser)) {
			System.out.println("se registro el ingreso");
		}else {
			System.out.println("error, num de usuario o fecha incorrecta");
		}
	}
	
	public static void obteneringresosDeUnMesEspecifico(Scanner teclado,ControlBiometrico dispositivo) {
		int mes;
		do {
		System.out.println("ingrese el numero de mes del que desea obtener los registros");
		mes=teclado.nextInt();
		}while(mes<0 || mes>12);
		
		Registro registros[]=dispositivo.obtenerRegistrosDeUnMesOrdenados(mes);
		
		if(registros==null) {
			System.out.println("no hay registros del mes" + mes + "disponibles");
		}
		
		for(int i=0;i<registros.length;i++) {
			if(registros[i]!=null) {
				System.out.println(registros[i].toString());
			}
		}
	}

}
