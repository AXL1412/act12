package com.poutividad.act12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity implements BiometricHelper.BiometricCallback {

    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        Button authenticateButton = findViewById(R.id.authenticateButton);

        authenticateButton.setOnClickListener(v -> {
            // Iniciar el proceso de autenticación biométrica
            BiometricHelper.showBiometricPrompt(this, this);
        });
    }

    @Override
    public void onAuthenticationSuccess() {
        statusText.setText(R.string.auth_success);
        statusText.setTextColor(ContextCompat.getColor(this, R.color.success_green));
    }

    @Override
    public void onAuthenticationError(String errorMessage) {
        statusText.setText(errorMessage);
        statusText.setTextColor(ContextCompat.getColor(this, R.color.error_red));
    }

    @Override
    public void onAuthenticationFailed() {
        statusText.setText(R.string.auth_failed);
        statusText.setTextColor(ContextCompat.getColor(this, R.color.error_red));
    }
}
