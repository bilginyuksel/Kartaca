package com.bilginyuksel.kafkalogger.service;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileServiceImpl implements IFileService {

    private final static String baseFilePath = "log\\";


    // Creates file if it is not exists.
    public boolean createFileIfNotExists(String path) throws IOException {
        File file = new File(baseFilePath + path);
        return file.createNewFile();
    }

    /*
    * Object writing is not working because of inner class serialization.
    * If you want to run this make inner class LogPost external and serializable.
    * After that you can run this method.
    * */
    @Override
    public void writeObject(String path, Object object) throws IOException {
        createFileIfNotExists(path);
        FileOutputStream fileOutputStream = new FileOutputStream(baseFilePath + path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
    }

    @Override
    public void writeString(String path, String message) throws IOException {
        path+=".txt";
        createFileIfNotExists(path);
        // For better performance use buffered writer
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(baseFilePath + path, true));
        bufferedWriter.write(message);

        // After writing specific file for a user.
        // Write data to general file which is ordered beginning to end.
        writeToGeneralLogFile(bufferedWriter, message);
        bufferedWriter.close();
    }

    private void writeToGeneralLogFile(BufferedWriter bufferedWriter, String data) throws IOException {
        bufferedWriter.write(data);
        bufferedWriter.close();
    }


}
