package com.bilginyuksel.kafkalogger.model;

import java.io.Serializable;
import java.util.Date;

public class KafkaLog implements Serializable {

    private String type;
    private Integer version;
    private LogPost message;

    public class LogPost implements Serializable{
        private Integer id;
        private Post post;
        private Date viewed_time;
        private User viewed_by;

        public LogPost(){}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Post getPost() {
            return post;
        }

        public void setPost(Post post) {
            this.post = post;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Date getViewed_time() {
            return viewed_time;
        }

        public void setViewed_time(Date viewed_time) {
            this.viewed_time = viewed_time;
        }

        public User getViewed_by() {
            return viewed_by;
        }

        public void setViewed_by(User viewed_by) {
            this.viewed_by = viewed_by;
        }

        @Override
        public String toString() {
            return "LogPost{" +
                    "id=" + id +
                    ", agenda_post=" + post +
                    ", viewed_time=" + viewed_time +
                    ", viewed_by=" + viewed_by +
                    '}';
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LogPost getMessage() {
        return message;
    }

    public void setMessage(LogPost message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "KafkaLog{" +
                "type='" + type + '\'' +
                ", version=" + version +
                ", message=" + message +
                '}';
    }
}
