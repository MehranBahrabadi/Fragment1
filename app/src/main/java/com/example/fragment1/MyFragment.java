package com.example.fragment1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    EditText inputEmail;
    Button btnSubmit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my , container , false);
        inputEmail = rootView.findViewById(R.id.input_email);
        btnSubmit = rootView.findViewById(R.id.btn_submit);
        btnSubmit.setEnabled(false);

        inputEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email = charSequence.toString().trim();
                if(email.isEmpty() || !email.contains("@") || email.lastIndexOf('@') > email.lastIndexOf('.') ||
                    email.split("@").length != 2 || email.indexOf('@')==0 || email.charAt(email.length()-1 )=='.'){
                    btnSubmit.setEnabled(false);
                }
                else{
                    btnSubmit.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                Toast.makeText(getContext(), "Email : " + email, Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
