package com.example.damfinalproject;

public class UniversityListItem {
    private String universityName;
    private String facultyName;
    private String universityCity;
    private String facultyLink;
    private String facultyImageLink;
    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    public String getUniversityCity() {
        return universityCity;
    }
    public void setUniversityCity(String universityCity) {
        this.universityCity = universityCity;
    }
    public String getFacultyLink(){return facultyLink;}
    public void setFacultyLink(String facultyLink){this.facultyLink = facultyLink;}
    public String getFacultyImageLink(){return facultyImageLink;}
    public void setFacultyImageLink(String facultyImageLink){this.facultyImageLink = facultyImageLink;}
}
