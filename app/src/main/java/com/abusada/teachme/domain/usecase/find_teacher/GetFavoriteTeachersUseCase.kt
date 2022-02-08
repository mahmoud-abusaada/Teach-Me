package com.abusada.teachme.domain.usecase.find_teacher

import com.abusada.teachme.domain.repository.FindTeacherRepository
import javax.inject.Inject

class GetFavoriteTeachersUseCase @Inject constructor(private val repository: FindTeacherRepository) {

    suspend fun execute(studentId: Long) = repository.getFavoriteTeachers(studentId)

}