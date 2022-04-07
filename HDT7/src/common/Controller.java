package common;

import tree.BinarySearchTree;
import tree.TextComparator;

import java.util.ArrayList;

public class Controller {
    BinarySearchTree<String,String> englishTree = new BinarySearchTree<String,String>(new TextComparator<String>());
    BinarySearchTree<String,String> frenchTree = new BinarySearchTree<String,String>(new TextComparator<String>());

    /**
     * Añadir traducciones a los diccionarios.
     * @param diccionario Cadena de texto obtenida por la clase de lectura.
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


    public String showDictionary(){
        String fin;
        ArrayList<String> data = englishTree.getElements();
        String infoI = "INGLES: ";
        for (String palabra: data){
            infoI += palabra + " ";
        }

        ArrayList<String> data1 = frenchTree.getElements();
        String infoF = "FRANCES: ";
        for (String palabra: data1){
            infoF += palabra + " ";
        }
        fin = infoI + infoF;
        return fin;
    }

}
