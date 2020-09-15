package com.lav.learnandroidthings.ble

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.activity_boot_complete.*

class BleTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boot_complete)
        btn.setOnClickListener {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {

                Toast.makeText(this, "Ble supported", Toast.LENGTH_LONG).show()
                if (getBluetoothAdapter().isMultipleAdvertisementSupported) {
                    Toast.makeText(this, "Advertisement supported", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Advertisement not supported", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Ble not supported", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getBluetoothAdapter(): BluetoothAdapter {
        val bluetoothManager =
            getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        return bluetoothManager.adapter
    }
}