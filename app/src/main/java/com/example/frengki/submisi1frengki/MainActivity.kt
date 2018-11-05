package com.example.frengki.submisi1frengki

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity(){
       var footballItem : MutableList<KlubBola> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = KlubAdapter(footballItem){
                    startActivity<ActivityDetail>(ActivityDetail.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.nama, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }


    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val keterangan = resources.getStringArray(R.array.club_info)
        val berdiri = resources.getStringArray(R.array.club_since)
        val stadion = resources.getStringArray(R.array.stadion)
        val pelatih = resources.getStringArray(R.array.pelatih)

        footballItem.clear()

        for (i in name.indices){
            footballItem.add(KlubBola(name[i], image.getResourceId(i,0), keterangan[i],berdiri[i], stadion[i], pelatih[i] ))
        }
        Log.e("info", footballItem.size.toString())

        image.recycle()

    }
}
