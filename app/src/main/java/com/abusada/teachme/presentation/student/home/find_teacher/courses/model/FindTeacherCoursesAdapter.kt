package com.abusada.teachme.presentation.student.home.find_teacher.courses.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abusada.teachme.data.models.Course
import com.abusada.teachme.databinding.RowFindTeacherCourseBinding
import com.abusada.teachme.presentation.BaseRecyclerViewAdapter
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel

class FindTeacherCoursesAdapter(private val viewModel: FindTeacherViewModel) :
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
        if (holder is FindTeacherCourseViewHolder)
            holder.bind(mItems[position])
    }

    inner class FindTeacherCourseViewHolder(val item: RowFindTeacherCourseBinding) :
        RecyclerView.ViewHolder(item.root) {

//        init {
//            CoroutineScope(Dispatchers.Main).launch {
//                item.root.clicks().collect {
//                    val position = adapterPosition
//                    if(position != RecyclerView.NO_POSITION)
//                        listener.onItemClicked(position)
//                }
//            }
//        }

        fun bind(course: Course) {
            item.viewModel = viewModel
            item.course = course
        }
    }
}