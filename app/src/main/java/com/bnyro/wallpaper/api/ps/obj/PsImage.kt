package com.bnyro.wallpaper.api.ps.obj

import kotlinx.serialization.Serializable

@Serializable
data class PsImage(
    val author: String? = null,
    val download_url: String? = null,
    val height: Int? = null,
    val id: String? = null,
    val url: String? = null,
    val width: Int? = null
)
