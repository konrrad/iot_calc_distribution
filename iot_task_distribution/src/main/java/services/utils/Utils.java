package services.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;


import static java.nio.file.Files.readAllBytes;

public class Utils {
    public static String readFile(String path) {
        try {
            return new String(readAllBytes(Path.of(path)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
