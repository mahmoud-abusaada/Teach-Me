package com.abusada.teachme.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abusada.teachme.data.database.dao.*
import com.abusada.teachme.data.models.*

@Database(
    entities = [UserInfo::class, Course::class, FavoriteTeacher::class, Grade::class, Teacher::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun loginResponseDao(): LoginResponseDao
    abstract fun userInfoDao(): UserInfoDao
    abstract fun courseDao(): CourseDao
    abstract fun courseGradeDao(): CourseGradeDao
    abstract fun favoriteTeacherDao(): FavoriteTeacherDao
    abstract fun gradeDao(): GradeDao
    abstract fun teacherDao(): TeacherDao

    object TABLES {

        const val LOGIN_RESPONSE_TABLE = "login_response_table"
        const val USER_INFO_TABLE = "user_table"
        const val STUDENT_TABLE = "student_table"
        const val TEACHER_TABLE = "teacher_table"
        const val GRADE_TABLE = "grade_table"
        const val FAVORITE_TEACHER_TABLE = "favorite_teacher_table"
        const val COURSE_TABLE = "course_table"
        const val COURSE_GRADE_TABLE = "course_grade_table"

    }

}