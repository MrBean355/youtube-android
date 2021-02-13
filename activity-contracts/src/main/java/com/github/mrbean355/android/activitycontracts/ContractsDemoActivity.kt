package com.github.mrbean355.android.activitycontracts

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mrbean355.android.activitycontracts.databinding.ActivityContractsDemoBinding

private const val REQUEST_CODE_PERMISSION = 123
private const val REQUEST_CODE_CUSTOM = 456

class ContractsDemoActivity : AppCompatActivity() {
    private val viewModel: ContractsDemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContractsDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getStatusText().observe(this) {
            binding.permissionResult.text = it
        }

        binding.requestPermission.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    viewModel.onPermissionsResult(true)
                } else {
                    requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_CODE_PERMISSION)
                }
            }
        }

        binding.customContract.setOnClickListener {
            val intent = PaymentActivity.createIntent(this, Payment("Test User", 4200))
            startActivityForResult(intent, REQUEST_CODE_CUSTOM)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSION) {
            viewModel.onPermissionsResult(grantResults.first() == PackageManager.PERMISSION_GRANTED)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CUSTOM) {
            viewModel.onCustomContractResult(PaymentActivity.parseResult(resultCode, data))
        }
    }
}