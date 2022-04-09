package tests;

import common.Controller;
import org.junit.jupiter.api.Test;
import tree.BinarySearchTree;
import tree.TextComparator;

import static org.junit.jupiter.api.Assertions.*;

/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #7
 *
 * Entorno: Generar un diccionario que permita la traduccion de palabras mediante Binary Search Trees.
 * Clase: ControllerTest
 * Proposito: Crear JUnits.
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 */
class ControllerTest {

    Controller c = new Controller();


    @Test
    /**
     * Metodo de prueba de la inserción de palabras en los arboles
     */
    void insertWordInTrees() {
        assertEquals("funciona", c.insertWordInTrees("hola","hi", "salut"));
    }

    @Test
    /**
     * Metodo busqueda de los arboles.
     */
    void findTest(){
        BinarySearchTree<String,String> englishTree = new BinarySearchTree<String,String>(new TextComparator<String>());
        englishTree.insert("hi","hola");
        assertEquals("hola", englishTree.find("hi"));
    }

    @Test
    /**
     * Metodo de insercion de los arboles.
     */
    void insertTests(){
        BinarySearchTree<String,String> englishTree = new BinarySearchTree<String,String>(new TextComparator<String>());
        englishTree.insert("hi","hola");
    }
}