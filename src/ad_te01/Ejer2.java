package ad_te01;

import java.io.*;


public class Ejer2 {
	public static void main (String[] args) throws IOException {
		try {	
			BufferedReader ficheroE = new BufferedReader(new FileReader("C:\\Users\\Mikel\\Documents\\DAM\\AD\\src\\ad_te01\\fichero_entrada.txt"));
			BufferedWriter ficheroS= new BufferedWriter (new FileWriter("C:\\Users\\Mikel\\Documents\\DAM\\AD\\src\\ad_te01\\fichero_salida.txt"));
			
			String ln;
			while((ln = ficheroE.readLine()) != null) {
				
				String[] lnEntera = ln.split(" ");
				
				String nombre = lnEntera[0];
				if(nombre.length() == 5) {
					ficheroS.write(nombre);
					ficheroS.newLine();
				}
			}
			ficheroE.close();
			ficheroS.close();
		}catch(FileNotFoundException fn) {
			System.out.println("No se ha encontrado archivo");
		}
			
	}
}
