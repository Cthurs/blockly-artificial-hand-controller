package com.google.blockly.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Cha on 2016-12-10.
 */
public class HandControllerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);

        ListView listView=(ListView)findViewById(R.id.listview);

        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.adapter, MyGlobals.getInstance().getData());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(_click);
    }
    AdapterView.OnItemClickListener _click= new AdapterView.OnItemClickListener() {

        //ListView의 아이템 중 하나가 클릭될 때 호출되는 메소드
        //첫번째 파라미터 : 클릭된 아이템을 보여주고 있는 AdapterView 객체(여기서는 ListView객체)
        //두번째 파라미터 : 클릭된 아이템 뷰
        //세번째 파라미터 : 클릭된 아이템의 위치(ListView이 첫번째 아이템(가장위쪽)부터 차례대로 0,1,2,3.....)
        //네번재 파리미터 : 클릭된 아이템의 아이디(특별한 설정이 없다면 세번째 파라이터인 position과 같은 값)
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO Auto-generated method stub

            BTdummy d = new BTdummy(getApplicationContext());

            //한줄을 배열에 담음
            String[] bsArray = MyGlobals.getInstance().getData().get(position).split("\n");

            //한줄에 있는 데이터를 arraylist에 담음
            ArrayList<String[]> mArrayList = new ArrayList<String[]>();
            for (int i=0; i<bsArray.length; i++){
                mArrayList.add(bsArray[i].split("/"));
            }

            //손가락 동작 정의
            for(int i=1; i<mArrayList.size();i++){
                d.dummy(mArrayList.get(i)[0],mArrayList.get(i)[1]);
            }
            //TODO 손가락 동작 전송 메소드 작성
            d.send();

        }
    };

}