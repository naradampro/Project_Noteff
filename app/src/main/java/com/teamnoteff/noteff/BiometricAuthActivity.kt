package com.teamnoteff.noteff


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

class BiometricAuthActivity : AppCompatActivity() {
    //UI views
    lateinit var btnAuth:Button;
    lateinit var tvAuthStatus:TextView;

    lateinit var executor: Executor;
    lateinit var biometricPrompt: BiometricPrompt
    lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAuth=findViewById(R.id.btnAuth);
        tvAuthStatus=findViewById(R.id.tvAuthStatus);

        executor=ContextCompat.getMainExecutor(this)

        biometricPrompt=androidx.biometric.BiometricPrompt(this@BiometricAuthActivity,executor,object :androidx.biometric.BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                //if any error come
                tvAuthStatus.text="Error"+errString
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                tvAuthStatus.text="Successfully Auth"
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                tvAuthStatus.text="Authentication Failed"
            }
        })

        //Setup title,subtitle and desc on auth dialog
        promptInfo=androidx.biometric.BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Authentication")
            .setSubtitle("Login using Fingerprint or Face")
            .setNegativeButtonText("Cancel")
            .build()

        //set click event on button
        btnAuth.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }
}