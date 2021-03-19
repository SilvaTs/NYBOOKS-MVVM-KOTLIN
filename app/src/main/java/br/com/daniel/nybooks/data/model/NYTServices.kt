package br.com.daniel.nybooks.data.model


import br.com.daniel.nybooks.data.model.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "9uh2SZPGvtEGpkcrbxGS65TZVXCeA3Nb",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}