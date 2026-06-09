package StructuralDesignPatterns.ProxyDesignPattern;

interface Image {
    void display();
}
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + fileName);
    }

    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
class ImageProxy implements Image {

    private RealImage realImage;
    private String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // lazy init
        }
        realImage.display();
    }
}

public class ProxyDesignPattern {

    public static void main(String[] args) {

        Image image = new ImageProxy("photo.jpg");

        image.display();  // loads + displays
        image.display();  // displays only
    }
}
