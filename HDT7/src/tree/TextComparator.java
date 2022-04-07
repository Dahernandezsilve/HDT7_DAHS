package tree;

import java.util.Comparator;

/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #7
 *
 * Entorno: Generar un diccionario que permita la traduccion de palabras mediante Binary Search Trees.
 * Clase: TextComparator
 * Proposito: Comparar cadenas de texto.
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 */
public class TextComparator<K> implements Comparator<K> {

    @Override
    public int compare(K o1, K o2) {
        String p1 = o1.toString();
        String p2 = o2.toString();
        return p1.compareTo(p2);
    }

}
