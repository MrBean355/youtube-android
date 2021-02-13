package com.github.mrbean355.android.activitycontracts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mrbean355.android.activitycontracts.databinding.ActivityPaymentBinding

private const val KEY_NAME = "NAME"
private const val KEY_AMOUNT = "AMOUNT"
private const val KEY_RESULT = "RESULT"

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.name.text = intent.getStringExtra(KEY_NAME)
        binding.amount.text = intent.getIntExtra(KEY_AMOUNT, -1).toString()

        binding.closeScreenSuccess.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra(KEY_RESULT, "Success!"))
            finish()
        }
        binding.closeScreenError.setOnClickListener {
            setResult(999, Intent().putExtra(KEY_RESULT, "Something bad happened"))
            finish()
        }
    }

    companion object {

        fun createIntent(context: Context, payment: Payment): Intent =
            Intent(context, PaymentActivity::class.java)
                .putExtra(KEY_NAME, payment.recipientName)
                .putExtra(KEY_AMOUNT, payment.amount)

        fun parseResult(resultCode: Int, data: Intent?): TransactionResult = TransactionResult(
            success = resultCode == RESULT_OK,
            message = data?.getStringExtra(KEY_RESULT).orEmpty()
        )
    }
}

class Payment(val recipientName: String, val amount: Int)

class TransactionResult(val success: Boolean, val message: String)