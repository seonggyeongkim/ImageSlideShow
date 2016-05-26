package kr.hs.emirim.duckbill0316.imageslideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ // mainactivity를 핸들러 처리하는 감시자로 만듬
                                                   //추상 메소드를 상속 받아서 사용함!

    ViewFlipper flip; //1. 먼저 멤버변수 선언! (전역 변수로 선언)
    TextView editTime;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flip=(ViewFlipper) findViewById(R.id.view_flip); //2. 멤버변수 값 지정!
        //flip.setFlipInterval(1000);//3. 멤버 변수 참조! (1초 후)

        editTime=(EditText)findViewById(R.id.edit_time); // 값 선언

        Button butStart=(Button)findViewById(R.id.but_start); //이벤트 발생 시키기
        butStart.setOnClickListener(this); // 이벤트 핸들러(감시자) , 메인 액티비티를 사용하여 만듬!

        Button butStop=(Button)findViewById(R.id.but_spot);
        butStop.setOnClickListener(this);



    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) { //view v 매개 변수

        switch (v.getId()) //v.getId()를 사용하여 id 값 받아옴
        {
            case R.id.but_start :
                time=(int)(Double.parseDouble(editTime.getText().toString())*1000);
                flip.setFlipInterval(time);
                flip.startFlipping();
                break;
            case R.id.but_spot :
                flip.stopFlipping();
                break;

        }

    }
}
