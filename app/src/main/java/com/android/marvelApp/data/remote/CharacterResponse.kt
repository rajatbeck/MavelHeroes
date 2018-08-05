package com.android.marvelApp.data.remote

import com.squareup.moshi.Json


data class CharacterResponse(
        @Json(name = "code") val code: String,
        @Json(name = "status") val status: String,
        @Json(name = "copyright") val copyright: String,
        @Json(name = "attributionText") val attributionText: String,
        @Json(name = "attributionHTML") val attributionHTML: String,
        @Json(name = "data") val data: Data,
        @Json(name = "etag") val etag: String
)

data class Data(
        @Json(name = "offset") val offset: String,
        @Json(name = "limit") val limit: String,
        @Json(name = "total") val total: String,
        @Json(name = "count") val count: String,
        @Json(name = "results") val results: List<Result>
)

data class Result(
        @Json(name = "id") val id: Int,
        @Json(name = "name") val name: String,
        @Json(name = "description") val description: String,
        @Json(name = "modified") val modified: String,
        @Json(name = "resourceURI") val resourceURI: String,
        @Json(name = "urls") val urls: List<Url>,
        @Json(name = "thumbnail") val thumbnail: Thumbnail,
        @Json(name = "comics") val comics: Comics,
        @Json(name = "stories") val stories: Stories,
        @Json(name = "events") val events: Events,
        @Json(name = "series") val series: Series
) {

    data class Series(
            @Json(name = "available") val available: String,
            @Json(name = "returned") val returned: String,
            @Json(name = "collectionURI") val collectionURI: String,
            @Json(name = "items") val items: List<Item>
    ) {

        data class Item(
                @Json(name = "resourceURI") val resourceURI: String,
                @Json(name = "name") val name: String
        )
    }


    data class Comics(
            @Json(name = "available") val available: String,
            @Json(name = "returned") val returned: String,
            @Json(name = "collectionURI") val collectionURI: String,
            @Json(name = "items") val items: List<Item>
    ) {

        data class Item(
                @Json(name = "resourceURI") val resourceURI: String,
                @Json(name = "name") val name: String
        )
    }


    data class Url(
            @Json(name = "type") val type: String,
            @Json(name = "url") val url: String
    )


    data class Thumbnail(
            @Json(name = "path") val path: String,
            @Json(name = "extension") val extension: String
    )


    data class Events(
            @Json(name = "available") val available: String,
            @Json(name = "returned") val returned: String,
            @Json(name = "collectionURI") val collectionURI: String,
            @Json(name = "items") val items: List<Item>
    ) {

        data class Item(
                @Json(name = "resourceURI") val resourceURI: String,
                @Json(name = "name") val name: String
        )
    }


    data class Stories(
            @Json(name = "available") val available: String,
            @Json(name = "returned") val returned: String,
            @Json(name = "collectionURI") val collectionURI: String,
            @Json(name = "items") val items: List<Item>
    ) {

        data class Item(
                @Json(name = "resourceURI") val resourceURI: String,
                @Json(name = "name") val name: String,
                @Json(name = "type") val type: String
        )
    }


}