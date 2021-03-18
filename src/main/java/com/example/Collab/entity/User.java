package com.example.Collab.entity;

public class User {

    private Long id;

    private String fullName;

    private String email;

    private String password;

    public User(Long id, String email, String fullName, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }


    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
