package com.example.commithealth.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 5, nullable = false)
    private String studentId;

    @Column(length = 4, nullable = false)
    private String name;

    @Column(length = 4, nullable = false)
    private Integer height;

    @Column(length = 4, nullable = false)
    private Integer weight;

    @Builder
    public User(String accountId, String password, String email, String studentId, String name, Integer height, Integer weight) {
        this.accountId = accountId;
        this.password = password;
        this.email = email;
        this.studentId = studentId;
        this.name = name;
    }
}
