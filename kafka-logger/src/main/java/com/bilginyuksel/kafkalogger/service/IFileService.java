package com.bilginyuksel.kafkalogger.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface IFileService {
    void writeObject(String path, Object object) throws IOException;
    void writeString(String path, String message) throws IOException;
}
