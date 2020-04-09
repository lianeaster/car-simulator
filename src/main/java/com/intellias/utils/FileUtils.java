package com.intellias.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
public class FileUtils {

    private FileUtils() {
    }

    public static void typeFileLineByLine(String filePath) {
        Path path = Paths.get(filePath);
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            log.error("Can't get content from file!", e);
        }
    }
}
