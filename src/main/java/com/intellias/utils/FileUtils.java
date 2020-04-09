package com.intellias.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    private FileUtils() {
    }

    public static void typeFileLineByLine(String filePath) {
        Path path = Paths.get(filePath);
        try (Stream<String> stream = Files.lines(path)) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
