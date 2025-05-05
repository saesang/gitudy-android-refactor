package com.takseha.domain.repository

import com.takseha.domain.model.commit.CommitComment
import com.takseha.domain.model.commit.CommitDetail
import com.takseha.domain.model.commit.PostCommitCommentParam

interface CommitRepository {
    /** 커밋 상세 정보 조회 */
    suspend fun getCommitDetail(studyId: Int, commitId: Int): CommitDetail?
    suspend fun fetchCommitDetail(studyId: Int, commitId: Int): CommitDetail

    /** 커밋 승인 */
    suspend fun approveCommit(studyId: Int, commitId: Int)

    /** 커밋 반려 */
    suspend fun rejectCommit(studyId: Int, commitId: Int)

    /** 커밋 댓글 리스트 조회 */
    suspend fun getCommitComments(studyId: Int, commitId: Int): List<CommitComment>?
    suspend fun fetchCommitComments(studyId: Int, commitId: Int): List<CommitComment>

    /** 커밋 댓글 등록 */
    suspend fun postCommitComment(commitId: Int, postCommitCommentParam: PostCommitCommentParam)

    /** 커밋 댓글 수정 */
    suspend fun updateCommitComment(commitId: Int, postCommitCommentParam: PostCommitCommentParam)

    /** 커밋 댓글 삭제 */
    suspend fun deleteCommitComment(commitId: Int, commentId: Int)
}