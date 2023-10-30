package lat.pam.uts

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RelativeLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PackageManagerCompat.LOG_TAG
import org.w3c.dom.Text


@Suppress("DEPRECATION")
class orderDetails : AppCompatActivity() {
    var checkBoxes = ArrayList<CheckBox>()
    val EXTRA_NAMA = "lat.pam.uts.twoactivities.extra.nama"
    val EXTRA_LOC = "lat.pam.uts.twoactivities.extra.loc"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val locStore = intent.getStringExtra(EXTRA_LOC)
        val cardItem = intent.getSerializableExtra("CARD_ITEM") as CardListAdapter.CardItem
        val namaTextView = findViewById<TextView>(R.id.order_name)
        namaTextView.text = "Nama: " + nama
        val locTextView = findViewById<TextView>(R.id.order_store)
        locTextView.text = "Toko: " + locStore
        val cardItemText = findViewById<TextView>(R.id.order_item)
        cardItemText.text = cardItem.title+" Sudah dipesan"
        val btnDone = findViewById<Button>(R.id.btn_done)
        var selectedValue = ""
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            selectedValue = radioButton.text.toString()

        }
        btnDone?.setOnClickListener(View.OnClickListener {
            val textNotif = findViewById<TextView>(R.id.order_text_notification)
            textNotif.text = "Terima kasih Pa/Bu "+ nama +" sudah memesan ditoko kami, pesanan "+cardItem.title+" anda dikirim menggunakan " + selectedValue
            val visibilityNotif = findViewById<RelativeLayout>(R.id.order_notification)
            visibilityNotif.visibility = View.VISIBLE
            Log.d(LOG_TAG, visibilityNotif.visibility.toString())
        })
    }
}