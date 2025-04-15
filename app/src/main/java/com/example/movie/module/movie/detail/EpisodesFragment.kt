package com.example.movie.module.movie.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.FragmentListEpisodesBinding
import com.example.movie.module.movie.MovieViewModel

class EpisodesFragment : BaseBindingFragment<FragmentListEpisodesBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentListEpisodesBinding
        get() = FragmentListEpisodesBinding::inflate

    override fun init() {}
    private lateinit var adapater: EpisodesAdapater
    private val viewModel: MovieViewModel by activityViewModels()


    override fun getLayoutResId(): Int = R.layout.fragment_list_episodes
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        adapater = EpisodesAdapater(requireContext())
        binding.rcvListEpisodes.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = this@EpisodesFragment.adapater
        }
    }

    private fun initObservers() {
        viewModel.movieDetail.observe(viewLifecycleOwner) { movieDetail ->
            adapater.submitList(movieDetail)
        }
    }

}