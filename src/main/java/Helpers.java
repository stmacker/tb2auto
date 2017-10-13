import org.sikuli.script.Finder;
import org.sikuli.script.Match;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helpers {

public static boolean findImage(File screenshot, String imgPath) throws IOException {
    BufferedImage img = ImageIO.read(screenshot);

    Match m;
    Finder f = new Finder(img);

    f.find(imgPath);
    if (f.hasNext()) {
        m = f.next();
        return true;
    }
    return false;
}
}
