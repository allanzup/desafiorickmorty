package br.com.zup.rickandmorty.ui.detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import br.com.zup.rickandmorty.R
import br.com.zup.rickandmorty.data.model.RickMortyResult
import br.com.zup.rickandmorty.databinding.FragmentDetailBinding
import br.com.zup.rickandmorty.ui.detail.viewmodel.DetailViewModel
import br.com.zup.rickandmorty.ui.home.view.HomeActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var characterfavirite: RickMortyResult
    private val viewModel: DetailViewModel by lazy { ViewModelProvider(this)[DetailViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = getcharacter()
        if (character != null) {
            Picasso.get().load(character.image).into(binding.Iv)
            binding.TvNome.text = "Nome:" + character.name
            binding.TvEspecie.text = "Espécie:" + character.species
            binding.TvGenero.text = "Genero:" + character.gender
            binding.TvStatus.text = "Estatus:" + character.status
            binding.Ivstar.setOnClickListener {
                character.favorite = !character.favorite
                updatecollor(character)
                viewModel.updatefavorite(character)
            }
            (activity as HomeActivity).supportActionBar?.title = character.name

        }
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun updatecollor(character: RickMortyResult) {
        binding.Ivstar.setImageDrawable(
            ContextCompat.getDrawable(
                binding.root.context,
                if (character.favorite) R.drawable.ic_baseline_star_rate_24yelow else R.drawable.ic_baseline_star_rate_24
            )
        )
    }

    fun getcharacter(): RickMortyResult? {
        return arguments?.getParcelable<RickMortyResult>("CHARACTER")
    }

}