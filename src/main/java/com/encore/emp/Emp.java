package com.encore.emp;

public class Emp {
    private int eno; //pk
    private String ename;
    private String etel;
    private int depno;
    private Grade grade; //관리자, 일반 사원, 퇴사자
    private Hgrade hgrade;
    private String hiredate;
    private String retiredate;

    //getter &setter


    public Hgrade getHgrade() {
        return hgrade;
    }

    public void setHgrade(Hgrade hgrade) {
        this.hgrade = hgrade;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }

    public int getDepno() {
        return depno;
    }

    public void setDepno(int depno) {
        this.depno = depno;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getRetiredate() {
        return retiredate;
    }

    public void setRetiredate(String retiredate) {
        this.retiredate = retiredate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", etel='" + etel + '\'' +
                ", depno=" + depno +
                ", grade=" + grade +
                ", hgrade=" + hgrade +
                ", hiredate='" + hiredate + '\'' +
                ", retiredate='" + retiredate + '\'' +
                '}';
    }
}
