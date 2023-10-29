package lat.pam.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.core.content.PackageManagerCompat.LOG_TAG

class MainActivity : AppCompatActivity() {
    val EXTRA_NAMA = "lat.pam.uts.twoactivities.extra.nama"
    val EXTRA_LOC = "lat.pam.uts.twoactivities.extra.loc"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val namaUser = findViewById<EditText>(R.id.editText_name)
        val btnSubmit = findViewById<Button>(R.id.button_submit)





        btnSubmit?.setOnClickListener(View.OnClickListener {
            Log.d(LOG_TAG,"Button diklik")
            val Intent = Intent(this, restaurant_details::class.java)
            val nama = namaUser?.text.toString()
            val spinner = findViewById<Spinner>(R.id.spinner)
            val selectedValue = spinner.selectedItem.toString()
            Intent.putExtra(EXTRA_NAMA, nama)
            Intent.putExtra(EXTRA_LOC, selectedValue)
            startActivity(Intent)
        })
    }


}