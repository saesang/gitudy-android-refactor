package com.takseha.presentation.view.mystudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.takseha.domain.model.common.Failure
import com.takseha.presentation.databinding.FragmentMyStudyBinding
import com.takseha.presentation.view.base.Error
import com.takseha.presentation.view.base.Init
import com.takseha.presentation.view.base.Loading
import com.takseha.presentation.view.base.Success
import com.takseha.presentation.view.base.UiState
import com.takseha.presentation.viewmodel.MyStudyBasicUiModel
import com.takseha.presentation.viewmodel.MyStudyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * 마이스터디 상세 화면 (메인)
 */
//TODO: BaseFragment 구현 후 상속 받기
class MyStudyFragment : Fragment() {
    private var _binding: FragmentMyStudyBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyStudyViewModel by viewModels()

    private var studyId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //TODO: argument key 따로 정의
            studyId = it.getInt("studyId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyStudyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        observeUiState()
    }

    /** UI 이벤트 관련 초기화 */
    private fun initListeners() {
        //TODO: UI 이벤트 리스너 초기화 필요
    }

    /** UiState Observe */
    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.myStudyBasicState.collectLatest { handleUiState(it) }
            }
        }
    }

    /** UiState 상태에 따른 화면 구현 */
    private fun handleUiState(uiState: UiState<MyStudyBasicUiModel>) {
        when (uiState) {
            is Error -> showError(uiState.message, uiState.failure)
            Init -> showInitView()
            Loading -> showLoading()
            is Success -> showContent(uiState.data)
        }
    }

    //TODO: BaseFragment 공통으로 정의
    /** 초기 화면 구현 */
    private fun showInitView() {
    }
    /** 로딩 화면 구현 */
    private fun showLoading() {
    }
    /** 정상 UI 구현 */
    private fun showContent(data: MyStudyBasicUiModel) {
    }
    /** 에러 발생 시 UI 구현 */
    private fun showError(alertMessage: String, failure: Failure? = null) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}