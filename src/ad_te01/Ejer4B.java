package ad_te01;
import java.io.*;
import java.util.Scanner;

public class Ejer4B {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar DNI del personaje
        System.out.print("Introduzca el DNI (con letra) del personaje para control de peso: ");
        String dniBuscado = scanner.nextLine().trim();  // DNI del personaje que se busca

        // Solicitar peso actual
        System.out.print("Introduzca su peso actual: ");
        int nuevoPeso = Integer.parseInt(scanner.nextLine().trim());  // Nuevo peso

        // Acceso al archivo aleatorio
        try (RandomAccessFile file = new RandomAccessFile("MarvelAleatorio.dat", "rw")) {
            boolean encontrado = false;
            long posicion; 
            
            while (file.getFilePointer() < file.length()) {
                
                int id = file.readInt();

                
                String dni = leerCadena(file, 9);

                
                String nombre = leerCadena(file, 10);

                
                leerCadena(file, 20);  

                
                leerCadena(file, 10);  

                /
                int pesoActual = file.readInt();
                file.readInt(); 

                if (dni.equals(dniBuscado)) {
                    encontrado = true;
                    // Calculamos el cambio de peso
                    int cambioPeso = nuevoPeso - pesoActual;
                    System.out.println("Personaje encontrado: " + nombre);
                    if (cambioPeso > 0) {
                        System.out.println(nombre + " ha engordado " + cambioPeso + " kilos.");
                    } else if (cambioPeso < 0) {
                        System.out.println(nombre + " ha adelgazado " + Math.abs(cambioPeso) + " kilos.");
                    } else {
                        System.out.println(nombre + " se mantiene en su peso.");
                    }

                    // Volvemos a la posición del peso para modificarlo
                    posicion = file.getFilePointer() - 8;  
                    file.seek(posicion);
                    // Actualizamos el peso
                    file.writeInt(nuevoPeso);  

                    break; 
                }
            }

            if (!encontrado) {
                System.out.println("Error: El personaje con DNI " + dniBuscado + " no existe.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); 
        }
    }

    // Método para leer una cadena de longitud fija desde un archivo
    private static String leerCadena(RandomAccessFile file, int longitud) throws IOException {
        String cadena = "";
        for (int i = 0; i < longitud; i++) {
        	// Concatenamos los caracteres leidos
            cadena += file.readChar();  
        }
        return cadena.trim();
    }
}
