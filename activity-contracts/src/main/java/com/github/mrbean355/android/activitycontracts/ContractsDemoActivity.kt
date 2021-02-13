package com.github.mrbean355.android.activitycontracts

import android.Manifest
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.mrbean355.android.activitycontracts.databinding.ActivityContractsDemoBinding

class ContractsDemoActivity : AppCompatActivity() {
    private val requestPermission = registerForActivityResult(RequestPermission()) { granted ->
        viewModel.onPermissionsResult(granted)
    }
    private val customContract = registerForActivityResult(PaymentActivity.Contract()) { result ->
        viewModel.onCustomContractResult(result)
    }
    private val viewModel: ContractsDemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContractsDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getStatusText().observe(this) {
            binding.permissionResult.text = it
        }

        binding.requestPermission.setOnClickListener {
            requestPermission.launch(Manifest.permission.CAMERA)
        }

        binding.customContract.setOnClickListener {
            customContract.launch(Payment("Test User", 4200))
        }
    }
}