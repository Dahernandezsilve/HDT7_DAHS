package common;

import tree.BinarySearchTree;
import tree.TextComparator;

import java.util.ArrayList;

/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #7
 *
 * Entorno: Generar un diccionario que permita la traduccion de palabras mediante Binary Search Trees.
 * Clase: Controller
 * Proposito: Crear y manipular los Binary Search Trees.
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 */
public class Controller {

    //Arboles binarios de búsqueda.
    BinarySearchTree<String,String> englishTree = new BinarySearchTree<String,String>(new TextComparator<String>());
    BinarySearchTree<String,String> frenchTree = new BinarySearchTree<String,String>(new TextComparator<String>());

    /**
     * Añadir traducciones a los diccionarios.
     * @param diccionario Cadena de texto obtenida por la clase de archivo.
     */
    public void addDictionaryToTree(String diccionario){
        String[] renglon = diccionario.split("\n");
        for (String traducciones: renglon){
            String[] palabras = traducciones.split(",");
            if (!palabras[0].equals(" ") && !palabras[1].equals(" ")){
                englishTree.insert(palabras[0].toLowerCase(), palabras[1].toLowerCase());
            }
            if (!palabras[0].equals(" ") && !palabras[1].equals(" ")){
                frenchTree.insert(palabras[2].toLowerCase(), palabras[1].toLowerCase());
            }
        }
    }

    /**
     * Mostrar las palabras en español que reconoce cada diccionario.
     * @return Cadena con las palabras.
     */
    public String showDictionary(){
        String fin;
        ArrayList<String> data = englishTree.getElements();
        String infoI = "EN INGLES:\n";
        for (String palabra: data){
            infoI += "- " + palabra + "\n";
        }

        ArrayList<String> data1 = frenchTree.getElements();
        String infoF = "EN FRANCES:\n";
        for (String palabra: data1){
            infoF += "- " + palabra + "\n";
        }
        fin = infoI + "\n" + infoF;
        return fin;
    }

    /**
     * Método empleado para insertar nuevas palabras a los arboles.
     * @param spanish Palabra en espaniol.
     * @param english Palabra en ingles.
     * @param french Palabra en frances.
     */
    public void insertWordInTrees(String spanish, String english, String french){
        englishTree.insert(english,spanish);
        frenchTree.insert(french,spanish);
    }

    /**
     * Metodo encargado de editar una palabra en los arboles
     * @param find Palabra a editar.
     * @param spanish Palabra en espaniol nueva.
     * @param english Palabra en ingles nueva.
     * @param french Palabra en frances nueva.
     * @return
     */
    public boolean editeWordInTree(String find, String spanish, String english, String french) {
        boolean result = false;
        ArrayList<String> dataEnglish = englishTree.getElements();
        ArrayList<String> dataFrench = frenchTree.getElements();
        String[] line;
        for (String wordE: dataEnglish){
            line = wordE.split("=");
            if (line[1].equals(find)){
                result = true;
                englishTree.delete(line[0]);
            }
        }
        for (String wordF: dataFrench){
            line = wordF.split("=");
            if (line[1].equals(find)){
                result = true;
                frenchTree.delete(line[0]);
            }
        }
        insertWordInTrees(spanish, english, french);
        return result;
    }

    /**
     * Método empleado para eliminar una palabra indicada por los usuarios, en el arbol.
     * @param find
     */
    public boolean deleteWordInTree(String find){
        boolean result = false;
        ArrayList<String> dataEnglish = englishTree.getElements();
        ArrayList<String> dataFrench = frenchTree.getElements();
        String[] line;
        for (String wordE: dataEnglish){
            line = wordE.split("=");
            if (line[1].equals(find)){
                result = true;
                englishTree.delete(line[0]);
            }
        }
        for (String wordF: dataFrench){
            line = wordF.split("=");
            if (line[1].equals(find)){
                result = true;
                frenchTree.delete(line[0]);
            }
        }
        return result;
    }

}
