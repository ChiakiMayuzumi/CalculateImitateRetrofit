package com.chiakimayuzumi.calculate;

import android.text.TextUtils;

import com.chiakimayuzumi.calculate.annotation.ADD;
import com.chiakimayuzumi.calculate.annotation.DIV;
import com.chiakimayuzumi.calculate.annotation.MUL;
import com.chiakimayuzumi.calculate.annotation.SUB;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * Created by chiakimayuzmi on 2018/4/24.
 * 每一个计算单元包含的东西
 */

public class CalculateCell implements Null{

    private String calculateType;

    private ArrayList<Integer> calculateParams;

    public CalculateCell(Annotation type, Object[] params) {
        if (type instanceof ADD) {
            this.calculateType = "ADD";
        } else if (type instanceof SUB) {
            this.calculateType = "SUB";
        } else if (type instanceof MUL) {
            this.calculateType = "MUL";
        } else if (type instanceof DIV) {
            this.calculateType = "DIV";
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Object o : params) {
            arrayList.add(Integer.valueOf(o.toString()));
        }
        this.calculateParams = arrayList;
    }

    public String getCalculateType() {
        return calculateType;
    }

    public ArrayList<Integer> getCalculateParams() {
        return calculateParams;
    }

    @Override
    public boolean isNull() {
        if (TextUtils.isEmpty(calculateType)) return true;
        if (null == calculateParams || calculateParams.size() <= 0) return true;
        return false;
    }
}
