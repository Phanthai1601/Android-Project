import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.base.fragment.BaseBindingFragment
import com.example.movie.databinding.MovieFragmentBinding
import com.example.movie.module.movie.MovieAdapter
import com.example.movie.module.movie.MovieViewModel

class MovieFragment : BaseBindingFragment<MovieFragmentBinding>() {
    companion object {
        fun newInstance(): MovieFragment {
            return MovieFragment().apply {
                arguments = Bundle()
            }
        }
    }

    private val viewModel: MovieViewModel by viewModels()
    private lateinit var adapter: MovieAdapter



    override fun getLayoutResId(): Int = R.layout.movie_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        initData()
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> MovieFragmentBinding
        get() = MovieFragmentBinding::inflate

    override fun init() {
        // Không cần sử dụng TODO ở đây, có thể để trống hoặc triển khai
    }

    private fun initViews() {
        adapter = MovieAdapter(requireContext())  // Khởi tạo adapter
        binding.recyclerPopular.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
            adapter = this@MovieFragment.adapter
        }
        binding.recyclerDemo.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
            adapter = this@MovieFragment.adapter
        }
        binding.recyclerTest.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
            adapter = this@MovieFragment.adapter
        }
    }

    private fun initObservers() {
        viewModel.movies.observe(viewLifecycleOwner){
            movie->adapter.updateMovies(movie)
        }
    }


    private fun initData() {
        viewModel.fetchMovies(requireContext())
    }
}
