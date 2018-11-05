package com.example.frengki.submisi1frengki

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*


class KlubBolaUI : AnkoComponent<ViewGroup>{

    companion object {
        val namaId = 1
        val logoId = 2
    }

   override fun createView(ui:AnkoContext<ViewGroup>) = with(ui){
        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView{
                id = logoId
                imageResource = R.drawable.liver

            }.lparams(dip(50), dip(50))

            textView {
                id = namaId
                text = "Coba FC"
            }.lparams(matchParent, wrapContent){
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }

        }
    }
}