package lat.pam.uts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class CardListAdapter(private val cardList: List<CardItem>) : RecyclerView.Adapter<CardListAdapter.CardViewHolder>() {
    data class CardItem(val imageResource: Int, val title: String, val description: String): Serializable

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    interface OnItemClickListener {
        fun onItemClick(cardItem: CardItem)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = cardList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description

        holder.itemView.setOnClickListener {
            listener?.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}
