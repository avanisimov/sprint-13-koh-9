package ru.yandex.practicum.sprint13koh09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.yandex.practicum.sprint13koh09.databinding.VCatalogItemBinding

data class CatalogItemViewData(
    val item: CatalogItem,
    val count: Int?,
) {
    val id = item.id
}

class CatalogItemViewHolder(
    parent: ViewGroup,
    val binding: VCatalogItemBinding = VCatalogItemBinding.inflate(
        LayoutInflater.from(
            parent.context
        ), parent, false
    )
) : RecyclerView.ViewHolder(
    binding.root
) {

    fun bind(viewData: CatalogItemViewData) {
        binding.root

        Glide
            .with(binding.root.context)
            .load(viewData.item.imageUrl)
            .into(binding.image)
        binding.title.text = viewData.item.name

        val temp: Float = (viewData.item.price.toFloat() / 100)
        val tempString = String.format("%.2f", temp)
        binding.price.text = "$tempString Р/${viewData.item.unit}"

        if (viewData.count != null) {
            if (viewData.count==0){
                binding.addToCart.visibility = View.VISIBLE
                binding.countContainer.visibility = View.GONE
            }
            else {
                binding.addToCart.visibility = View.GONE
                binding.countContainer.visibility = View.VISIBLE
                binding.count.text = viewData.count.toString()
            }
        }
    }

}