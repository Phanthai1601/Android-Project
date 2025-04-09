package com.example.movie.module.movie

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.base.viewmodel.BaseViewModel
import com.example.movie.model.Items
import com.example.movie.model.Movie
import com.example.movie.model.response.ListMovieResponse
import com.example.movie.model.response.MovieDetailResponse
import com.example.movie.repository.MovieRepository

class MovieViewModel : BaseViewModel() {

    private val _movies = MutableLiveData<ArrayList<Items>>()
    val movies: LiveData<ArrayList<Items>> get() = _movies
    private val _movieDetail = MutableLiveData<MovieDetailResponse>()
    val movieDetail: LiveData<MovieDetailResponse> get() = _movieDetail

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private var page = (1..100).random()
    fun fetchMovies(context: Context) {
        val allMovies = ArrayList<Items>()

        val pagesToFetch = listOf(page, page + 1, page + 2)
        var completedRequests = 0

        for (p in pagesToFetch) {
            MovieRepository.getListMovie(
                context,
                p,
                onSuccess = { movieListResponse: ArrayList<Items> ->
                    allMovies.addAll(movieListResponse)
                    completedRequests++

                    if (completedRequests == pagesToFetch.size) {
                        _movies.postValue(allMovies)
                    }
                },
                onError = { errorMessage ->
                    Log.e("MovieRepository", "Error fetching movies: $errorMessage")
                }
            )
        }
    }

    fun fetchMovieDetail(
        context: Context,
        slug: String
    ) {
        _isLoading.value = true
        MovieRepository.getMovieDetail(
            context,
            slug,
            onSuccess = { movieDetail: MovieDetailResponse ->
                _movieDetail.postValue(movieDetail)
            },
            onError = { error ->
                Log.e("MovieRepository", " Error fetching movie detail")
            }

        )
    }


}
