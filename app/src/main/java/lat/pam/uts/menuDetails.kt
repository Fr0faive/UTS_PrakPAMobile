package lat.pam.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

@Suppress("DEPRECATION")
class menuDetails : AppCompatActivity() {
    val EXTRA_NAMA = "lat.pam.uts.twoactivities.extra.nama"
    val EXTRA_LOC = "lat.pam.uts.twoactivities.extra.loc"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_details)
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val locStore = intent.getStringExtra(EXTRA_LOC)
        val cardItem = intent.getSerializableExtra("CARD_ITEM") as CardListAdapter.CardItem
        val btnOrder = findViewById<Button>(R.id.btn_order)
        val btnBack = findViewById<Button>(R.id.btn_back)
        val cardItemTitle = findViewById<TextView>(R.id.titleMenu)
        cardItemTitle.text = cardItem.title
        btnOrder?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, orderDetails::class.java)
            intent.putExtra(EXTRA_NAMA, nama)
            intent.putExtra(EXTRA_LOC, locStore)
            intent.putExtra("CARD_ITEM", cardItem)
            startActivity(intent)
        })
        btnBack?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, allMenus::class.java)
            intent.putExtra(EXTRA_NAMA, nama)
            intent.putExtra(EXTRA_LOC, locStore)
            startActivity(intent)
        })

    }
}