package com.example.frengki.submisi1frengki

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class ActivityDetail:AppCompatActivity(){
    companion object {
      const  val keteranganID = 3
        const val POSITIONEXTRA ="position extra"
      const  val berdiriID = 4
      const  val stadionID = 5
      const  val pelatihID = 6

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val intent = intent
        val list = intent.getParcelableExtra<KlubBola>(POSITIONEXTRA)
        ActivityDetailUI(list).setContentView(this)

    }
    inner class ActivityDetailUI(var list: KlubBola) : AnkoComponent<ActivityDetail> {

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        override fun createView(ui: AnkoContext<ActivityDetail>) = with(ui){
            var position = 0
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView{
                    Glide.with(this).load(list.logo).into(this)
                    id = KlubBolaUI.logoId
                    padding = dip(10)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView{
                    id = KlubBolaUI.namaId
                    text = list.nama
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView{
                    id = keteranganID
                    text = list.keterangan
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)

                }
                textView{
                    id = berdiriID
                    text = list.berdiri
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }
                textView{
                    id = stadionID
                    text = list.stadion
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }
                textView {
                    id = pelatihID
                    text = list.pelatih
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }

            }
        }

    }
}

