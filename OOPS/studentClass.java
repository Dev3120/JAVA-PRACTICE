package OOPS;
import java.util.Scanner;

public class studentClass {

    static class Student {
        String name;
        int rno;
        double percent;
    }

    public static void main(String[] args) {

       
        Student x = new Student();
        x.name = "raghav";
        x.rno = 67;
        x.percent = 90.89;

        Student s=new Student();
        s.name = "dev";
        s.rno = 56;
        s.percent = 98.89;


        System.out.println("Name: " + x.name+ " "  +s.name);
        System.out.println("Roll No: " + x.rno);
        System.out.println("Percentage: " + x.percent);
    }
}
