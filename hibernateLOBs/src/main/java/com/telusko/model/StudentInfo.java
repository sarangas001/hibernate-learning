package com.telusko.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name="StudentInfo")
public class StudentInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    @Column(name = "SNAME")
    private String sName;

    @Column(name = "SCITY")
    private String scity;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;


    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private char[] textFile;

    public StudentInfo() {
    }

    public StudentInfo(Integer sid, String sName, String scity, byte[] image, char[] textFile) {
        this.sid = sid;
        this.sName = sName;
        this.scity = scity;
        this.image = image;
        this.textFile = textFile;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", scity='" + scity + '\'' +
                ", image=" + Arrays.toString(image) +
                ", textFile=" + Arrays.toString(textFile) +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public char[] getTextFile() {
        return textFile;
    }

    public void setTextFile(char[] textFile) {
        this.textFile = textFile;
    }
}
