package com.example.ordermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderMgmtLogin extends AppCompatActivity {

    Button btnsignin2;
    EditText smUserName ,smPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_mgmt_login);

        btnsignin2 = findViewById(R.id.btnsignin2);
        smUserName =findViewById(R.id.smUserName);
        smPassword =findViewById(R.id.smPassword);


        btnsignin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = smUserName.getText().toString();
                String pass = smPassword.getText().toString();

                // Site Manager login
                String siteMgr_userName = "site1234";
                String siteMgr_psw = "1234";

                // Procurement staff login
                String staff_userName = "staff1234";
                String staff_psw = "1234";

                if(user.equals(siteMgr_userName) && pass.equals(siteMgr_psw)){

                    Toast.makeText(getApplicationContext(), "Site Manager Signed in Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(getApplicationContext(), PlaceAnOrder.class);
                    startActivity(intent);

                }

                else if(user.equals(staff_userName) && pass.equals(staff_psw)){

                    Toast.makeText(getApplicationContext(), "Procurement staff signed in Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(getApplicationContext(), StaffInterface.class);
                    startActivity(intent);

                }

                else{

                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}