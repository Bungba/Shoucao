package com.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class fdsa {

	/**
	 * @param 
	 * @throws 
	 */
	public static void main(String[] args) {
		/*List<Integer> ch = new ArrayList<Integer>(); // 用一个List来存放500个小孩
		for (int i = 1; i <= 500; i++) {
			ch.add(i);
		}
		int temp = 0;
		for (int j = 0; j < ch.size(); j++) {// 遍历List
			temp++;// 代表数数
			if (temp == 3) { // 如果是数到3则把这个小孩从List中移除 并从1开始数（temp=0)
				ch.remove(j);
				j--;
				temp = 0;
			}
			if (j == ch.size() - 1)// 如果遍历到最后一个则重新开始遍历 j=-1 因为j++ 所以是从j=0开始重新遍历
				j = -1;
			if (ch.size() == 1)// 最后List的大小为1 则只剩下最后一个小孩 打印出来 结束
			{
				System.out.println(ch.get(0));
				break;
			}
		}*/
		 for (int i = 100; i <= 999; i++) {
	            int geWei, shiWei, baiWei;
	            baiWei = i / 100;
	            shiWei = (i - baiWei * 100) / 10;
	            geWei = i - baiWei * 100 - shiWei * 10;
	            if (i == Math.pow(geWei,3) + Math.pow(shiWei,3) + Math.pow(baiWei,3)) {
	                System.out.println(i);
	            }
	        }
	}

}
