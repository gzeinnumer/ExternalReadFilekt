package com.gzeinnumer.externalreadfilekt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gzeinnumer.externalreadfilekt.helper.FunctionGlobalDir
import com.gzeinnumer.externalreadfilekt.helper.FunctionGlobalFile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity_"

    var msg = "externalreadfilekt\n"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = TAG

        if (FunctionGlobalDir.isFileExists(FunctionGlobalDir.appFolder + "/File.txt")) {
            msg += "File sudah dibuat sebelumnya \n"
            tv.text = msg
            val list: List<String>? = FunctionGlobalFile.readFile(FunctionGlobalDir.appFolder + "/File.txt")
            if (list != null) {
                msg += "Jumlah line di file ada " + list.size
                tv.text = msg
            } else {
                msg += "Gagal membaca data"
                tv.text = msg
            }
        } else {
            if (FunctionGlobalFile.initFile("Text yang dibuat di file")) {
                val list: List<String>? = FunctionGlobalFile.readFile(FunctionGlobalDir.appFolder + "/File.txt")
                if (list != null) {
                    msg += "Jumlah line di file ada " + list.size
                    tv.text = msg
                } else {
                    msg += "Gagal membaca data"
                    tv.text = msg
                }
            } else {
                msg += "File gagal dibuat "
                tv.text = msg
            }
        }
    }
}