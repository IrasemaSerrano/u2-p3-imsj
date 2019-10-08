package mx.edu.ittepic.tpdm_u2_p3_imsj

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

    var n : EditText ?= null
    var m : EditText ?= null
    var btn : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        n = findViewById(R.id.n)
        m = findViewById(R.id.m)
        btn = findViewById(R.id.btn)

        btn?.setOnClickListener {
            if (!n?.text!!.isEmpty() && !m?.text!!.isEmpty()){
                var nn = n?.text.toString().toInt()
                var mm = m?.text.toString().toInt()

                if(nn<mm){
                    arch = OutputStreamWriter(openFileOutput("primos.txt", Activity.MODE_PRIVATE))
                    var proceso = ClaseAsyncTask()
                    proceso.execute(nn,mm)
                }
            }
        }
    }
    companion object{
        @JvmStatic var arch : OutputStreamWriter ?= null
    }
}
