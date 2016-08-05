package com.qcloud.Module;

import com.qcloud.Utilities.SHA1;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;

public class Vod extends Base {
	public Vod(){
		serverHost = "vod.api.qcloud.com";
	}
	
	public String MultipartUploadVodFile(TreeMap<String, Object> params) throws NoSuchAlgorithmException, IOException {
		serverHost = "vod.qcloud.com";
		
		String actionName = "MultipartUploadVodFile";

        String fileName = params.get("file").toString();
        params.remove("file");
        File f= new File(fileName);  
        
        if (!params.containsKey("fileSize")){
        	params.put("fileSize", f.length());
        }
        if (!params.containsKey("fileSha")){
        	params.put("fileSha", SHA1.fileNameToSHA(fileName));
        }
        
        return call(actionName, params, fileName);
	}

	/**获取视频信息，可以根据视频ID、时间段或者状态等获得视频信息列表。
	 * 参数名称	必选	类型	描述
	 fileIds.n	否	String	视频ID列表，暂时不支持批量
	 from	否	String	开始时间，默认为1970-1-1 00:00:00
	 to	否	String	结束时间，默认为 2038-1-1 00:00:00
	 classId	否	Int	视频分类ID，过滤使用
	 status	否	Int	视频状态，过滤使用， -1：未上传完成，不存在；0：初始化，暂未使用；1：审核不通过，暂未使用；2：正常；3：暂停；4：转码中；5：发布中；6：删除中；7：转码失败；100：已删除
	 orderby	否	Int	结果排序，默认按时间降序，0：按时间升序 1：按时间降序
	 pageNo	否	Int	分页页号
	 pageSize	否	Int	分页大小，范围在10-100之间
	 */
	public String DescribeVodInfo(TreeMap<String, Object> params) throws NoSuchAlgorithmException, IOException {
        return call("DescribeVodInfo", params);
	}
	public String DescribeVodPlayUrls(TreeMap<String, Object> params) throws NoSuchAlgorithmException, IOException {
        return call("DescribeVodPlayUrls", params);
	}
}
