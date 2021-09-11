package com.bo.mower.lawnmover.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class DataReaderUtils {

    /**
     * Get data from file
     *
     * @param filename - input data file name
     * @return - file content in string separated by \n
     * @throws IOException
     */
    public static String getDataFromFile(String filename) throws IOException {

        String fileContent;

        try {
            File file = ResourceUtils.getFile("classpath:" + filename);
            Path path = file.toPath();
            Stream<String> lines = Files.lines(path);
            fileContent = lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new IOException("Error of reading input file");
        }

        if (StringUtils.isBlank(fileContent)) {
            log.warn("[MoverService][getDataFromFile] Nothing found in given file");
            return "";
        }

        return fileContent;
    }

    /**
     * Get data from DB
     * @return
     * @throws IOException
     */
    public static String getDataFromDB() throws IOException {
        return null;
    }
}
