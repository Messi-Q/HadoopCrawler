package com.baizhi.pc;

public class UtilCra {
	public static String loc ="赶集网";
	public static String loc_hs ="房天下";
	public static String type_gj ="one";//类型one为赶集
	public static String type_hs="two";//类型two为房天下
	public static String gjUrl ="http://bj.ganji.com/";//赶集官网，爬去到的href或src需要拼接
	public static String hsUrl ="http://zu.fang.com/";//赶集官网，爬去到的href或src需要拼接
	public static String savePostion ="f://img//";//赶集网爬去后的图片信息保存位置
	public static String saveImgTag_1 ="span[class=phoneicon floatl]";//精确定位到手机号图片
	public static String saveImgTag_2 ="span[class=floatl name]";//精确定位到手机号图片
	public static String gj_Tag1 ="dt > a";//精确定位到赶集网的一级URL
	public static String gj_Tag2 ="dd[class=pay]";//精确定位到赶集网的一级URL
	public static String hs_Tag1 ="p[class=title] > a";//精确定位到房天下的一级URL
	public static String hs_Tag2 ="p[class=gray6 mt20] > a > span";//精确定位到房天下的一级URL
}
