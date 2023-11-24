package ru.yandex.practicum.sprint13koh09

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.yandex.practicum.sprint13koh09.databinding.VCartItemBinding

data class CartItem(
    val id: String,
    val catalogItem: CatalogItem,
    val count: Int,
) {
    val sum: Int
        get() = catalogItem.price.times(count).toInt()
}


class CartItemViewHolder(
    parent: ViewGroup,
    val binding: VCartItemBinding = VCartItemBinding.inflate(
        LayoutInflater.from(
            parent.context
        ), parent, false
    ),
) : RecyclerView.ViewHolder(
    binding.root
) {

    fun bind(item: CartItem) {
        binding.root
        binding.sum.text = String.format("%.2f", item.sum.toDouble() / 100).replace('.', ',')
        Glide
            .with(binding.root.context)
            .load(item.catalogItem.imageUrl)
            .into(binding.image)
        binding.title.text = item.catalogItem.name

        binding.count.text = item.count.toString()
    }

}