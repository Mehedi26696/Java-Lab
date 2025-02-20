

//  (a) Suppose Language is a class that is inherited by three classes namely Bangla, English, and Arabic. Bangla class is further inherited by two classes: Cholti and Shadhu.
//      For the sake of simplicity, assume that each of these classes has only a single constructor which takes a string as parameter and sets it to a local variable.


//      Write a generic class named AnyLang that works on only types of objects of Language class or any of its subclasses. AnyLang has only a single data structure 
//      which is an array of the object. In its constructor, it takes an array of objects as a parameter and assigns it to the local array reference variable. 
//      In another class called Demo, in the main function, create two objects of AnyLang class with Language and Bangla classes, respectively.





class Language {
    String language;
    Language(String language) {
        this.language = language;
    }
}

class Bangla extends Language {
    Bangla(String language) {
        super(language);
    }
}

class English extends Language {
    English(String language) {
        super(language);
    }
}

class Arabic extends Language {
    Arabic(String language) {
        super(language);
    }
}

class Cholti extends Bangla {
    Cholti(String language) {
        super(language);
    }
}

class Shadhu extends Bangla {
    Shadhu(String language) {
        super(language);
    }
}

class AnyLang<T extends Language> {
    T[] arr;
    AnyLang(T[] arr) {
        this.arr = arr;
    }
}

public class Demo {
    public static void main(String[] args) {
        Language[] lang = new Language[2];
        lang[0] = new Bangla("Bangla");
        lang[1] = new English("English");

        AnyLang<Language> obj1 = new AnyLang<>(lang);

        Bangla[] bangla = new Bangla[2];
        bangla[0] = new Cholti("Cholti");
        bangla[1] = new Shadhu("Shadhu");

        AnyLang<Bangla> obj2 = new AnyLang<>(bangla);

        for(int i = 0; i < obj1.arr.length; i++) {
            System.out.println(obj1.arr[i].language);
        }
        
        for(int i = 0; i < obj2.arr.length; i++) {
            System.out.println(obj2.arr[i].language);
        }

    }
}