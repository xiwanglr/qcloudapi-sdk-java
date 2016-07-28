package com.qcloud.Module;

import java.util.TreeMap;

public class Live extends Base {
	public Live(){
		serverHost = "live.api.qcloud.com";
	}

	/**
	 * 参数名称	必选	类型	描述
	 channelName	是	字符串型	直播频道的名称
	 channelDescribe	否	字符串型	直播频道描述
	 outputSourceType	是	无符号整型	选择输出源类型(1只有RTMP/flv输出2：只有HLS输出3：有RTMP/FLV HLS输出)
	 playerPassword	否	字符串型	若使用腾讯云播放器，则是设置默认播放器的密码，设置此密码后点击观看时输入密码才可观看
	 sourceList	是	数组型	直播源列表，每个直播源可以包括类型、名称和地址（限用于拉流）注：目前只支持一个直播源
	 watermarkId	否	无符号整型	水印ID
	 outputRate	否	数组型	原画：0 标清：10 高清：20
	 sourceList结构如下：
	 参数名称	必选	类型	描述
	 name	是	string	直播源名称
	 type	是	int	1 rtmp推流
     */
	public String CreateLVBChannel(TreeMap<String,Object> params){
		return call("CreateLVBChannel",params);
	}
}
