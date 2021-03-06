package tree;

/**
 * Créditos a Moises Antonio Alonso Gonzalez
 * @author MAAG
 * @param <K>
 * @param <V>
 */
public class Association <K, V>
{
    private V value;
    private K id;
    private Association<K, V> left;
    private Association<K, V> right;
    private Association<K, V> parent;

    public Association(K id, V value) {
        setId(id);
        setValue(value);
        setLeft(null);
        setRight(null);
        setParent(null);
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(V value) {
        this.value = value;
    }
    /**
     * @return the id
     */
    public K getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(K id) {
        this.id = id;
    }
    /**
     * @return the left
     */
    public Association<K, V> getLeft() {
        return left;
    }
    /**
     * @param left the left to set
     */
    public void setLeft(Association<K, V> left) {
        this.left = left;
    }
    /**
     * @return the right
     */
    public Association<K, V> getRight() {
        return right;
    }
    /**
     * @param right the right to set
     */
    public void setRight(Association<K, V> right) {
        this.right = right;
    }
    /**
     * @return the parent
     */
    public Association<K, V> getParent() {
        return parent;
    }
    /**
     * @param parent the parent to set
     */
    public void setParent(Association<K, V> parent) {
        this.parent = parent;
    }
}
