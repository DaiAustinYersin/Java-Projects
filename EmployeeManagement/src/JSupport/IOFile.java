/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSupport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Admin
 */
public class IOFile {
    public static Object readObject(String path) throws IOException, ClassNotFoundException{
        Object obj;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            obj = ois.readObject();
        }
        return obj;
    }
    
    public static void writeObject(String path, Object obj) throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
            oos.flush();
        }
    }
}
