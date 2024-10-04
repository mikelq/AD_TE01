package ad_te01;

import java.io.*;

public class Ejer4A {
	public static void main (String[] args) throws IOException {
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		
		File fichero = new File("MarvelAleatorio.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			
		//inicializamos el buffer	 	
        StringBuffer buffer = null;
        int n = noms.length; 

        //recorremos tantas veces los arrays, como nombres hay. Escrbiendo cada dato.
        for (int i = 0; i < n; i++) {
            file.writeInt(ids[i]);  

            buffer = new StringBuffer(dnis[i]); 
            buffer.setLength(9);  
            file.writeChars(buffer.toString());  

            buffer = new StringBuffer(noms[i]); 
            buffer.setLength(10);  
            file.writeChars(buffer.toString());  

            buffer = new StringBuffer(identidades[i]); 
            buffer.setLength(20);  
            file.writeChars(buffer.toString());  

            buffer = new StringBuffer(tipos[i]);
            buffer.setLength(10);  
            file.writeChars(buffer.toString());  

            file.writeInt(pesos[i]);  
        }

        //cerramos el archivo file e indicamos que se han cargado los datos
        file.close();
        System.out.println("datos cargados correctamente");	
			
	}
}
