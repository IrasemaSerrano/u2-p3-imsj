package mx.edu.ittepic.tpdm_u2_p3_imsj

import android.os.AsyncTask
import kotlin.random.Random

class ClaseAsyncTask() : AsyncTask<Int, Void, List<Int>>(){
    override fun doInBackground(vararg p0: Int?): List<Int> {

        var n = p0.get(0)
        var m = p0.get(1)

        var numero = List(2000) { Random.nextInt(n!!, m!!) }

        return numero
    }


    override fun onPostExecute(result: List<Int>?) {
        super.onPostExecute(result)
        var nprimos = ""

        (0..result!!.size-1).forEach {
            var num = result.get(it)
            var cont = 0
            (1..num).forEach {i->
                if (num % i == 0){
                    cont++
                }
            }
            if (cont == 2){
                nprimos = nprimos + num + "\n"
            }
        }
        MainActivity.arch?.write(nprimos)
        MainActivity.arch?.flush()
        MainActivity.arch?.close()
    }
}

//http://www.sgoliver.net/blog/ficheros-en-android-i-memoria-interna/
