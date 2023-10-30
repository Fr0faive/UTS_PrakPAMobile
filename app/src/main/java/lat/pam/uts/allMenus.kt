package lat.pam.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class allMenus : AppCompatActivity(), CardListAdapter.OnItemClickListener {
    val EXTRA_NAMA = "lat.pam.uts.twoactivities.extra.nama"
    val EXTRA_LOC = "lat.pam.uts.twoactivities.extra.loc"
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
        val adapter = CardListAdapter(cardList)
        adapter.setOnItemClickListener(this) // Pastikan listener diatur dengan benar
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    override fun onItemClick(cardItem: CardListAdapter.CardItem) {
        // Buka halaman detail dan kirim data CardItem
        Log.d(LOG_TAG, "diklik")
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val locStore = intent.getStringExtra(EXTRA_LOC)
        val intent = Intent(this, menuDetails::class.java)
        intent.putExtra(EXTRA_NAMA, nama)
        intent.putExtra(EXTRA_LOC, locStore)
        intent.putExtra("CARD_ITEM", cardItem)
        startActivity(intent)
    }

}


