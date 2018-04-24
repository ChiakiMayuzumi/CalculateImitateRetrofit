package com.chiakimayuzumi.calculate;

import com.chiakimayuzumi.calculate.annotation.ADD;

/**
 * Created by chiakimayuzumi on 2018/4/24.
 */

public interface ApiService {

    @ADD
    int twoParamsAdd(int params1,int params2);
}
