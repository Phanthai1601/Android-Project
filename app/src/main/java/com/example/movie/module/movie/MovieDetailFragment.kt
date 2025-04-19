package com.example.movie.module.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentMovieDetailBinding
import com.example.movie.model.response.MovieDetailResponse
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.material.tabs.TabLayoutMediator

class MovieDetailFragment : BaseBindingFragment<FragmentMovieDetailBinding>() {

    companion object {
        private const val SLUG = "SLUG"
        private const val NAME_MOVIE = "NAME_MOVIE"
        private const val YEAR = "YEAR"

        fun newInstance(slug: String, nameMovie: String, year: Int) = MovieDetailFragment().apply {
            arguments = Bundle().apply {
                putString(SLUG, slug)
                putString(NAME_MOVIE, nameMovie)
                putInt(YEAR, year)
            }
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMovieDetailBinding
        get() = FragmentMovieDetailBinding::inflate

    override fun init() {
    }

    private val viewModel: MovieViewModel by activityViewModels()
    private var player: ExoPlayer? = null
    private var isExpanded = false
    private lateinit var category :String


    override fun getLayoutResId(): Int = R.layout.fragment_movie_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPaper  = binding.viewPaper
        val tabLayout = binding.tabLayout
        val adapter = ViewPaperAdapter(requireActivity())
        viewPaper.adapter = adapter
        TabLayoutMediator(tabLayout, viewPaper){tab, position->
            tab.text = when(position){
                0->"Các tập"
                1->"Tương tự"
                else ->"Các tập"
            }
        }.attach()
        initViews()
        initPlayer()
        observeViewModel()
    }

    private fun initViews() {
        val args = arguments ?: return
        val slug = args.getString(SLUG, "Không có dữ liệu")
        val nameMovie = args.getString(NAME_MOVIE, "NO NAME")
        val year = args.getInt(YEAR, 0)
        binding.nameMovie.text = nameMovie
        binding.year.text = year.toString()

        binding.apply {
            toggleText.setOnClickListener { toggleContent() }
        }

        viewModel.fetchMovieDetail(requireContext(),slug)
    }

    private fun toggleContent() {
        binding.apply {
            content.maxLines = if (isExpanded) 4 else Integer.MAX_VALUE
            toggleText.text = if (isExpanded) "Mở rộng" else "Thu gọn"
            isExpanded = !isExpanded
        }
    }

    private fun observeViewModel() {
        viewModel.movieDetail.observe(viewLifecycleOwner) { movieDetail ->
            category = movieDetail.movie.category.joinToString(", ") { it.name.toString() }
            binding.apply {
                status.text = movieDetail.movie.episodeCurrent ?: "Không có thông tin trạng thái"
                content.text = movieDetail.movie.content
                country.text= "Quốc gia: "+ (movieDetail.movie.country.firstOrNull()?.name ?: "")
                type.text= "Thể loại: "+category
            }

            playVideo(movieDetail)
        }
    }

    private fun initPlayer() {
        player = ExoPlayer.Builder(requireContext()).build().also { binding.video.player = it }
    }

    private fun playVideo(movieDetail: MovieDetailResponse) {
        val videoUrl = movieDetail.episodes.firstOrNull()?.serverData?.firstOrNull()?.linkM3u8
        videoUrl?.let {
            player?.apply {
                setMediaItem(MediaItem.fromUri(it))
                prepare()
                play()
            }
        } ?: Log.e("ExoPlayer", "Không tìm thấy URL video")
    }

    override fun onDestroyView() {
        player?.release()
        super.onDestroyView()
    }
}
