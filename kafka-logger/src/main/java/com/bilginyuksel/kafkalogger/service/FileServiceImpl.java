package com.bilginyuksel.kafkalogger.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileServiceImpl implements IFileService {

    @Override
    public boolean isWritable(String file) {
        return false;
    }

    @Override
    public void write(String path, Object context) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(context);
            objectOutputStream.close();
        }catch (Exception e){
            // LOG: Error while writing object to a file.
            e.printStackTrace();
        }
    }
}
