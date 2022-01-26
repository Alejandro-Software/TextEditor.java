import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Start {
	
	public static void CrearFichero(String url) {
		File f=null;
		FileWriter fw=null;
		PrintWriter pw=null;
		
		try {
			fw=new FileWriter(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	

	public static void EditarFichero(String url, Scanner entrada, boolean tipo, int opcion) {
		FileWriter fw=null;
		PrintWriter pw=null;
		String texto="";
		File f=new File(url);	
		
		if (!f.exists()) {
			System.out.println("Fichero inexistente");
		}else{
			do {
			System.out.println("¿Quieres sobreescribir el texo anterior o añadir texto?");
			System.out.println("1)Sobreescribir");
			System.out.println("2)Añadir");
			opcion=entrada.nextInt();
			if(opcion==1)
			{
				tipo=false;
				System.out.println("Introduzca el texto para sobreescribir el fichero: ");
				entrada.nextLine();
				texto=entrada.nextLine();
				try {
					fw=new FileWriter(f,tipo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw=new PrintWriter(fw,tipo);
				pw.print(texto);
				System.out.println("Documento editado correctamente");
			}else if (opcion==2)
			{
				tipo=true;
				System.out.println("Introduzca el texto que desea añadir al fichero: ");
				try {
					fw=new FileWriter(f,tipo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw=new PrintWriter(fw,tipo);
				entrada.nextLine();
				texto=entrada.nextLine();
				pw.print(texto);
				System.out.println("Documento editado correctamente");
			}
			else
			{
				System.out.println("Introduzca una opcion valida ");
			}}while (opcion>2 || opcion<0);
			}	
		pw.close();
		
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	
	public static void Borrar(String url, String opcion2, Scanner entrada) {
		File f=null;
		f=new File(url);
		if(f.exists()) {
			System.out.println("¿Está seguro que desea borrarlo (Afirmación Si)? ");
			opcion2=entrada.next();
			if (opcion2.equals("si")) 
			{
				f.delete();
			}
		}
		else
		{
			System.out.println("El fichero no existe.");
		}
	}
	
	
	
	public static void CrearCarpeta(String url) {
		File f=null;		
		f=new File(url);
		
		if(f.exists()) {
		System.out.println("Carpeta ya existente");
		}
		
		if(f.mkdir()) {
		System.out.println("Carpeta creada correctamente");	
		}
	}
	
	
	

	public static void BorrarCarpeta(String url, String opcion2, Scanner entrada) {
	File f=new File(url);	
	if(f.exists()) {
		System.out.println("¿Está seguro que desea borrar la carpeta (Afirmación Si)? ");
		opcion2=entrada.next();
	}else {
		System.out.println("La carpeta no existe");
	}
	if(opcion2.equals("si")){
		f.delete();
	}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion=0;
		String url="";
		boolean tipo=true;
		String opcion2="";
		Scanner entrada=new Scanner(System.in);
		
		do {
		System.out.println("*********************************");
		System.out.println("EDITOR DE TEXTO ");
		System.out.println("*********************************"); 
		System.out.println("Seleccione una opción:"); 
		System.out.println("1) Crear un fichero ");
		System.out.println("2) Editar un fichero ");
		System.out.println("3) Borrar un fichero"); 
		System.out.println("4) Crear una carpeta"); 
		System.out.println("5) Borrar una carpeta ");
		System.out.println("0) Salir ");
		System.out.print("Opción:_");
		opcion=entrada.nextInt();
		System.out.println("");
		
		
		if(opcion==0) {
			System.out.println("Programa finalizado");
		}
		
		if(opcion==1) {
			System.out.println("Introduzca el nombre del nuevo fichero:");    //EL USUARIO INDICARÁ LA RUTA.
			url=entrada.next();
			CrearFichero(url);		
		}
		
		if(opcion==2) {
			System.out.println("Introduzca el nombre del fichero a editar:");
			url=entrada.next();
			EditarFichero(url,entrada,tipo, opcion);
			
			
		}
		
		if(opcion==3) {
			System.out.println("Introduzca el nombre del fichero a borrar: ");
			url=entrada.next();
			Borrar(url, opcion2, entrada);
			
		}
			
		if(opcion==4) {
			System.out.println("Introduzca el nombre de la carpeta a crear: ");
			url=entrada.next();
			CrearCarpeta(url);		
		}
		
		if(opcion==5) {
			System.out.println("Introduzca el nombre de la carpeta a borrar:");
			url=entrada.next();
			BorrarCarpeta(url, opcion2,entrada);
		}
			
		
		
		}while(opcion!=0);
		
		
	}

}
