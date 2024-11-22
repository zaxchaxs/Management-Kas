/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataModels;

/**
 *
 * @author Irzi Rhmtllh
 */
public class KasReport {
    public int id;
    public String nim, date, name, desc, type;
    public double income, expanse;
    public KasReport(int id, String nim, String name, String desc, String date, String type, double income, double expanse) {
        this.id = id;
        this.nim = nim;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.date = date;
        this.income = income;
        this.expanse = expanse;
    };
}
