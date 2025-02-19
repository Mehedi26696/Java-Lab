
// (d) From the code snippet given below, write down the relationships (for example, inheritance, composition) among the classes/interfaces FileReader,
//     TextFileReader, CSVFileReader, and ExcelFileReader. Briefly explain your reasoning.

//     code:

// class FileReaderFactory {
//     public FileReader createReader(String fileType) {

//         if (fileType.equals("text")) {
//             return new TextFileReader();
//         } else if (fileType.equals("csv")) {
//             return new CSVFileReader();
//         } else if (fileType.equals("excel")) {
//             return new ExcelFileReader();
//         } else {
//             throw new IllegalArgumentException("Unsupported file type");
//         }
//     }
// }

// Answer:

// 1. Inheritance (Generalization-Specialization Relationship):
// The method createReader(String fileType) in FileReaderFactory returns an object of type FileReader, but it instantiates TextFileReader, CSVFileReader, and ExcelFileReader.
// This implies that TextFileReader, CSVFileReader, and ExcelFileReader are subclasses of FileReader, establishing an inheritance relationship where FileReader serves as the 
// superclass (or possibly an interface). This allows polymorphic behavior, enabling different file readers to be used interchangeably through the FileReader reference.

// 2. Factory Design Pattern:
// FileReaderFactory encapsulates the object creation logic based on the file type. This follows the Factory Method Pattern, promoting loose coupling by abstracting the instantiation 
// of TextFileReader, CSVFileReader, and ExcelFileReader from client code. This design pattern helps in managing and maintaining the code by centralizing the creation logic.
 