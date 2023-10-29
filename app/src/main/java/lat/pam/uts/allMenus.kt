package lat.pam.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class allMenus : AppCompatActivity(), CardListAdapter.OnItemClickListener {
    val EXTRA_NAMA = "lat.pam.uts.twoactivities.extra.nama"
    private val cardList = listOf(
        CardListAdapter.CardItem(R.drawable.pizza, "Pizza", "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat"),
        CardListAdapter.CardItem(R.drawable.spaghetti, "Spaghetti", "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental"),
        CardListAdapter.CardItem(R.drawable.burger, "Burger", "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal"),
        CardListAdapter.CardItem(R.drawable.steak, "Steak", "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat"),
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_menus)
        val intent = intent
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val textView = findViewById<TextView>(R.id.label_nama)
        textView.text = "Hello, "+nama
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = CardListAdapter(cardList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    override fun onItemClick(cardItem: CardListAdapter.CardItem) {
        // Buka halaman detail dan kirim data CardItem
        val intent = Intent(this, menuDetails::class.java)
        intent.putExtra("CARD_ITEM", cardItem)
        startActivity(intent)
    }

}


