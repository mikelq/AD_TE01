package ad_te01;

import java.io.*;

public class Ejer3 {
	public static void main (String[] args) throws IOException {
		String archivo = "C:\\Users\\Mikel\\Documents\\DAM\\AD\\src\\ad_te01\\a.pdf";
		byte[] cabecera= {37, 80, 68, 70};
		try {	
			
			InputStream inpt = new FileInputStream(archivo);	
			byte[] cabeceraArchivo = new byte[4];
			if(inpt.read(cabeceraArchivo) != -1	) {
				boolean esPDF = true;
				for (int i = 0; i < cabeceraArchivo.length; i++) {
					if(cabecera[i] != cabeceraArchivo[i]) {
						esPDF = false;
						break;
					}
				}
				if(esPDF) {
					System.out.println("El archivo es un PDF.");
				}else {
					System.out.println("El archivo NO es un PDF.");
				}
			}

		}catch(FileNotFoundException fn) {
			System.out.println("No se ha encontrado archivo");
		}
	}
}
