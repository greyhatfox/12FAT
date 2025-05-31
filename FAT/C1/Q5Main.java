package C1;

import C1.Q5AudioFile;
import C1.Q5VideoFile;
import C1.Q5ImageFile;

public class Q5Main {
    public static void main(String[] args) {
        // Create valid media files
        Q5AudioFile audio = new Q5AudioFile(5.2);
        Q5VideoFile video = new Q5VideoFile(250.0);
        Q5ImageFile image = new Q5ImageFile(3.8);
        
        // Create invalid media file (size <= 0)
        Q5AudioFile invalidAudio = new Q5AudioFile(0);
        
        System.out.println("\n--- Media File Details ---");
        audio.displayDetails();
        video.displayDetails();
        image.displayDetails();
        
        System.out.println("\n--- Invalid File Test ---");
        invalidAudio.displayDetails();
    }
}