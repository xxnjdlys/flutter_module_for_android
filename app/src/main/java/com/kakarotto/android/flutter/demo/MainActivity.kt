package com.kakarotto.android.flutter.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.flutter.facade.Flutter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        when (v) {
            btnClick -> {
                txtDesc.text = String.format( getString(R.string.txt_attach_flutter), ROUTER1)
                attachFlutterFragment(ROUTER1)
            }
            btnClick2 -> {
                txtDesc.text = String.format( getString(R.string.txt_attach_flutter), ROUTER2)
                attachFlutterFragment(ROUTER2)
            }
        }
    }

    companion object {
        const val ROUTER1 = "router1"
        const val ROUTER2 = "router2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick.setOnClickListener(this)
        btnClick2.setOnClickListener(this)
    }

    private fun attachFlutterFragment(router: String) {
        val tx = supportFragmentManager.beginTransaction()
        tx.replace(R.id.flContainer, Flutter.createFragment(router))
        tx.commit()
    }
}
