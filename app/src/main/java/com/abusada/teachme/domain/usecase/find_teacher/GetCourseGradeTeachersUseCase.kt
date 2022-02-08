package com.abusada.teachme.domain.usecase.find_teacher

import com.abusada.teachme.domain.repository.FindTeacherRepository
import javax.inject.Inject

class GetCourseGradeTeachersUseCase @Inject constructor(private val repository: FindTeacherRepository) {

    suspend fun execute(courseId: Int, gradeId: Int) = repository.getCourseGradeTeachers(courseId, gradeId)

}