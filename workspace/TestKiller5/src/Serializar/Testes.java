package Serializar;

import java.io.*;

public class Testes {
public static void main(String[] args) {
File f = new File("meuArquivo.leo");
try {
ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f)); //A
              os.writeObject(new A("Maria")); //B
}catch(Exception e) {
       System.out.println(e.getMessage());
}
try {
ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f)); //C
       A a = (A) oi.readObject(); //D
       System.out.println(a.nome);
}catch(Exception e) {
       System.out.println(e.getMessage());
       }
    }
}
