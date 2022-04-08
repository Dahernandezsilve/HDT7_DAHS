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
        int election;
        int electionLanguage;
        boolean exit = false;
        String find;
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
            election = s.nextInt();
            s.nextLine();

            //Decision
            switch (election){
                case 1:
                    //Ingreso de palabras
                    System.out.println("\nEntendido. Por favor, ingrese la palabra en espaniol: ");
                    spanish = s.nextLine();
                    System.out.println("\nAhora, ingrese su traduccion al ingles: ");
                    english = s.nextLine();
                    System.out.println("\nFinalmente, su traduccion al frances: ");
                    french = s.nextLine();
                    c.insertWordInTrees(spanish,english,french);
                    cadena = spanish.trim() + "," + english.trim() + "," + french.trim();
                    a.writer(cadena,"diccionario.txt");
                    System.out.println("\nNueva palabra insertada con exito!\n");
                    break;

                case 2:
                    //Editar palabras
                    System.out.println("\nIngrese la palabra que desea modificar en espaniol: ");
                    find = s.nextLine();
                    System.out.println("\nIngrese la palabra que desea colocar en el lugar de la seleccionada (en espaniol): ");
                    spanish = s.nextLine();
                    System.out.println("\nIngrese la palabra que desea colocar en el lugar de la seleccionada (en ingles): ");
                    english = s.nextLine();
                    System.out.println("\nIngrese la palabra que desea colocar en el lugar de la seleccionada (en frances): ");
                    french = s.nextLine();
                    if (c.editeWordInTree(find, spanish, english, french)){
                        System.out.println("\nFelicidades! Su palabra ha sido editada con exito!\n");
                    } else {
                        System.out.println("\nLo siento, no se encontro su palabra!\n");
                    }

                    break;

                case 3:
                    //Eliminar palabras
                    System.out.println("\nPor favor, ingrese la palabra que desea eliminar en espaniol: ");
                    find = s.nextLine();
                    if (c.deleteWordInTree(find)){
                        System.out.println("\nSe elimino correctamente su palabra!\n");
                    } else {
                        System.out.println("\nNo se encontro la palabra :(\n");
                    }
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
