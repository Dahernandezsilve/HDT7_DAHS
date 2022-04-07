package common;

import tree.BinarySearchTree;
import tree.TextComparator;

import java.util.ArrayList;

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
                englishTree.insert(palabras[0], palabras[1]);
            }
            if (!palabras[0].equals(" ") && !palabras[1].equals(" ")){
                frenchTree.insert(palabras[2], palabras[1]);
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

    public void insertWordInTrees(String spanish, String english, String french){
        englishTree.insert(english,spanish);
        frenchTree.insert(english,spanish);
    }
}
