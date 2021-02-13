package com.github.mrbean355.android.activitycontracts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
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

    class Contract : ActivityResultContract<Payment, TransactionResult>() {

        override fun createIntent(context: Context, input: Payment?): Intent =
            Intent(context, PaymentActivity::class.java)
                .putExtra(KEY_NAME, input?.recipientName)
                .putExtra(KEY_AMOUNT, input?.amount)

        override fun parseResult(resultCode: Int, intent: Intent?) = TransactionResult(
            success = resultCode == RESULT_OK,
            message = intent?.getStringExtra(KEY_RESULT).orEmpty()
        )
    }
}

class Payment(val recipientName: String, val amount: Int)

class TransactionResult(val success: Boolean, val message: String)