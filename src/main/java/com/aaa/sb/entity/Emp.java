package com.aaa.sb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * className:Emp
 * discription:
 * author:qcm
 * createTime:2018-11-23 11:13
 */
public class Emp implements Serializable{
    private Integer empNo;
    private String ename;
    private String job;
    private Double salary;
    private Date hireDate;


    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

}
