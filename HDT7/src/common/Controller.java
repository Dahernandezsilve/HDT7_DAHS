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

    Archive a = new Archive();
    //Arboles binarios de búsqueda.
    BinarySearchTree<String,String> englishTree = new BinarySearchTree<String,String>(new TextComparator<String>());
    BinarySearchTree<String,String> frenchTree = new BinarySearchTree<String,String>(new TextComparator<String>());

    ArrayList<String> diccionario = new ArrayList<>();

    /**
     * Añadir traducciones a los diccionarios.
     * @param diccionario Cadena de texto obtenida por la clase de archivo.
     */
    public void addDictionaryToTree(String diccionario){
        String[] renglon = diccionario.split("\n");
        for (String traducciones: renglon){
            String[] palabras = traducciones.split(",");
            if (!palabras[0].equals(" ") && !palabras[1].equals(" ")){
                englishTree.insert(palabras[0].toLowerCase().trim(), palabras[1].toLowerCase().trim());
            }
            if (!palabras[0].equals(" ") && !palabras[1].equals(" ")){
                frenchTree.insert(palabras[2].toLowerCase().trim(), palabras[1].toLowerCase().trim());
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
     * Se encarga de ingresar valores al diccionario (listado).
     * @param cadena
     */
    public void writerInDictionary(String cadena){
        String[] elementos = cadena.split("\n");
        for (String elemento: elementos){
            diccionario.add(elemento);
        }
    }

    /**
     * Muestra lo que el diccionario contiene actualmente (listado).
     * @return
     */
    public String updatedDictionary(){
        String cadena = "";
        for (String line: diccionario){
            cadena += line + "\n";
        }
        return cadena;
    }
    /**
     * Método empleado para insertar nuevas palabras a los arboles.
     * @param spanish Palabra en espaniol.
     * @param english Palabra en ingles.
     * @param french Palabra en frances.
     */
    public String insertWordInTrees(String spanish, String english, String french){
        englishTree.insert(english.toLowerCase().trim(),spanish.toLowerCase().trim());
        frenchTree.insert(french.toLowerCase().trim(),spanish.toLowerCase().trim());
        String cadena = english.toLowerCase().trim() + "," + spanish.toLowerCase().trim() + "," + french.toLowerCase().trim();
        diccionario.add(cadena);
        String result = "funciona";
        String update = updatedDictionary();
        diccionario.clear();
        writerInDictionary(update);
        a.writer(update, "diccionario.txt");
        return result;
    }

    /**
     * Metodo encargado de editar una palabra en los arboles
     * @param find Palabra a editar.
     * @param spanish Palabra en espaniol nueva.
     * @param english Palabra en ingles nueva.
     * @param french Palabra en frances nueva.
     * @return Palabra encontrada o no encontrada.
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
                deleteWordInTree(line[1]);
            }
        }
        for (String wordF: dataFrench){
            line = wordF.split("=");
            if (line[1].equals(find)){
                result = true;
                deleteWordInTree(line[1]);
            }
        }
        if (result){
            insertWordInTrees(spanish, english, french);
        }

        String[] lined;
        boolean bandera = false;
        int indexF = 0;
        for (int i=0; i<diccionario.size(); i++){
            lined = diccionario.get(i).split(",");
            if (lined[1].equals(find)){
                bandera = true;
                indexF = i;
            }
        }

        String cadena = english.toLowerCase().trim() + "," + spanish.toLowerCase().trim() + "," + french.toLowerCase().trim();
        if (bandera){
            diccionario.remove(indexF);
            diccionario.add(cadena);
        }

        String update = updatedDictionary();
        diccionario.clear();
        writerInDictionary(update);
        a.writer(update, "diccionario.txt");

        return result;
    }

    /**
     * Método empleado para eliminar una palabra indicada por los usuarios, en el arbol.
     * @param find Palabra buscada.
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

        String[] lined;
        boolean bandera=false;
        int eliminateIndex = 0;
        for (int i=0; i<diccionario.size(); i++){
            lined = diccionario.get(i).split(",");
            if (lined[1].equals(find)){
                bandera=true;
                eliminateIndex = i;
            }
        }
        if (bandera){
            diccionario.remove(eliminateIndex);
        }

        String update = updatedDictionary();
        diccionario.clear();
        writerInDictionary(update);
        a.writer(update, "diccionario.txt");

        return result;

    }

    /**
     * Metodo encargado de traducir oraciones al espaniol.
     * @param sentence Oracion a traducir.
     * @return Oracion traducida.
     */
    public String translateSentenceToSpanish(String sentence){

        sentence = sentence.replaceAll("[.,;:]","");
        sentence = sentence.replaceAll("\n","");
        sentence = sentence.toLowerCase();

        String[] words = sentence.split(" ");
        ArrayList<String> dataEnglish = englishTree.getElements();
        ArrayList<String> dataFrench = frenchTree.getElements();
        String[] line;
        String finalSentence = "";
        boolean founded = false;

        for (String word: words){

            for (String wordE: dataEnglish) {
                line = wordE.split("=");
                if (line[0].equals(word)) {
                    founded = true;
                    finalSentence += line[1] + " ";
                }
            }


            for (String wordF: dataFrench) {
                line = wordF.split("=");
                if (line[0].equals(word)) {
                    founded = true;
                    finalSentence += line[1] + " ";
                }
            }

            if (!founded){
                finalSentence += "*" + word + "* ";
            }

            founded = false;
        }

        return finalSentence;
    }

}

