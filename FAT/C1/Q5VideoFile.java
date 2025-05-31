package C1;

public class Q5VideoFile {
    private String mediaType;
    private double fileSize; // in MB

    public Q5VideoFile(double fileSize) {
        this.mediaType = "Video";
        if (fileSize > 0) {
            this.fileSize = fileSize;
        } else {
            System.out.println("Error: Invalid file size for Video file (must be > 0 MB)");
            this.fileSize = 0;
        }
    }

    public void displayDetails() {
        if (fileSize > 0) {
            System.out.println("Media Type: " + mediaType);
            System.out.println("File Size: " + fileSize + " MB");
        }
    }
}