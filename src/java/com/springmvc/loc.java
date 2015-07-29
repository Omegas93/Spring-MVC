package com.springmvc;


import com.sun.javafx.beans.IDProperty;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EDU-Stud
 */
@Entity
@Table(name = "location")
 public class loc {
    
    @Id
    private int ID;
    private String Name;
    
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public int getID()
    {
        return ID;
    }
    
     public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return Name;
    }
}


