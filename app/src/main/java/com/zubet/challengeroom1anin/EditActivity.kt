package com.zubet.challengeroom1anin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zubet.challengeroom1anin.room.Constant
import com.zubet.challengeroom1anin.room.dbsmksa
import com.zubet.challengeroom1anin.room.tbsiswa
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {
    val db by lazy { dbsmksa(this) }
    private var tbsisnis : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        tombolperintah()
        setupView()
        tbsisnis = intent.getIntExtra("intent_nis",tbsisnis)
        Toast.makeText(this,tbsisnis.toString(),Toast.LENGTH_SHORT).show()
    }
    fun setupView(){
        val intenType = intent.getIntExtra("intent_type",0)
        when(intenType){
            Constant.TYPE_CREATE ->{

            }
            Constant.TYPE_READ ->{
                Btnsimpan.visibility=View.GONE
                Btnupdate.visibility=View.GONE
                ETnis.visibility=View.GONE
                tampilsiswa()
            }
            Constant.TYPE_UPDATE ->{
                Btnsimpan.visibility=View.GONE
                ETnis.visibility=View.GONE
                tampilsiswa()
            }
        }
    }
   private fun tombolperintah(){
        Btnsimpan.setOnClickListener {
        CoroutineScope(Dispatchers.IO).launch {
            db.tbsisDao().addtbsiswa(
                tbsiswa(ETnis.text.toString().toInt(),ETnama.text.toString(),ETkelas.text.toString(),ETalamat.text.toString())
            )
            finish()
        }
        }
       Btnupdate.setOnClickListener {
           CoroutineScope(Dispatchers.IO).launch {
               db.tbsisDao().updateSiswa(
                   tbsiswa(tbsisnis,ETnama.text.toString(),ETkelas.text.toString(),ETalamat.text.toString())
               )
               finish()
           }
       }

    }
    fun tampilsiswa(){
        tbsisnis = intent.getIntExtra("intent_nis",0)
        CoroutineScope(Dispatchers.IO).launch {
            val siswa =db.tbsisDao().tampilid(tbsisnis).get(0)
            //ETnis.setText(siswa.nis)
            ETnama.setText(siswa.nama)
            ETkelas.setText(siswa.kelas)
            ETalamat.setText(siswa.alamat)
        }
    }
}