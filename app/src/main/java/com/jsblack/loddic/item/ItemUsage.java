package com.jsblack.loddic.item;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jspark on 2017. 6. 15..
 */

public class ItemUsage {
    private final String LOG_TAG = ItemUsage.class.getSimpleName();
    // 동료 - 스킬업
    // 몬스터 - 스킬업
    // 시설 - 업그레이드(거의 마을계획서랑 골드임)
    // 마을 - 확장(거의 마을계획서랑 골드임)
    // 캠프 - 업그레이드(중요도 낮음)
    // 협회 - 투자(중요도 낮음)

    // 아이템이 어따 사용되는지, 거기에 이 아이템 몇개가 필요한지.

    // 주 내용 : 동료승급 던전확장 던전진화 산업연구 아이템관련

    // 동료 - 승급
    // 누구, 등급,

    // 던전 - 확장, 진화

    // 산업 - 연구

    // 아이템
    // 장착템 - 강화, 제련, 제작


    // 누가 (동료 던전 산업 아이템)

    // 무엇을 (승급 확장 진화 연구 강화 제련 제작)

    // 어떻게 (신화로 몇단계로 무엇으로)

    // 동료 : '세오나'를 '신화'로 '승급'할때
    // 던전 : '파티의하늘섬'을 '광란의화늘섬'으로 '진화'
    // 던전 : '파티의하늘섬'을 '5단계'로 '확장'
    // 산업 : '레벨업비용감소'를 '4번째' '연구'
    //

    // 동료승급 : 세오나 불멸 몇개
    // 던전확장 : 파티의하늘섬 3단계 몇개
    // 던전진화 : 파티의하늘섬 -> 광란의하늘섬 몇개
    // 산업연구 : 레벨업 비용 감소 4/5(16%) 몇개
    // 아이템제작 : '옐로그립 아이템 제작 몇개




    private ArrayList<Usage> mList = null;
    // 이게 리스트로 있어야하는데

    public ItemUsage(String str){
        // ex) 동료승급,세오나,불멸/던전확장,파티의하늘섬,6/던전진화,파티의하늘섬,광란의하늘섬

        if(str != null && !(str.isEmpty())){

            String[] splitStr = str.split("/");
            Log.i(LOG_TAG,"splitStr:"+splitStr);


        }else{
            // data가 없음. null 암것두 하지 않음
        }

    }

    public int getUsageSize(){
        if(mList != null){
            return mList.size();
        }else {
            return 0;
        }
    }

    public ArrayList<Usage> getAllUsage(){
        return mList;
    }

//    public Usage getUsage(int index){
//
//    }

    public String toString(){
        if(mList != null){
            String retStr = "";

            for(int i=0; i<mList.size(); i++){
                retStr += (mList.get(i).type+","+mList.get(i).subject+","+mList.get(i).object+","+mList.get(i).amount);

                if(i != (mList.size()-1))
                    retStr += "/";
            }

            return retStr;
        }else {
            return null;
        }
    }

    public class Usage{
        private String type;    // 동료승급 던전확장 던전진화 산업연구 아이템제작
        private String subject; // 어떤거를.
        private String object;  // 어떻게 (승급 확장 진화 연구 제작)
        private String amount;  // 몇개나 필요한지
    }

}
