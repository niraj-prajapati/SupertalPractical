package com.supertal.practical.base

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.niraj.internetobserve.NetworkConnectivityObserver

open class BaseActivity : AppCompatActivity() {

    private lateinit var noInternetAlert: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        noInternetAlert = AlertDialog.Builder(this)
            .setTitle("No Internet")
            .setMessage("Please Turn on Internet to continue!")
            .setCancelable(false)
            .create()


        // check internet and show alert dialog if not connected
        NetworkConnectivityObserver.internetAvailable.observe(this) {
            it?.let {
                if (it.not()) showNoInternet() else dismissNoInternetDialog()
            }
        }
    }

    /**
     * shows no internet dialog
     */
    private fun showNoInternet() {
        noInternetAlert.apply {
            if (isShowing.not()) show()
        }
    }

    /**
     * hides no internet dialog
     */
    private fun dismissNoInternetDialog() {
        noInternetAlert.apply {
            if (isShowing) dismiss()
        }
    }
}