package com.cg.bean;

import java.util.List;

public class SBU {
    private String sBuId;
    private String sbuName;
    private String sbuHead;
    private List<Employee> empList;
    public SBU(String sBuId, String sbuName, String sbuHead) {
        this.sBuId = sBuId;
        this.sbuName = sbuName;
        this.sbuHead = sbuHead;
    }

    public String getsBuId() {
        return sBuId;
    }

    public void setsBuId(String sBuId) {
        this.sBuId = sBuId;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public void printSbuDetailsWithList(){
        System.out.println("SBU details");
        System.out.println("-----------------------------");
        System.out.printf("sbu details=SBU [sbuCode=%s, sbuHead=%s, sbuName=%s]", sBuId, sbuHead, sbuName);
        System.out.println();
        System.out.println(" Employee details:---------------");
        System.out.println(empList);
    }

}
