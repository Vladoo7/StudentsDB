package com.sproject.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sproject.studentsdb.Data.Databasehandler;
import com.sproject.studentsdb.Model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Databasehandler databasehandler = new Databasehandler(this);

        databasehandler.addStudent(new Student("IT", "Ivanov", "Petr", 10.2));
        databasehandler.addStudent(new Student("IT", "Petrov", "Ivan", 7.8));
        databasehandler.addStudent(new Student("Physic", "Litvin", "Alex", 8.6));
        databasehandler.addStudent(new Student("Economy", "Golovko", "Mary", 11.0));
        databasehandler.addStudent(new Student("History", "Bogdan", "Olya", 12.0));

        List<Student> students = databasehandler.getAllStudent();

        for(Student student: students){
            Log.d("StudentsInfo: ", "Faculty: " + student.getFaculty() +
                    "Surname: " + student.getSurname() +
                    "First name: " + student.getFirstName() +
                    "Average score: " + student.getAverageScore());
        }
    }
}