package br.com.zup.rickandmorty.ui.list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.rickandmorty.R
import br.com.zup.rickandmorty.data.model.RickMortyResult
import br.com.zup.rickandmorty.databinding.FragmentListBinding
import br.com.zup.rickandmorty.ui.home.view.HomeActivity
import br.com.zup.rickandmorty.ui.list.viewmodel.ListViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this)[ListViewModel::class.java]
    }
    private val adapter:ListAdapter by lazy {
        ListAdapter(mutableListOf(), this::goToDetail )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacters()
        binding.RvList.adapter=adapter
        binding.RvList.layoutManager=GridLayoutManager(this.context,2)
        observers()
        (activity as HomeActivity).supportActionBar?.title="Ricky and Morty"
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

    }

    fun observers() {
        viewModel.characterResponse.observe(this.viewLifecycleOwner){
            adapter.updateList(it.toMutableList())

        }
    }
    fun goToDetail(rickMortyResult: RickMortyResult){
        val bundle= bundleOf("CHARACTER" to rickMortyResult)
        NavHostFragment.findNavController(this).navigate(R.id.action_listFragment_to_detailFragment2,bundle)
    }
}