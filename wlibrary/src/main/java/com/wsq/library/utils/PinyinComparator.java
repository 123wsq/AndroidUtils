package com.wsq.library.utils;

import com.wsq.library.bean.CityInfoBean;

import java.util.Comparator;

public class PinyinComparator implements Comparator<CityInfoBean> {

	public int compare(CityInfoBean o1, CityInfoBean o2) {
		if (o1.getCity_logogram().equals("@")
				|| o2.getCity_logogram().equals("#")) {
			return 1;
		} else if (o1.getCity_logogram().equals("#")
				|| o2.getCity_logogram().equals("@")) {
			return -1;
		} else {
			return o1.getCity_logogram().compareTo(o2.getCity_logogram());
		}
	}

}
