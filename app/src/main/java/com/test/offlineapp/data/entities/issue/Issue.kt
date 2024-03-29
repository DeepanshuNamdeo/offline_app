package com.test.offlineapp.data.entities.issue

import com.test.offlineapp.data.entities.coments.Reactions
import com.test.offlineapp.data.entities.coments.User

data class Issue(
    val active_lock_reason: String?,
    val assignee: Assignee?,
    val assignees: List<Assignee>?,
    val author_association: String?,
    val body: String?,
    val closed_at: Any?,
    val comments: Int?,
    val comments_url: String?,
    val created_at: String?,
    val draft: Boolean?,
    val events_url: String?,
    val html_url: String?,
    val id: Int?,
    val labels: List<Label>?,
    val labels_url: String?,
    val locked: Boolean?,
    val milestone: Milestone?,
    val node_id: String?,
    val number: Int?,
    val performed_via_github_app: Any?,
    val pull_request: PullRequest?,
    val reactions: Reactions?,
    val repository_url: String?,
    val state: String?,
    val state_reason: String??,
    val timeline_url: String?,
    val title: String?,
    val updated_at: String?,
    val url: String?,
    val user: User?
)