package com.sproject.studentsdb.Model;

public class Student {
    private int id;
    private String faculty;
    private String surname;
    private String firstName;
    private Double averageScore;

    public Student(int id, String faculty, String surname, String firstName, Double averageScore) {
        this.id = id;
        this.faculty = faculty;
        this.surname = surname;
        this.firstName = firstName;
        this.averageScore = averageScore;
    }

    public Student(String faculty, String surname, String firstName, Double averageScore) {
        this.faculty = faculty;
        this.surname = surname;
        this.firstName = firstName;
        this.averageScore = averageScore;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }
}
