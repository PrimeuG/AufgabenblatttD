import java.io.*;

/**
 * The type Binary persistency.
 */
//Tom Cybart 17469

public class BinaryPersistency implements Persistency {

    @Override
    public void save(Zettelkasten zk, String filename) throws IOException {
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(zk);
        output.close();
    }

    @Override
    public Zettelkasten load(String filename) throws IOException, ClassNotFoundException {
        ObjectInput input = new ObjectInputStream(new FileInputStream(filename));
        Zettelkasten zk = (Zettelkasten) input.readObject();
        input.close();
        return zk;
    }
}
