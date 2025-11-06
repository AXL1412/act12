package com.poutividad.act12;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import java.util.concurrent.Executor;

public class BiometricHelper {

    public interface BiometricCallback {
        void onAuthenticationSuccess();
        void onAuthenticationError(String errorMessage);
        void onAuthenticationFailed();
    }

    public static void showBiometricPrompt(
            @NonNull AppCompatActivity activity,
            @NonNull BiometricCallback callback
    ) {
        BiometricManager biometricManager = BiometricManager.from(activity);
        switch (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                // El dispositivo está listo para la autenticación.
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(activity, activity.getString(R.string.biometric_no_hardware), Toast.LENGTH_LONG).show();
                return;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(activity, activity.getString(R.string.auth_error), Toast.LENGTH_LONG).show();
                return;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(activity, activity.getString(R.string.biometric_not_enrolled), Toast.LENGTH_LONG).show();
                return;
        }

        Executor executor = ContextCompat.getMainExecutor(activity);
        BiometricPrompt biometricPrompt = new BiometricPrompt(activity, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    callback.onAuthenticationError(activity.getString(R.string.auth_canceled));
                } else {
                    callback.onAuthenticationError(activity.getString(R.string.auth_error) + ": " + errString);
                }
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                callback.onAuthenticationSuccess();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                callback.onAuthenticationFailed();
            }
        });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle(activity.getString(R.string.biometric_prompt_title))
                .setSubtitle(activity.getString(R.string.biometric_prompt_subtitle))
                .setDescription(activity.getString(R.string.biometric_prompt_description))
                .setNegativeButtonText(activity.getString(R.string.biometric_prompt_negative_button))
                .build();

        biometricPrompt.authenticate(promptInfo);
    }
}
