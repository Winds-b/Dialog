package com.example.a1.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button tooltip;
    private Button logon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tooltip = (Button) findViewById(R.id.tooltip);
        logon = (Button) findViewById(R.id.logon);
        tooltip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("系统提示")

                        .setMessage("提示对话框！")

                        .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "返回！", Toast.LENGTH_SHORT).show();
                            }

                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定！", Toast.LENGTH_SHORT).show();

                    }

                }).show();
            }
        });
        logon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                final View textEntryView = factory.inflate(R.layout.login, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("登陆")
                        .setView(textEntryView)
                        .setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                final EditText etUserName = (EditText) textEntryView.findViewById(R.id.etuserName);
                                final EditText etPassword = (EditText) textEntryView.findViewById(R.id.etPWD);
                                String userName = etUserName.getText().toString().trim();
                                String password = etPassword.getText().toString().trim();
                                if (userName.equals("abc") && password.equals("123")) {
                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "密码或用户名错误", Toast.LENGTH_SHORT).show();

                                }
                            }
                        })
                        .setNegativeButton("退出", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })
                        .create().show();
            }
        });
    }
}
