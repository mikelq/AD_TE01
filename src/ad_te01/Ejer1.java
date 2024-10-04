package ad_te01;
import java.io.*;
import java.util.ArrayList;
public class Ejer1{

	public static void main (String[] args) throws IOException {
		
		File ficheroE = new File ("C:\\Users\\Mikel\\Documents\\DAM\\AD\\src\\ad_te01\\fichero_entrada.txt");
		File ficheroS = new File ("C:\\Users\\Mikel\\Documents\\DAM\\AD\\src\\ad_te01\\fichero_salida.txt");
		FileReader ficE = new FileReader(ficheroE);
		FileWriter ficS = new FileWriter(ficheroS);
		
		int i;
		
		ArrayList<Character> texto = new ArrayList<Character>();
		while ((i = ficE.read()) != -1)
				texto.add((char) i);
				
		for(int c=texto.size()-1; c>=0; c--){
			ficS.write(texto.get(c));
			
		}
			
		ficE.close();
		ficS.close();
	}
}
