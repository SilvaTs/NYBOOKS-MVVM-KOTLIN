package br.com.daniel.nybooks.data.response

import br.com.daniel.nybooks.data.model.response.BookDetailsResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookResultsResponse (

    @Json(name = "book_details")
    val bookDetailsResponses: List<BookDetailsResponse>
)