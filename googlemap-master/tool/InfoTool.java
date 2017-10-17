package tool;

import downloadmap.Download;

//客户端状态
public class InfoTool {
	//休眠
	public static boolean isSleep = false;
	//下载
	public static boolean isDownload = false;
	//任务数量
	public static int taskNum = 0;
	//下载区域
	public static Download download = null;
	//客户端完整任务
	public static int completeTask = 0;
	//服务器完整任务
	public static int serverCompleteTask = 0;
	//省id
	public static int county_ID = 0;
	//下载路径
	public static String path = null;
}