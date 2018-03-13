package com.wsq.library.utils;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class AmountUtils {

    /**
     * 将分转换成元
     * @param strF
     * @return
     * @throws Exception
     */
    public static String F2Y(String strF)throws Exception{
        if(DataFormat.isNumber(strF)){

            double d = DataFormat.getFloat(strF);
            double newd = d * 100;
            BigDecimal bg = new BigDecimal(newd);
            double d1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return  d1+"";
        }else {
            throw new Exception("请输入正确的数字");
        }
    }


    /**
     * 保留两位小数
     * @param str
     * @return
     * @throws Exception
     */
    public static String S2P(String str)throws Exception{
        if(DataFormat.isNumber(str)){

            double d = DataFormat.getFloat(str);
            BigDecimal bg = new BigDecimal(d);
            double d1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return  d1+"";
        }else {
            throw new Exception("请输入正确的数字");
        }
    }
}
