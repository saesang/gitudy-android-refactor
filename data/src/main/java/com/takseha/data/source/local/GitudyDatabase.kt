package com.takseha.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.takseha.data.source.local.entity.study.StudyCategoryEntity
import com.takseha.data.source.local.entity.mystudy.MyStudyCommentEntity
import com.takseha.data.source.local.entity.mystudy.MyStudyCountEntity
import com.takseha.data.source.local.entity.mystudy.MyStudyDetailWithoutCategoryEntity
import com.takseha.data.source.local.entity.mystudy.MyStudyMemberEntity
import com.takseha.data.source.local.entity.mystudy.MyStudySummaryEntity
import com.takseha.data.source.local.entity.mystudy.TodoSummaryEntity
import com.takseha.data.source.local.entity.mystudy.applicant.StudyApplicantEntity
import com.takseha.data.source.local.entity.notification.NotificationEntity
import com.takseha.data.source.local.entity.study.StudyRankEntity

@Database(
    entities = [MyStudySummaryEntity::class, StudyCategoryEntity::class, MyStudyMemberEntity::class,
        MyStudyCommentEntity::class, MyStudyDetailWithoutCategoryEntity::class, TodoSummaryEntity::class,
        NotificationEntity::class, StudyRankEntity::class, StudyApplicantEntity::class, MyStudyCountEntity::class],
    version = 2,
    exportSchema = false
)
abstract class GitudyDatabase : RoomDatabase() {
    abstract fun dao(): GitudyDao
}