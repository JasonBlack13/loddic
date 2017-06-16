package com.jsblack.loddic.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.jsblack.loddic.R;
import com.jsblack.loddic.constants.GRADE;
import com.jsblack.loddic.db.DbHelper;
import com.jsblack.loddic.item.Item;
import com.jsblack.loddic.item.ItemObject;
import com.jsblack.loddic.item.ItemUsage;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private DbHelper mDbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new DbHelper(this, "LODDIC_DB", null, 1);

        ArrayList<ItemObject> list = null;
        list = mDbHelper.getAllItems();

        Log.e("MainActivity", "list isNull : "+(list==null));

        // 하나 넣어보기
        String option = "마법공격 45 증가\n체력 9 증가\n공격 속도 3.5% 증가\n치명타 확률 1% 증가\n치명타 데미지 5% 증가";
//        ItemObject obj = new ItemObject(0, "불사조의 지팡이", Item.Grade.MYTH, Item.Type.EQUIP, Item.SubType.마법도구, false, option, null, null);



    }
}
