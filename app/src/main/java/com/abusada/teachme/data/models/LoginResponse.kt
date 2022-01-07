package com.abusada.teachme.data.models

data class LoginResponse(
    val id: Int,
    val courseGrade: List<CourseGrade>,
    val course: List<Course>,
    val favoriteTeachers: List<FavoriteTeacher>,
    val gradeDescription: List<Grade>,
    val userInfo: UserInfo
) {
    constructor(userInfo: UserInfo) : this(1, listOf(), listOf(), listOf(), listOf(), userInfo)
}