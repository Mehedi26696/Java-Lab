
// You are given the following real-life scenario. Design appropriate classes, attributes
// And methods to represent the scenario based on object-oriented principles. You do
// not need to implement the methods. Here, we are interested in evaluating on which
// classes and methods you plan to implement in your solution.

// "You are working on an operating system named OOPOS. OOPOS currently maintains three types of file systems, namely, VIDEO file, TEXT file and BINARYSYS file.
// To execute each type of file, there should be a method named execute (). To save a file, there should be a method named save (). Similarly, to delete a file, there should be a method named delete (). Delete () should be common for each type of file, meaning that,
// same method should be able to delete any type of file. Similar argument will also
// hold for save () to save any type of file in the OOPOS. But execute () should vary
// significantly. To execute (play) a VIDEO file, there should be an application named
// MP4. To execute (open) a TEXT file there should be an application named TREAD.
// Similarly, to execute (run) a BINARYSYS file, there should be a dedicated module
// Named SYSCALL to call very system related functions."

abstract class File {
    String name;
    String type;
    String content;

    File(String name, String type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }

    File[] files = new File[100];
    int fileCount = 0;

    public abstract void execute();

    public void save(File file) {

        files[fileCount] = file;
        fileCount++;

    }

    public void delete(File file) {
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                continue;
            }
            if (files[i].name.equals(name)) {
                files[i] = null;
                break;
            }
        }
    }
}

class VideoFile extends File {

    VideoFile(String name, String type, String content) {
        super(name, type, content);
    }

    public void execute() {

        System.out.println("Playing video file");
    }
}

class TextFile extends File {

    TextFile(String name, String type, String content) {
        super("text.txt", "txt", "text content");
    }

    public void execute() {
        System.out.println("Opening text file");
    }
}

class BinarySysFile extends File {
    BinarySysFile(String name, String type, String content) {
        super("binary.bin", "bin", "binary content");
    }

    public void execute() {
        System.out.println("Running binary system file");
    }
}

class Application {
    public void execute(File file) {

        file.execute();

    }
}

class Solution {
    public static void main(String[] args) {
        Application application = new Application();
        VideoFile videoFile = new VideoFile("video.mp4", "mp4", "video content");
        application.execute(videoFile);
        videoFile.save(videoFile);

        TextFile textFile = new TextFile("text.txt", "txt", "text content");
        application.execute(textFile);
        textFile.save(textFile);

        BinarySysFile binarySysFile = new BinarySysFile("binary.bin", "bin", "binary content");
        application.execute(binarySysFile);
        binarySysFile.save(binarySysFile);

        videoFile.delete(videoFile);
        textFile.delete(textFile);
        binarySysFile.delete(binarySysFile);
    }
}
