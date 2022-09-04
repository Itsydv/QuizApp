package io.itsydv.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.itsydv.quizapp.databinding.FragmentFeedBinding


class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    private lateinit var allQuestionsAdapter: AllQuestionsAdapter

    private val model by activityViewModels<FeedViewModel> {
        FeedViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        model.questions.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.rvQuestions.visibility = View.GONE
                    binding.shimmerViewContainer.visibility = View.VISIBLE
                    binding.shimmerViewContainer.startShimmer()
                }
                is Resource.Success -> {
                    binding.shimmerViewContainer.stopShimmer()
                    binding.shimmerViewContainer.visibility = View.GONE
                    binding.rvQuestions.visibility = View.VISIBLE
                    binding.tvNumOfQuestions.text = getString(R.string.number_of_questions_and_chapter_feedback,
                        response.data!!.size)
                    allQuestionsAdapter.differ.submitList(response.data.mapIndexed { index, question ->
                        question.questionIndex = index
                        question
                    })
                }
                is Resource.Error -> {
                    binding.rvQuestions.visibility = View.GONE
                    binding.shimmerViewContainer.stopShimmer()
                    binding.shimmerViewContainer.visibility = View.GONE
                }
            }
        }

    }

    private fun setupRecyclerView() {
        allQuestionsAdapter = AllQuestionsAdapter{
            val action = FeedFragmentDirections.feedFragmentToQuestionFragment(it.questionIndex!!, 0)
            findNavController().navigate(action)
        }
        binding.rvQuestions.apply{
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = allQuestionsAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmer()
    }

    override fun onPause() {
        binding.shimmerViewContainer.stopShimmer()
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}