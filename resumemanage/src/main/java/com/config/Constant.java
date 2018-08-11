package com.config;

public class Constant {
	public final static String SUCCESS = "001"; // 成功
	public final static String FAIL = "002"; // 失败
	public final static String ERROR = "003"; // 系统异常
	public final static String PARAM_ERROR = "004"; // 入参错误
	public final static String PERMISSION_DENIED = "005"; // 权限不足

	public class Dictionary {

		/**
		 * 否
		 */
		public static final String SYS_NO = "sys00";

		/**
		 * 是
		 */
		public static final String SYS_YES = "sys01";

		/**
		 * 停用
		 */
		public static final String SYS_DISABLE = "sys00";

		/**
		 * 启用
		 */
		public static final String SYS_ENABLE = "sys01";

	}

	public class SessionInfo {
		/**
		 * 用户id
		 */
		public static final String U_ID = "u_id";

		/**
		 * 用户姓名
		 */
		public static final String NAME = "name";

	}

	public static class DefaultValue {
		/**
		 * 每页页数
		 */
		public static final int PAGE_SIZE = 15;

	}

	public class FileFolders {
		public static final String TEMP_FOLDER = "upload/temp";
	}
}
