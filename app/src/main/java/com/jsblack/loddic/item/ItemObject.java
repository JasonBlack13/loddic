package com.jsblack.loddic.item;

/**
 * Created by jspark on 2017. 6. 15..
 */

public class ItemObject {

    // 기본정보. 공통.
    private int id; // 고유 아이디 값

    private String name;

    private int grade;

    // 분류 : 장착 광석 보석 유물 재료 기타
    private Item.Type type;

    // 상세분류
    private Item.SubType subType;

    // 경매가능 여부
    private boolean isAuction;

    // 장착능력 (장착 아이템에만 있음)
    private String option;

    // 사용처
    private ItemUsage usage;

    // 습득처
    private ItemAcquire acquire;

    public ItemObject(){

    }

    public ItemObject(int id, String name, int grade, Item.Type type, Item.SubType subType, boolean isAuction, String option, ItemUsage usage, ItemAcquire acquire){
        setId(id);
        setName(name);
        setGrade(grade);
        setType(type);
        setSubType(subType);
        setAuction(isAuction);
        setOption(option);
        setUsage(usage);
        setAcquire(acquire);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Item.Type getType() {
        return type;
    }

    public void setType(Item.Type type) {
        this.type = type;
    }

    public Item.SubType getSubType() {
        return subType;
    }

    public void setSubType(Item.SubType subType) {
        this.subType = subType;
    }

    public boolean isAuction() {
        return isAuction;
    }

    public void setAuction(boolean auction) {
        isAuction = auction;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public ItemUsage getUsage() {
        return usage;
    }

    public void setUsage(ItemUsage usage) {
        this.usage = usage;
    }

    public ItemAcquire getAcquire() {
        return acquire;
    }

    public void setAcquire(ItemAcquire acquire) {
        this.acquire = acquire;
    }

    public String toString(){
        return "";
    }
}
