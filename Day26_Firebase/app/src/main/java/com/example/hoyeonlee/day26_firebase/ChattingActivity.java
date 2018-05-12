package com.example.hoyeonlee.day26_firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChattingActivity extends AppCompatActivity {

    Button sendButton;
    EditText messageInput;
    ListView listview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        sendButton = findViewById(R.id.btn_send);
        messageInput = findViewById(R.id.input_message);
        listview = findViewById(R.id.listview);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //실제 Database 참조객체
        databaseReference = firebaseDatabase.getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        //listView 세팅
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);

        if(firebaseAuth.getCurrentUser() == null){
            Intent intent = new Intent(this,LoginActivity.class);
            //Flag를 넣어서 스택에 로그인을 제외하고 전부 지우도록 한다. setFlags
            startActivity(intent);
            finish();
        }
        email = firebaseAuth.getCurrentUser().getEmail();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메세지를 보내는 작업
                String message = messageInput.getText().toString();
                if(TextUtils.isEmpty(message.trim())){
                    return;
                }
                ChattingData data = new ChattingData(email,message);
                //message 테이블을 만든후 데이터를 넣는다. 만약에 있으면 그냥 씀
                databaseReference.child("message").push().setValue(data);
                messageInput.setText("");
            }
        });
        //message 테이블의 데이터 변화가 생겼을 때 호출된다.
        databaseReference.child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //message 테이블에 데이터가 들어오면
                ChattingData data = dataSnapshot.getValue(ChattingData.class);
//                String item = data.email+ " : " + data.message;
                String item = String.format("%s : %s",data.email,data.message);
                adapter.add(item);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
