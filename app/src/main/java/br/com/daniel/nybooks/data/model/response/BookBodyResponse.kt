package br.com.daniel.nybooks.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookBodyResponse (
    @Json(name = "results")
    val bookResults: List<BookResultsResponse>

)