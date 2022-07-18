package com.test.offlineapp.data.entities.issue

data class Label(
    val color: String,
    val default: Boolean,
    val description: String,
    val id: Long,
    val name: String,
    val node_id: String,
    val url: String
)