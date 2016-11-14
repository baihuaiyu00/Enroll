package com.csxupt.cal.entity;

/**
 * Created by Admin on 2016/9/1.
 */
public class Student {

    private int stu_id;
    private String stu_name;
    private String stu_num;
    private String sex;
    private String major;
    private String tel;
    private String email;
    private String choice;
    private String self_introd;

    public int getId() {
        return stu_id;
    }

    public void setId(int id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getSelf_introd() {
        return self_introd;
    }

    public void setSelf_introd(String self_introd) {
        this.self_introd = self_introd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", choice='" + choice + '\'' +
                ", self_introd='" + self_introd + '\'' +
                '}';
    }
}
