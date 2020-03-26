package com.bilginyuksel.kafkalogger.serializer;

import com.bilginyuksel.kafkalogger.model.AgendaLog;
import org.springframework.stereotype.Service;

@Service
public interface IAgendaSerializer {
    AgendaLog deserialize(String content);
}
