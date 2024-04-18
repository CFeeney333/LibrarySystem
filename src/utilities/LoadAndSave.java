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
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("../data/" + filename));
        out.writeObject(data);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Object> load(String filename) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("../data/" + filename));
        ArrayList<Object> data = (ArrayList<Object>) is.readObject();
        is.close();
        return data;
    }
}
