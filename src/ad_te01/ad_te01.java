package ad_te01;
import java.io.*;
public class ad_te01 {

	public static void main (String[] args) throws IOException {
		
		File ficheroE = new File ("C:\\Users\\Mikel\\Documents\\DAM\\AD\\src\\ad_te01\\fichero_entrada.txt");
		File ficheroS = new File ("C:\\Users\\Mikel\\Documents\\DAM\\AD\\src\\ad_te01\\fichero_salida.txt");
		FileReader ficE = new FileReader(ficheroE);
		FileWriter ficS = new FileWriter(ficheroS);
		
		int i;
		
		while ((i = ficE.read()) != -1)
				//System.out.print((char) i);
			ficS.write((char) i);
		ficE.close();
		ficS.close();
	}
}
