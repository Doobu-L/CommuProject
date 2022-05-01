package com.ks.community.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Base implements Serializable {

    private static final long serialVersionUID = 3490560350813895125L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false, insertable=false, columnDefinition = "INT(11) unsigned")
    private Long id;

    @Column(name="del_yn")
    private String delYn;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name ="create_timestamp")
    private Timestamp createTimestamp;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name="update_timestamp")
    private Timestamp updateTimestamp;

    @PrePersist
    protected void onCreate() {
        this.createTimestamp = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateTimestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
