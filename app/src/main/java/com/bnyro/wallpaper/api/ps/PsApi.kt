package com.bnyro.wallpaper.api.ps

import com.bnyro.wallpaper.api.Api
import com.bnyro.wallpaper.db.obj.Wallpaper
import com.bnyro.wallpaper.util.RetrofitHelper

class PsApi : Api() {
    override val name: String = "Picsum"
    override val baseUrl: String = "https://picsum.photos"

    private val api = RetrofitHelper.create(baseUrl, Picsum::class.java)

    override suspend fun getWallpapers(page: Int): List<Wallpaper> {
        return api.getWallpapers(page).map {
            Wallpaper(
                imgSrc = it.download_url!!,
                author = it.author,
                resolution = "${it.width}x${it.height}",
                url = it.url
            )
        }
    }

    override suspend fun getRandomWallpaperUrl(): String {
        return "$baseUrl/1080/1920"
    }
}
