

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

// Authors : Rayan Jangda, Armand Daniel Sanchez, Eldrin Preston, Ismael Moreno, Jabari Fowler
public class admin {
    public String name = "admin";
    public int password = 123;
    ArrayList<student> students = new ArrayList<>();
    
    
    public boolean isEmpty(){
        if(students.isEmpty()){
            return true;
        }
        return false;
    }
//    public void readFile(){
//      student first = new student("Jabari","Fowler",1522);
//      students.add(first);
//      Scanner myReader = new Scanner("filename.txt");
//      while (myReader.hasNextLine()) {
//          String data = myReader.nextLine();
//          student m = new student();
//          m.fName = data;
//          m.lName = myReader.nextLine();
//          m.id = myReader.nextInt();
//          
//          //System.out.println(data);
//      }
//      myReader.close();
//    }
    
    public boolean studentExist(String fName, String lName, int id){
        boolean found = false;
        
        for(int i = 0; i < students.size(); i++){
            if(fName.equals(students.get(i).fName) && lName.equals(students.get(i).lName) && id == students.get(i).id){
                found = true;
            }
        }
        
        return found;
    }
    
    
    public void display(String fName, String lName, int id){
        String information = " ";
        boolean found = false
                ;
        for(int i = 0; i < students.size(); i++){          
            if(fName.equals(students.get(i).fName) && lName.equals(students.get(i).lName) && id == students.get(i).id){
                found = true;
                information = "Name: " + students.get(i).fName + " " + students.get(i).lName + 
                            "\nID: " + students.get(i).id + "       GPA: " + students.get(i).gpa;
                
                for(int j = 0; j < students.get(i).courses.size(); j++){
                    for(int k = 0; k < students.get(i).courses.get(j).size(); k++){
                        
                        if(k == 0){
                            information += "\nCourse: " + students.get(i).courses.get(j).get(k) + "\tGrade: " + students.get(i).grades.get(j);
                        }
                        else{
                            information += "\nTest "  + k + ": " + students.get(i).courses.get(j).get(k);
                        }  
                        
                    }
                }                
            }
        }
        
        if(found == false){
            information += "Student not found.";
        }
        
        JOptionPane.showMessageDialog(null, information);       
    }
    
}
