package lat.pam.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class menuDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_details)
        val cardItem = intent.getSerializableExtra("CARD_ITEM") as CardListAdapter.CardItem

    }
}