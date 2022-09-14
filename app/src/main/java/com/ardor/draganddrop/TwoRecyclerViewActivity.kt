package com.ardor.draganddrop

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ardor.draganddrop.databinding.ActivityTwoRecyclerViewBinding
import com.ardor.draganddrop.listener.CustomListener
import com.ardor.draganddrop.model.SimpleModel
import com.ardor.draganddrop.viewmodel.SampleViewModel

class TwoRecyclerViewActivity : AppCompatActivity(), CustomListener {

    lateinit var binding: ActivityTwoRecyclerViewBinding
    private val viewModel: SampleViewModel by viewModels()
    private val data: List<SimpleModel> = listOf(
        SimpleModel("One"),
        SimpleModel("Two"),
        SimpleModel("Three"),
        SimpleModel("Four"),
        SimpleModel("Five"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_recycler_view)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listener = this

        viewModel.setData(data)
    }

    override fun setTopData(list: MutableList<SimpleModel?>) {
        viewModel.setTopData(list)
    }

    override fun setBottomData(list: MutableList<SimpleModel?>) {
        viewModel.setBottomData(list)
    }
}