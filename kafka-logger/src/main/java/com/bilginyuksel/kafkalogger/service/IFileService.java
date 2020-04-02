package com.bilginyuksel.kafkalogger.service;

import org.springframework.stereotype.Service;

@Service
public interface IFileService {
    boolean isWritable(String file);
    void write(String path, Object context);
}
