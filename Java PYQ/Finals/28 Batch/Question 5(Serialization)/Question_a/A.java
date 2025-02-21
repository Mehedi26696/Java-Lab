



// (a) What is the usefulness of the Serializable interface in Java I/O? Explain with an example,


// Answer: The Serializable interface is used to serialize objects. Serialization is the process of converting an object into
//         a stream of bytes in order to store the object or transmit it to memory, a database, or a file. Its main purpose is to save the
//         state of an object in order to be able to recreate it when needed. The reverse process is called deserialization.
//         The Serializable interface has no methods or fields and serves only to identify the semantics of being serializable.
//         The ObjectOutputStream class contains writeObject() method for serializing an Object and the ObjectInputStream class
//         contains readObject() method for deserializing an object.
//         The Serializable interface is used to mark Java classes so that objects of these classes may get certain capability.
//         The Java class which implements the Serializable interface is marked as serializable.


//         Example:

import java.io.*;

class Student implements Serializable {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class A {
    public static void main(String[] args) {
        try {
            Student s1 = new Student(211, "Mehedi");

            // Serialization
            FileOutputStream fout = new FileOutputStream("f.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(s1);
            out.flush();
            out.close();
            fout.close();

            System.out.println("Serialization successful");

            // Deserialization
            FileInputStream fin = new FileInputStream("f.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            Student s2 = (Student) in.readObject();
            in.close();
            fin.close();

            System.out.println("Deserialization successful");
            System.out.println("Deserialized Student: " + s2);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}