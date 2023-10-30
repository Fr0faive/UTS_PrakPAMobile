package lat.pam.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.PackageManagerCompat.LOG_TAG

class restaurant_details : AppCompatActivity() {
    val EXTRA_NAMA = "lat.pam.uts.twoactivities.extra.nama"
    val EXTRA_LOC = "lat.pam.uts.twoactivities.extra.loc"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)
        val btnMenu = findViewById<Button>(R.id.btn_menus)
        val intent = intent
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val textView = findViewById<TextView>(R.id.label_nama)
        textView.text = "Hello, "+nama

        val locStore = intent.getStringExtra(EXTRA_LOC)
        val locTextView = findViewById<TextView>(R.id.store_name)
        locTextView.text = locStore

        btnMenu?.setOnClickListener(View.OnClickListener {
            Log.d(LOG_TAG, "Menu diklik")
            val Intent = Intent(this, allMenus::class.java)
            Intent.putExtra(EXTRA_NAMA, nama)
            Intent.putExtra(EXTRA_LOC, locStore)
            startActivity(Intent)
        })

    }
}