package com.example.movie.module.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movie.model.Items
import com.example.movie.model.Movie
import com.example.movie.model.response.ListMovieResponse
import com.example.movie.repository.MovieRepository

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val _movies = MutableLiveData<ArrayList<Items>>()
    val movies: LiveData<ArrayList<Items>> get() = _movies
    private val _movieDetail = MutableLiveData<Movie>()
    val movieDetail: LiveData<Movie> get() = _movieDetail


    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error
    private  var page = (1..100).random()

    fun fetchMovies() {
        MovieRepository.getListMovie(
            getApplication(),
            page,
            onSuccess = { movieListResponse: ListMovieResponse ->
                _movies.postValue(movieListResponse.items)
            },
            onError = {}
        )
    }
    private  var slug = "ngoi-truong-xac-song"
    fun getMovieDetail(){
        MovieRepository.getListMovieDetail(
            getApplication(),
            slug,
            onSuccess = {
                movieDetail: Movie ->
                _movieDetail.postValue(movieDetail)
            }
        ) {}

    }
}
