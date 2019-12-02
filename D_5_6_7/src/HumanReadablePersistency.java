import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * The type Human readable persistency.
 */
//Tom Cybart 17469

public class HumanReadablePersistency implements Persistency {
    @Override
    public void save(Zettelkasten zk, String filename) throws IOException {
        OutputStreamWriter output = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(filename)));

        for (Medium medium : zk) {
            output.write(medium.calculateRepresentation());
        }

        output.close();
    }

    @Override
    public Zettelkasten load(String filename) {
        throw new UnsupportedOperationException();
    }
}