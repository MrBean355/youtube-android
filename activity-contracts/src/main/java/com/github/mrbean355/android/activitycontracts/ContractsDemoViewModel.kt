package com.github.mrbean355.android.activitycontracts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ContractsDemoViewModel(application: Application) : AndroidViewModel(application) {
    private val statusText = MutableLiveData<CharSequence>(application.getString(R.string.permission_result_pending))

    fun getStatusText(): LiveData<CharSequence> = statusText

    fun onPermissionsResult(result: Boolean) {
        statusText.value = getApplication<Application>().getString(
            if (result) {
                R.string.permission_result_granted
            } else {
                R.string.permission_result_denied
            }
        )
    }

    fun onCustomContractResult(transactionResult: TransactionResult) {
        statusText.value = getApplication<Application>().getString(R.string.custom_contract_result, transactionResult.success, transactionResult.message)
    }
}