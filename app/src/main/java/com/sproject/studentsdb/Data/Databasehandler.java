package com.sproject.studentsdb.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sproject.studentsdb.Model.Student;
import com.sproject.studentsdb.Utils.Util;

import java.util.ArrayList;
import java.util.List;

public class Databasehandler extends SQLiteOpenHelper {

    public Databasehandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Util.CREATE_TABLE_COMMAND);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Util.DROP_TABLE_COMMAND);
        onCreate(sqLiteDatabase);

    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_FACULTY, student.getFaculty());
        contentValues.put(Util.KEY_SURNAME, student.getSurname());
        contentValues.put(Util.KEY_FIRST_NAME, student.getFirstName());
        contentValues.put(Util.KEY_AVERAGE_SCORE, String.valueOf(student.getAverageScore()));
        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
    }


    public Student getStudent(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[]{Util.KEY_ID, Util.KEY_FACULTY, Util.KEY_SURNAME, Util.KEY_FIRST_NAME, Util.KEY_AVERAGE_SCORE},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);
        Student student = new Student();
        if (cursor != null){
            cursor.moveToFirst();
            student = new Student(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    Double.parseDouble(cursor.getString(4)));
        }
        cursor.close();
        return student;
    }
    public List<Student> getAllStudent (){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Student> students = new ArrayList<>();
        Cursor cursor =db.rawQuery(Util.GET_ALL_STUDENTS_COMMAND, null);
        while (cursor.moveToNext()){
            Student student = new Student();
            student = new Student(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    Double.parseDouble(cursor.getString(4)));
            students.add(student);

        }
        cursor.close();
        return students;
    }

    public int updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_FACULTY, student.getFaculty());
        contentValues.put(Util.KEY_SURNAME, student.getSurname());
        contentValues.put(Util.KEY_FIRST_NAME, student.getFirstName());
        contentValues.put(Util.KEY_AVERAGE_SCORE, String.valueOf(student.getAverageScore()));


        return db.update(Util.TABLE_NAME, contentValues, Util.KEY_ID + "=?",
                new String[] {String.valueOf(student.getId())});
    }

    public void deleteStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?",
                new String[] {String.valueOf(student.getId())});

        db.close();
    }

    public int getStudentCount() {
        SQLiteDatabase db = this.getReadableDatabase();

        String countQuery = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = -1;
        if (cursor != null) {
            try {
                count = cursor.getCount();
            } finally {
                cursor.close();
            }

        }
        return count;

    }
}
