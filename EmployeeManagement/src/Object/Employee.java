/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Employee implements Serializable{
    private String employeeID, fullName, sex;
    private int age;
    private String email;
    private double salary;
    private String role;
    private String department;
    private String assess;

    public Employee() {
    }

    public Employee(String maNV, String hoTen, String gioiTinh, int tuoi, String email, double luong, String chucVu, String phongBan, String danhGia) {
        this.employeeID = maNV;
        this.fullName = hoTen;
        this.sex = gioiTinh;
        this.age = tuoi;
        this.email = email;
        this.salary = luong;
        this.role = chucVu;
        this.department = phongBan;
        this.assess = danhGia;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }
}
