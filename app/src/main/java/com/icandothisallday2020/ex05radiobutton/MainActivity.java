package com.icandothisallday2020.ex05radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
//    RadioButton korea; 없어도됨
//    RadioButton china; └RadioGroup 에서 관리
//    RadioButton japan;
    TextView tv;
    RatingBar star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.rg);
//        korea=findViewById(R.id.korea);
//        china=findViewById(R.id.china);
//        japan=findViewById(R.id.japan);
        tv=findViewById(R.id.tv);

        //china.setChecked(true);---자바에서 체크상태 변경가능

        //RadioGroup's 체크상태가 변경되는 것을 듣는 리스너 생성&설정
        //무조건 Radio 는 Button 이 아닌 Group 단위로 관리
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //2번째 파라미터로 체크된 RadioButton 의 아이디가 전달됨
                //체크된 버튼객체 참조
                RadioButton rb= findViewById(checkedId);//id 전달
                tv.setText(rb.getText().toString());
            }
        });

        //RatingBar 변경 리스너 생성&추가
        star=findViewById(R.id.star);
        star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // parameter : 선택된 ratingBar, 별점,
                // fromUser-사용자가 바꾼값인지 프로그래머가 설정한 값인지 여부
                tv.setText(rating+"점");
            }
        });
    }//onCreate

    public void clickButton(View v){
        //Bring back checked RadioButton
        //Show the checked RadioButton's text
        int id=rg.getCheckedRadioButtonId();//Id는 int 형
        //(R 장부에 있는 모든 값은 int)
        RadioButton rb=findViewById(id);
        tv.setText(rb.getText().toString());
        //

    }
}
