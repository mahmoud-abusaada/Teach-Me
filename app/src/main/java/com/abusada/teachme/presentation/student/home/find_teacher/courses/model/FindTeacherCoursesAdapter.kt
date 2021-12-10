package com.abusada.teachme.presentation.student.home.find_teacher.courses.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abusada.teachme.data.models.Course
import com.abusada.teachme.databinding.RowFindTeacherCourseBinding
import com.abusada.teachme.presentation.BaseRecyclerViewAdapter

class FindTeacherCoursesAdapter :
    BaseRecyclerViewAdapter<Course>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindTeacherCourseViewHolder {
        return FindTeacherCourseViewHolder(
            RowFindTeacherCourseBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is FindTeacherCourseViewHolder)
            holder.bind(mItems[position])
    }

    class FindTeacherCourseViewHolder(val item: RowFindTeacherCourseBinding) :
        RecyclerView.ViewHolder(item.root) {

        fun bind(course: Course) {
            item.course = course
        }
    }
}