package com.example.dialogs

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton: ImageButton = findViewById(R.id.image_button)
        imageButton.setOnClickListener { view ->
            Snackbar.make(view, "You have clicked Image Button.", Snackbar.LENGTH_SHORT).show()
        }

        val btnAlertDialog: Button = findViewById(R.id.btn_alert_dialog)
        btnAlertDialog.setOnClickListener { view ->
            alertDialogFunction()
        }

        val btnCustomDialog: Button = findViewById(R.id.btn_custom_dialog)
        btnCustomDialog.setOnClickListener {
            customDialogFunction()
        }

        val btnCustomProgress: Button = findViewById(R.id.btn_custom_progress_dialog)
        btnCustomProgress.setOnClickListener{
            customProgressDialogFunction()
        }
    }

    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes") {dialogInterface, which ->
            Toast.makeText(applicationContext, "Clicked Yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel") {dialogInterface, which ->
            Toast.makeText(applicationContext, "Clicked Cancel!", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No") {dialogInterface, which ->
            Toast.makeText(applicationContext, "Clicked No", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            Toast.makeText(applicationContext, "Clicked Submit", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            Toast.makeText(applicationContext, "Clicked Cancel", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun customProgressDialogFunction() {
        val customProgressDialog = Dialog(this)

        customProgressDialog.setContentView(R.layout.dialog_custom_progress)
        customProgressDialog.show()
    }
}