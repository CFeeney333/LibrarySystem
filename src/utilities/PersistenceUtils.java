package utilities;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Class for managing the loading and saving of data from and to xml files
 *
 * <p>It handles the loading and saving of individuals objects or arraylists of objects</p>
 */
public class PersistenceUtils {
    /**
     * Save an arraylist of data to a file
     *
     * @param filename the file to save it to
     * @param data     the arraylist of data to save
     * @param <T>      the type of data to save
     * @throws Exception if the file cannot be found etc.
     */
    public static <T> void save(String filename, ArrayList<T> data) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(filename));
        out.writeObject(data);
        out.close();
    }

    /**
     * Save an individual object to a file
     *
     * @param filename the file to save the object to
     * @param object   the object to save
     * @param <T>      the type of data to save
     * @throws Exception if the file cannot be found etc.
     */
    public static <T> void saveObject(String filename, T object) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(filename));
        out.writeObject(object);
        out.close();
    }

    /**
     * Load an arraylist of data from a file
     *
     * @param filename the name of the file to get the data from
     * @param <T>      the type of data to cast it to
     * @return an arraylist of the data from the file
     * @throws Exception if the file cannot be found etc.
     */
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> load(String filename) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(filename));
        ArrayList<T> data = (ArrayList<T>) is.readObject();
        is.close();
        return data;
    }

    /**
     * Load an object from a file
     *
     * @param filename the name of the file to load the object from
     * @param <T>      the type of data to cast the object to
     * @return an object cast to the given type
     * @throws Exception if the file cannot be found etc.
     */
    @SuppressWarnings("unchecked")
    public static <T> Object loadObject(String filename) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(filename));
        T data = (T) is.readObject();
        is.close();
        return data;
    }
}
