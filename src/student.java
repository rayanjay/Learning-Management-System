/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jabar
 */

// Authors : Rayan Jangda, Armand Daniel Sanchez, Eldrin Preston, Ismael Moreno, Jabari Fowler
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class student {
    public String fName, lName, username, password;
    public int id;
    public double gpa = 0.0;
    public ArrayList<Character> grades = new ArrayList<>();
    public ArrayList<ArrayList<Object>> courses = new ArrayList<>();
    
    public student(){
        this.fName = "";
        this.lName = "";
        this.id = 0;
        this.username = "";
        this.password = "";
    }
    
    public student(String fName, String lName, int id){
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.username = fName;
        this.password = lName;
    }
     // to save the students information to text files for read, write, and edit
    public void saveFile(){
        try{
            File myObj = new File(fName + ".txt");
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(fName);
            myWriter.write(lName);
            myWriter.write(id);
            myWriter.write(username);
            myWriter.write(password);
            //myWriter.write(courses.get(0));
        }catch(IOException e){
            System.out.println("an error occured");
        }
    }
   
    //Calculate Letter Grade
    
    public void calcGradeLetter(){
        int grade;
        char letter;
        
        for(int i = 0; i < courses.size(); i++){
            grade = 0;
            
            for(int j = 1; j < courses.get(i).size(); j++){            
                grade += (int)courses.get(i).get(j);
            }
            
            grade /= 3;
        
            if(grade>=90)
            {
                letter='A';
            }
            else if(grade>=80 && grade<=89)
            {
                letter='B';
            }
            else if(grade>=70 && grade<=79)
            {
                letter='C';
            }
            else if(grade>=60 && grade<=69)
            {
                letter='D';
            }
            else
            {
                letter='F';
            }

            grades.add(letter);
        }      
    }
    
    void calcGPA(){
        for(int i = 0; i < grades.size(); i++){
            switch(grades.get(i)){
                case 'A':
                {
                    gpa += 4.0;
                    break;
                }
                case 'B':
                {
                    gpa += 3.0;
                    break;
                }
                case 'C':
                {
                    gpa += 2.0;
                    break;
                }
                case 'D':
                {
                    gpa += 1.0;
                    break;
                }
            }
        }
        
        gpa /= grades.size();
    }
    
    void display(){
        String information = " ";
        
        information += "Name: " + fName + " " + lName +
                        "\nID: " + id + "     GPA: " + gpa;
        
        for(int i = 0; i < courses.size(); i++){
                    for(int j = 0; j < courses.get(i).size(); j++){
                        
                        if(j == 0){
                            information += "\nCourse: " + courses.get(i).get(j) + "\tGrade: " + grades.get(i);
                        }
                        else{
                            information += "\nTest "  + j + ": " + courses.get(i).get(j);
                        }  
                        
                    }
                }         
        
        JOptionPane.showMessageDialog(null, information);
    }
}
