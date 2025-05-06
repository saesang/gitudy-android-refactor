package com.takseha.data.source.local.entity.mystudy.applicant

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StudyApplicant")
class StudyApplicantEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo("studyId") val studyId: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("githubId") val githubId: String,
    @ColumnInfo("profileUrl") val profileUrl: String,
    @ColumnInfo("profilePublicYn") val profilePublicYn: Boolean,
    @ColumnInfo("signGreeting") val signGreeting: String,
    @ColumnInfo("appliedAt") val appliedAt: String,
    @ColumnInfo("githubLink") val githubLink: String?,
    @ColumnInfo("blogLink") val blogLink: String?,
    @ColumnInfo("linkedInLink") val linkedInLink: String?,
)

