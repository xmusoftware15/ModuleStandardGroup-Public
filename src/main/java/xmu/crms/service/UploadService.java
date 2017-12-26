package xmu.crms.service;

import java.math.BigInteger;


/**
 * 
 * @author AiXing
 * @version 2.20
 *
 */

public interface UploadService {


	    /**
	     * 上传选课名单
	     * <p>老师上传本班级的学生名单<br>
	     * @param classId 班级Id
	     * @param pathName 文件路径
	     */
	    public void uploadRoster(BigInteger classId,String pathName);
	    
	    /**
	     * 上传小组报告
	     * <p>上传讨论课的报告<br>
	     * @param seminaId 讨论课Id
	     * @param pathName 文件路径
	     */
	    public void uploadReport(BigInteger seminaId,String pathName);
	    
	    /**
	     * 上传用户头像名单
	     * <p>上传用户头像<br>
	     * @param userId 用户ID
	     * @param pathName 文件路径
	     */
	    public void uploadAvater(BigInteger userId,String pathName);

}
