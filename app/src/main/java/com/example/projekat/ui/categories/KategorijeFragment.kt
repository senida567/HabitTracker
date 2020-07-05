package com.example.projekat.ui.categories

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projekat.R

class KategorijeFragment : Fragment() {

    companion object {
        fun newInstance() = KategorijeFragment()
    }

    private lateinit var viewModel: KategorijeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.kategorije_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(KategorijeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}