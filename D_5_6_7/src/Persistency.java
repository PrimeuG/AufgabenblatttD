import java.io.IOException;


//Tom Cybart 17469

/**
 * The interface Persistency.
 */
public interface Persistency {
    /**
     * Save.
     *
     * @param zk       the zk
     * @param filename the filename
     * @throws IOException the io exception
     */
    public void save(Zettelkasten zk, String filename) throws IOException;

    /**
     * Load zettelkasten.
     *
     * @param filename the filename
     * @return the zettelkasten
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public Zettelkasten load(String filename) throws IOException, ClassNotFoundException;
}
