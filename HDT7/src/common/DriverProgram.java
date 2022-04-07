package common;

import java.util.Scanner;

/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #7
 *
 * Entorno: Generar un diccionario que permita la traduccion de palabras mediante Binary Search Trees.
 * Clase: DriverProgram
 * Proposito: Clase main.
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 */
public class DriverProgram {

    /**
     * Clase principal encargada del funcionamiento del programa y mostrar la vista con el usuario.
     * @param args Parametro requerido.
     */
    public static void main (String[] args){
        //Instancia de clases
        Scanner s = new Scanner(System.in);
        Controller c = new Controller();
        Archive a = new Archive();

        //Lectura e ingreso de datos.
        String diccionario = a.lector("diccionario.txt");
        c.addDictionaryToTree(diccionario);

        //Variables requeridas por el sistema
        int eleccion;
        boolean exit = false;
        String spanish;
        String english;
        String french;
        String cadena;

        //Sistema
        System.out.println("""
                ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
                ─██████████████───██████████─██████████████─██████──────────██████─██████──██████─██████████████─██████──────────██████─██████████─████████████───██████████████─
                ─██░░░░░░░░░░██───██░░░░░░██─██░░░░░░░░░░██─██░░██████████──██░░██─██░░██──██░░██─██░░░░░░░░░░██─██░░██████████──██░░██─██░░░░░░██─██░░░░░░░░████─██░░░░░░░░░░██─
                ─██░░██████░░██───████░░████─██░░██████████─██░░░░░░░░░░██──██░░██─██░░██──██░░██─██░░██████████─██░░░░░░░░░░██──██░░██─████░░████─██░░████░░░░██─██░░██████░░██─
                ─██░░██──██░░██─────██░░██───██░░██─────────██░░██████░░██──██░░██─██░░██──██░░██─██░░██─────────██░░██████░░██──██░░██───██░░██───██░░██──██░░██─██░░██──██░░██─
                ─██░░██████░░████───██░░██───██░░██████████─██░░██──██░░██──██░░██─██░░██──██░░██─██░░██████████─██░░██──██░░██──██░░██───██░░██───██░░██──██░░██─██░░██──██░░██─
                ─██░░░░░░░░░░░░██───██░░██───██░░░░░░░░░░██─██░░██──██░░██──██░░██─██░░██──██░░██─██░░░░░░░░░░██─██░░██──██░░██──██░░██───██░░██───██░░██──██░░██─██░░██──██░░██─
                ─██░░████████░░██───██░░██───██░░██████████─██░░██──██░░██──██░░██─██░░██──██░░██─██░░██████████─██░░██──██░░██──██░░██───██░░██───██░░██──██░░██─██░░██──██░░██─
                ─██░░██────██░░██───██░░██───██░░██─────────██░░██──██░░██████░░██─██░░░░██░░░░██─██░░██─────────██░░██──██░░██████░░██───██░░██───██░░██──██░░██─██░░██──██░░██─
                ─██░░████████░░██─████░░████─██░░██████████─██░░██──██░░░░░░░░░░██─████░░░░░░████─██░░██████████─██░░██──██░░░░░░░░░░██─████░░████─██░░████░░░░██─██░░██████░░██─
                ─██░░░░░░░░░░░░██─██░░░░░░██─██░░░░░░░░░░██─██░░██──██████████░░██───████░░████───██░░░░░░░░░░██─██░░██──██████████░░██─██░░░░░░██─██░░░░░░░░████─██░░░░░░░░░░██─
                ─████████████████─██████████─██████████████─██████──────────██████─────██████─────██████████████─██████──────────██████─██████████─████████████───██████████████─
                ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
                """);
        System.out.println("Cargando datos anteriores...");
        System.out.println("Listo! Datos cargados correctamente.");
        System.out.println("Estas son las palabras que actualmente, el diccionario puede traducir al español.\n");
        System.out.println(c.showDictionary());

        //Menu
        while (!exit){
            System.out.println("Ahora, seleccione lo que desea realizar con el diccionario ingresando un numero: ");
            System.out.println("[1]. Ingresar una nueva palabra.");
            System.out.println("[2]. Editar una palabra.");
            System.out.println("[3]. Eliminar una palabra.");
            System.out.println("[4]. Mostrar palabras.");
            System.out.println("[5]. Cerrar el diccionario.");
            eleccion = s.nextInt();
            s.nextLine();

            //Decision
            switch (eleccion){
                case 1:
                    //Ingreso de palabras
                    System.out.println("\nEntendido. Por favor, ingrese la palabra en espaniol: ");
                    spanish = s.nextLine();
                    System.out.println("\nAhora, ingrese su traduccion al ingles: ");
                    english = s.nextLine();
                    System.out.println("\nFinalmente, su traduccion al espaniol: ");
                    french = s.nextLine();
                    c.insertWordInTrees(spanish,english,french);
                    cadena = spanish.trim() + "," + english.trim() + "," + french.trim();
                    a.writer(cadena,"diccionario.txt");
                    System.out.println("\nNueva palabra insertada con exito!\n");
                    break;

                case 2:
                    //Editar palabras
                    break;

                case 3:
                    //Eliminar palabras
                    break;

                case 4:
                    //Mostras palabras
                    System.out.println("\n" + c.showDictionary() + "\n");
                    break;

                case 5:
                    //Salir
                    System.out.println("Cerrando el diccionario...");
                    exit = true;
                    break;
            }
        }
    }

}
