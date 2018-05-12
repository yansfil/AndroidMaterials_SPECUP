package com.example.hoyeonlee.day17_fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hoyeonlee on 2018. 3. 22..
 */

public class ProfileFragment extends Fragment {
    EditText nameInput;
    EditText ageInput;
    TextView nameTextView;
    TextView ageTextView;
    Button enrollButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        nameInput = view.findViewById(R.id.input_name);
        ageInput = view.findViewById(R.id.input_age);
        nameTextView = view.findViewById(R.id.tv_name);
        ageTextView = view.findViewById(R.id.tv_age);
        enrollButton = view.findViewById(R.id.btn_enroll);
        //Fragment에서는 getActivity()로 액티비티를 불러온 후 SharedPreferences를 쓴다.
        final SharedPreferences sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        //SharedPreference의 값을 불러온다 이떄 값이 없으면 default value로 ""를 불러온다.
        nameTextView.setText(sp.getString("name",""));
        ageTextView.setText(sp.getString("age",""));


        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String age = ageInput.getText().toString();
                //SharedPreferences에 name이라는 key로 nameInput값을 넣고 age라는 key로 ageInput값을 넣는다.
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",name);
                editor.putString("age",age);
                editor.commit();
                //해당 입력값을 TextView에 띄운다.
                nameTextView.setText(name);
                ageTextView.setText(age);

            }
        });
        return view;
    }
}
