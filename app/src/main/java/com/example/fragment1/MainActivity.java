package com.example.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        MyFragment myFragment = new MyFragment();
            getSupportFragmentManager().beginTransaction()
                   .replace(R.id.my_container , myFragment)
               .commit();
               */

        FragmentStudentDetails fragment = FragmentStudentDetails.
                newInstance("A1234465" ,"John Smith",85 );
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.my_container , fragment)
                .commit();
    }

}