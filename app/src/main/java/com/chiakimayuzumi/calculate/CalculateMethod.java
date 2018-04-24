package com.chiakimayuzumi.calculate;

import android.util.Log;

import com.chiakimayuzumi.calculate.annotation.*;

/**
 * Created by chiakimayuzumi on 2018/4/24.
 * 计算方法类
 * 不想被暴露出去
 */

public class CalculateMethod implements Calculate {

    CalculateCell calculateCell;

    public CalculateMethod(CalculateCell calculateCell){
        this.calculateCell = calculateCell;
    }

    @Override
    public int calculate() {
        if (null == calculateCell || calculateCell.isNull()) return 0;
        switch (calculateCell.getCalculateType()) {
            case "ADD":
                int result = 0;
                for(Integer integer:calculateCell.getCalculateParams()){
                    result = result+integer;
                }
                return result;
            case "SUB":
                return 999;
            case "MUL":
                return 999;
            case "DIV":
                return 999;
            default:
                return 999;
        }
    }
}
