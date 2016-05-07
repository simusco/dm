package com.moma.dawnlove;

public enum ErrorCode {

	SUCCESS("1000", "访问成功"),
	UID_ERROR("4001", "登录名不能为空"),
	PWD_ERROR("4002", "密码不能为空"),
	UID_PWD_ERROR("4003", "用户名或密码错误"),
	TOKEN_INVALID("4004", "token参数无效"),
	UPLOAD_ERROR("4005","上传文件错误!"),
	CREATE_CARD_FAILTURE("4006","创建单聊或群聊错误"),
	JOIN_CARD_FAILTURE("4007", "加入聊天室失败"),
	DOWNLOAD_ERROR("4008","下载文件错误"),
	FETCH_CARD_ERROR("4009","获取聊天数据失败"),
	IMAGE_ILLEGAL("4010","图片类容不健康"),
	TEXT_ILLEGAL("4011","文本包含不健康内容"),
	NO_MORE_CARD("4012","没有更多群聊数据"),
	EASEMOB_ERROR("4013","环信服务器出现错误"),
	HTTP_REQUEST_ERROR("4014","网络请求错误"),
	VERIFICATION_CODE_ERROR("4015","获取校验信息错误"),
	PARAM_NOT_PARSE("4016","请求参数异常"),
	QUITE_CARD_ERROR("4017", "退出组失败"),
	USER_NOT_IN_CARD("4018", "用户不在卡片中"),
	VERIFY_CODE_ERROR("4019", "用户验证码错误"),
	USER_HAS_EXISTS("6001","账号已经存在"),
	SERVER_ERROR("5000","服务器异常"),
	LOGIN_ERROR("4020","登陆错误"),
	NOT_FOUND_DATA("7000","数据未找到"),
	FEED_ERROR("8000","给植物喂食失败"), 
	NO_MORE_AMRITA("8001","没有更多的仙露了"), 
	NOT_ENOUGH_BLOOD("8002","已经没有足够的体力进行扫描"),
	USER_NOT_HAS_PLANT("8003","当前用户还没有在养植物"), 
	HAS_MORE_SEED("8004", "植物没有更多种子"),
	PLANT_NOT_GROWTH_UP("8005", "植物还没长成熟,不能移动后花园"),
	ONLY_PLANT_ONE("8006","同时只能养一颗植物"), 
	EXCEED_SUBSCRIBE_UPPER_LIMIT("8007","超过关注人数上限"), 
	SIGN_ERROR("8008","签名错误"), 
	NOT_ENOUGH_PRI("9000", "你没有足够的权限"),
	MESSAGE_QUEUE_BUSY("5001","消息队列太忙"),
	NOT_ENOUGH_MONEY("8009","没有足够的资金"),
	PAY_ERROR("8010", "支付错误"), 
	CREATE_ORDER_ERROR("8011","创建订单失败"),
	USER_NOT_ENOUGH_PLANT("8012","用户仓库没有足够的植物");
	
	public String code, msg;
	
	ErrorCode(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
}
