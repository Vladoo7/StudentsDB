package com.sproject.studentsdb.Utils;

public class Util {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "studentsDB";
    public static final String TABLE_NAME = "students";

    public static final String KEY_ID = "id";
    public static final String KEY_FACULTY = "faculty";
    public static final String KEY_SURNAME = "surname";
    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_AVERAGE_SCORE = "average_score";

    public static final String TYPE_INTEGER = "INTEGER";
    public static final String TYPE_TEXT = "TEXT";

    public static final String CREATE_TABLE_COMMAND = "CREATE TABLE " + TABLE_NAME
                        + "(" + KEY_ID + " " + TYPE_INTEGER + " PRIMARY KEY " +","
                        + KEY_FACULTY + " " + TYPE_TEXT + ","
                        + KEY_SURNAME + " " + TYPE_TEXT + ","
                        + KEY_FIRST_NAME + " " + TYPE_TEXT + ","
                        + KEY_AVERAGE_SCORE + " " + TYPE_TEXT + ")";

    public static final String GET_ALL_STUDENTS_COMMAND = "SELECT * FROM " + TABLE_NAME;
    public static final String DROP_TABLE_COMMAND = "DROP TABLE IF EXIST " + TABLE_NAME;

}
