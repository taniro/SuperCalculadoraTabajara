package ufrn.br.supercalculadoratabajara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivitySetter : AppCompatActivity() {

    var label : String? = ""
    var atual : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setter)

        val textViewLabel = findViewById<TextView>(R.id.textViewLabel)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        label = intent.getStringExtra("label")
        atual = intent.getIntExtra("atual", 0)

        textViewLabel.text = label
        editTextNumber.setText(atual.toString())


        val buttonOk = findViewById<Button>(R.id.buttonOk)
        buttonOk.setOnClickListener {
            val intent = Intent()
            intent.putExtra("atual", Integer.parseInt(editTextNumber.text.toString()))
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}