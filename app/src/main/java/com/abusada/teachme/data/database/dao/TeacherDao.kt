package com.abusada.teachme.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abusada.teachme.data.models.FavoriteTeacher
import com.abusada.teachme.data.models.Teacher
import kotlinx.coroutines.flow.Flow

@Dao
interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeacher(teacher: Teacher)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeachers(teachers: List<Teacher>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteTeacher(favoriteTeacher: FavoriteTeacher)

    @Query("SELECT * FROM teacher_table")
    fun getTeachers(): Flow<List<Teacher>>

    @Query("SELECT teacher_table.* FROM teacher_table inner join favorite_teacher_table on teacher_table.userId = favorite_teacher_table.userId")
    fun getFavoriteTeachers(): Flow<List<Teacher>>

}