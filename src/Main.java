import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static int suma;
    private static int resta;
    private static int mul;
    private static int div;
    private static int resto;



    public static void main(String[] args) throws IOException {
        leerArchivo();
    }

    private static void leerArchivo() {
        String nombreFichero = "/home/armando/IdeaProjects/Automata Proyecto/src/nota.txt";
        //Declarar una variable FileReader
        FileReader fr = null;
        try {
            //Abrir el fichero indicado en la variable nombreFichero
            fr = new FileReader(nombreFichero);
            //Leer el primer carácter
            //Se debe almacenar en una variable de tipo int
            int caract = fr.read();
            //Se recorre el fichero hasta encontrar el carácter -1
            //   que marca el final del fichero
            while(caract != -1) {
                //Mostrar en pantalla el carácter leído convertido a char
                switch ((char)caract){
                    case '+':
                        suma++;
                        break;
                    case '-':
                        resta++;
                        break;
                    case '*':
                        mul++;
                        break;
                    case '/':
                        div++;
                        break;
                    case '%':
                        resto++;
                        break;
                }
//                System.out.print((char)caract);
                //Leer el siguiente carácter
                caract = fr.read();
            }
            System.out.println("Simbolos de suma existen:" + suma);
            System.out.println("Simbolos de resta existen:" + resta);
            System.out.println("Simbolos de multiplicacion existen:" + mul);
            System.out.println("Simbolos de division existen:" + div);
            System.out.println("Simbolos de resto existen:" + resto);
        }
        catch (FileNotFoundException e) {
            //Operaciones en caso de no encontrar el fichero
            System.out.println("Error: Fichero no encontrado");
            //Mostrar el error producido por la excepción
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            //Operaciones en caso de error general
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
        finally {
            //Operaciones que se harán en cualquier caso. Si hay error o no.
            try {
                //Cerrar el fichero si se ha abierto
                if(fr != null)
                    fr.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    }


}
