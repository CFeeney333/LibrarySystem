package utilities;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LoadAndSave {
    public static <T> void save(String filename, ArrayList<T> data) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(filename));
        out.writeObject(data);
        out.close();
    }

    public static <T> void saveObject(String filename, T object) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(filename));
        out.writeObject(object);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> load(String filename) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(filename));
        ArrayList<T> data = (ArrayList<T>) is.readObject();
        is.close();
        return data;
    }

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
