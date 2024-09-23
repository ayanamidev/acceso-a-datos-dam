package com.dam;

import java.io.File;
import java.io.IOException;

public class Principal {
	
	//elegir una ruta y crear dos directorios, dam 1 y dam 2, dentro de dam 1 cerar un fichero llamado sistemas.cdv 
	//y dentro de dam 2 crear fichero llamado acceso a datos.txt

	public static void main(String[] args) {
		File file=new File("C:\\PRUEBAS");
		File directorio1=new File(file,"DAM1");
		directorio1.mkdir();
		File directorio2=new File(file,"DAM2");
		directorio2.mkdir();
		File fichero1=new File(directorio1,"sistemas.cdv");
		try {
			fichero1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fichero2=new File(directorio2,"datos.txt");
		try {
			fichero2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
