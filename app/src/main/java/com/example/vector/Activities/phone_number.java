package com.example.vector.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vector.databinding.ActivityPhoneNumberBinding;
import com.google.firebase.auth.FirebaseAuth;

public class phone_number extends AppCompatActivity {

    ActivityPhoneNumberBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
// This is use for stoping all time sign in avtivity and it take main page after login account
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null){
            Intent intent = new Intent(phone_number.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
// For hide alwage showing company name dialog
         getSupportActionBar().hide();
         binding.phoneBox.requestFocus();
        binding.NEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(phone_number.this,otp_page.class);
                intent.putExtra("phoneNumber", binding.phoneBox.getText().toString());
                startActivity(intent);
            }
        });
    }
}