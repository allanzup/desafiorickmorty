package br.com.zup.rickandmorty.ui.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.rickandmorty.data.model.RickMortyResult
import br.com.zup.rickandmorty.databinding.CharacterItemBinding
import br.com.zup.rickandmorty.ui.URL_BASE_IMAGE
import com.squareup.picasso.Picasso

class ListAdapter(private var rickMortyList: MutableList<RickMortyResult>,
                  private val clickList: (movieResult: RickMortyResult) -> Unit,)
    :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val character = rickMortyList[position]
            holder.showMovieInfo(character)
            holder.binding.CvItem.setOnClickListener {
                clickList(character)
            }

        }

        override fun getItemCount() = rickMortyList.size

        fun updateList(newList: MutableList<RickMortyResult>) {
            rickMortyList = newList
            notifyDataSetChanged()
        }

        class ViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {

            fun showMovieInfo(rickMortyResult: RickMortyResult) {
                binding.IvNome.text = rickMortyResult.name
                Picasso.get().load(URL_BASE_IMAGE + rickMortyResult.id + ".jpeg")
                    .into(binding.IvCharacter)

            }
        }


}