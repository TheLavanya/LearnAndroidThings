package com.lav.learnandroidthings.image

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.activity_image_capture.*

class CaptureImageActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_AIRTEL_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_capture)
        capture_btn.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }

        airtel_capture_btn.setOnClickListener {
            Intent("com.airtel.africa.camera.IMAGE_CAPTURE").also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_AIRTEL_IMAGE_CAPTURE)
                }
            }
        }

        doc_capture_btn.setOnClickListener {
            Intent("com.airtel.africa.camera.IMAGE_CAPTURE").also { takePictureIntent ->
                takePictureIntent.putExtra("pic_type", "mrz")
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_AIRTEL_IMAGE_CAPTURE)
                }
            }
        }

        zm_id_capture_btn.setOnClickListener {
            Intent("com.airtel.africa.camera.IMAGE_CAPTURE").also { takePictureIntent ->
                takePictureIntent.putExtra("pic_type", "zm-national-id-1")
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_AIRTEL_IMAGE_CAPTURE)
                }
            }
        }
        zm_id_2_capture_btn.setOnClickListener {
            Intent("com.airtel.africa.camera.IMAGE_CAPTURE").also { takePictureIntent ->
                takePictureIntent.putExtra("pic_type", "zm-national-id-2")
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_AIRTEL_IMAGE_CAPTURE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_AIRTEL_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val uri = data?.data
            Log.i("IMage-capture-test", "Uri: $uri")
            Log.i("IMage-capture-test", "Real path from : ${getRealPathFromUri(uri)}")
            //For Airtel Camera app

        } else if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            if (imageBitmap != null)
                photo.setImageBitmap(imageBitmap)
            val uri = data?.data
            Log.i("IMage-capture-test", "Uri: $uri")

        }
    }

    fun getRealPathFromUri(contentUri: Uri?) {
        /*var cursor: Cursor? = null
        return try {
            val proj =
                arrayOf(MediaStore.Images.Media.DATA)
            contentUri?.let {
                cursor = getContentResolver().query(contentUri, proj, null, null, null)
                cursor?.let {
                    val column_index: Int =
                        it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                    it.moveToFirst()
                    it.getString(column_index)
                }
            } ?: ""
        } finally {
            if (cursor != null) {
                cursor?.close()
            }
        }*/

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        )
            contentUri?.let {
                val inputStream = contentResolver.openInputStream(contentUri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                photo.setImageBitmap(bitmap)
                inputStream?.close()
            }
    }
}