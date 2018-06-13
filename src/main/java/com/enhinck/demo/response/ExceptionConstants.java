package com.enhinck.demo.response;


public final class ExceptionConstants {
    public static final ResultEnums USERS_NOT_LOGIN = ResultEnums._100000;
    public static final ResultEnums USERS_LOGIN_USERNAME_OR_PASSWORD_ERROR = ResultEnums._100001;
    public static final ResultEnums USERS_UPDATE_USER_NOT_EXIST = ResultEnums._100002;
    public static final ResultEnums USERS_REG_MOBILE_PHONE_CANT_NULL = ResultEnums._100003;
    public static final ResultEnums USERS_MOBILE_PASSWORD_CANT_NULL = ResultEnums._100004;
    public static final ResultEnums USERS_QUERY_USER_NOT_EXISTS = ResultEnums._100006;
    public static final ResultEnums USERS_USERID_IS_NULL = ResultEnums._100007;
    public static final ResultEnums USERS_TOKEN_CACHE_IS_NULL = ResultEnums._100008;
    public static final ResultEnums USERS_LOGIN_PARA_ERROR = ResultEnums._100009;
    public static final ResultEnums MOBILE_PHONE_NUM_FORMAT_ERROR = ResultEnums._100010;
    public static final ResultEnums SEND_SMS_EXCEPTION = ResultEnums._100011;
    public static final ResultEnums USERS_VERIFY_CODE_ERROR = ResultEnums._100012;
    public static final ResultEnums USERS_VERIFY_CODE_TIMEOUT = ResultEnums._100013;
    public static final ResultEnums USERS_VERIFY_CODE_ERROR_TIMES_MAX = ResultEnums._100014;
    public static final ResultEnums USERS_LOGIN_AT_OTHER_TERMINAL = ResultEnums._100015;
    public static final ResultEnums USER_NOT_EXSIT = ResultEnums._100016;
    public static final ResultEnums IS_NOT_VALID_TOKEN = ResultEnums._100017;
    public static final ResultEnums USERS_VERIFY_CODE_NOT_EXSIT = ResultEnums._100017;
    public static final ResultEnums USERS_IS_EXIST = ResultEnums._100020;
    public static final ResultEnums HOUSE_ALREADY_LOCK = ResultEnums._200001;
    public static final ResultEnums HOUSE_LOCKIING = ResultEnums._200002;
    public static final ResultEnums HOUSE_ALREADY_RESERVER = ResultEnums._200003;
    public static final ResultEnums HOUSE_RESERVEING = ResultEnums._200004;
    public static final ResultEnums FAVORITE_EXCEED = ResultEnums._200005;
    public static final ResultEnums DATABASE_ERROR = ResultEnums._200006;
    public static final ResultEnums FAVORITE_DUPLICATE = ResultEnums._200007;
    public static final ResultEnums USER_UNIQUE_ORDER = ResultEnums._200008;
    public static final ResultEnums NOW_LESS_THEN_OPEN_TIME = ResultEnums._200009;
    public static final ResultEnums TEST_DATE_ALREADY_PASS = ResultEnums._200010;
    public static final ResultEnums OPEN_DATE_ALREADY_PASS = ResultEnums._200011;
    public static final ResultEnums EXP_DATE_ALREADY_PASS = ResultEnums._200012;
    public static final ResultEnums FORBIDEN_PROJECT = ResultEnums._200013;
    public static final ResultEnums CAN_NOT_FIND_PROJECT = ResultEnums._200014;
    public static final ResultEnums RESIDENT_ALREADY_ADD = ResultEnums._200015;
    public static final ResultEnums RESIDENT_NOT_REGISTER = ResultEnums._200019;
    public static final ResultEnums RESIDENT_HAS_PUSHKEY = ResultEnums._200020;
    public static final ResultEnums CUSTOMER_NOT_INITIALIZATION = ResultEnums._200021;
    public static final ResultEnums USER_NOT_PERMISSION = ResultEnums._200022;
    public static final ResultEnums NOT_METER_READING = ResultEnums._200023;
    public static final ResultEnums NOT_SEND_BILL = ResultEnums._200024;
    public static final ResultEnums ADD_ENTRANCE_ERROR = ResultEnums._200025;
    public static final ResultEnums ADD_ENTRANCE_GROUP_ERROR = ResultEnums._200026;
    public static final ResultEnums MODIAN_CREATE_FAIL = ResultEnums._300000;
    public static final ResultEnums MODIAN_BIND_PROJECT_FAIL = ResultEnums._300001;
    public static final ResultEnums MODIAN_BIND_BUILDING_FAIL = ResultEnums._300002;
    public static final ResultEnums ADD_ORG_CALLBACK = ResultEnums._300003;
    public static final ResultEnums MODIAN_SIGN_CHECK_FAIL = ResultEnums._300004;
    public static final ResultEnums MODIAN_NO_GROUP = ResultEnums._300005;
    public static final ResultEnums MODIAN_INVALID_AUTH_TIME = ResultEnums._01030020029;
    public static final ResultEnums MODIAN_FACE_INVALID = ResultEnums._01010021003;
    public static final ResultEnums MODIAN_FACE_TOSMALL = ResultEnums._01010021004;
    public static final ResultEnums MODIAN_MEMBER_STATUS_ERROR = ResultEnums._01010021005;
    public static final ResultEnums MODIAN_FACE_SAVE_ERROR = ResultEnums._01020021006;
    public static final ResultEnums MODIAN_AUTHTIME_SET_ERROR = ResultEnums._01020021007;
    public static final ResultEnums MODIAN_NOT_SUPPORT_OPERATION = ResultEnums._01120021011;
    public static final ResultEnums MODIAN_OPERATION_ERROR = ResultEnums._01020021012;
    public static final ResultEnums MODIAN_NOT_FIND_FACE = ResultEnums._01010021013;
    public static final ResultEnums MODIAN_UDANGLE_ERROR = ResultEnums._01010021014;
    public static final ResultEnums MODIAN_LRANGLE_ERROR = ResultEnums._01010021014;
    public static final ResultEnums MODIAN_NOT_DIND_APP = ResultEnums._010170018;
    public static final ResultEnums MODIAN_NOT_AUTH_API = ResultEnums._010170020;
    public static final ResultEnums MODIAN_INVALID_TOKEN = ResultEnums._010170022;
    public static final ResultEnums MODIAN_NOT_AUTH_MODULAR = ResultEnums._010170023;
    public static final ResultEnums MODIAN_NOT_AUTH_ORG = ResultEnums._010170024;
    public static final ResultEnums MODIAN_OUT_ORG_NUM = ResultEnums._010170024;
    public static final ResultEnums DEVICE_TYPE_ERROR = ResultEnums._400000;
    public static final ResultEnums SYSTEM_CHANNEL_CODE_ILLEGAL = ResultEnums._999975;
    public static final ResultEnums SYSTEM_CLIENT_NEED_UPDATE = ResultEnums._999976;
    public static final ResultEnums SYSTEM_MISS_REQUIRED_HTTP_HEADER = ResultEnums._999977;
    public static final ResultEnums SYSTEM_ILLEGAL_REQUEST_PARAMETERS = ResultEnums._999978;
    public static final ResultEnums SYSTEM_MISSING_REQUEST_PARAMETERS = ResultEnums._999979;
    public static final ResultEnums SYSTEM_RETURN_OBJECT_TYPE_ERROR = ResultEnums._999980;
    public static final ResultEnums SYSTEM_CALL_REMOTE_SERVICE_TIME_OUT = ResultEnums._999981;
    public static final ResultEnums SYSTEM_REMOTE_SERVICE_NOT_FOUND = ResultEnums._999982;
    public static final ResultEnums SYSTEM_NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION = ResultEnums._999983;
    public static final ResultEnums SYSTEM_HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION = ResultEnums._999984;
    public static final ResultEnums SYSTEM_HTTP_MEDIATYPE_NOT_SUPPORTED_EXCEPTION = ResultEnums._999985;
    public static final ResultEnums SYSTEM_HTTP_MEDIATYPE_NOT_ACCEPTABLE_EXCEPTION = ResultEnums._999986;
    public static final ResultEnums SYSTEM_MISSING_PATHVARIABLE_EXCEPTION = ResultEnums._999987;
    public static final ResultEnums SYSTEM_MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION = ResultEnums._999988;
    public static final ResultEnums SYSTEM_SERVLET_REQUEST_BINDING_EXCEPTION = ResultEnums._999989;
    public static final ResultEnums SYSTEM_CONVERSION_NOT_SUPPORTED_EXCEPTION = ResultEnums._999990;
    public static final ResultEnums SYSTEM_TYPE_MISMATCH_EXCEPTION = ResultEnums._999991;
    public static final ResultEnums SYSTEM_HTTP_MESSAGE_NOT_READABLE_EXCEPTION = ResultEnums._999992;
    public static final ResultEnums SYSTEM_HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION = ResultEnums._999993;
    public static final ResultEnums SYSTEM_METHOD_ARGUMENT_NOT_VALID_EXCEPTION = ResultEnums._999994;
    public static final ResultEnums SYSTEM_MISSING_SERVLET_REQUEST_PART_EXCEPTION = ResultEnums._999995;
    public static final ResultEnums SYSTEM_BIND_EXCEPTION = ResultEnums._999996;
    public static final ResultEnums SYSTEM_NULL_POINTER_EXCEPTION = ResultEnums._999997;
    public static final ResultEnums SYSTEM_SQL_EXCEPTION = ResultEnums._999998;
    public static final ResultEnums SYSTEM_OTHER_EXCEPTION = ResultEnums._999999;
    private ExceptionConstants() {
    }


    public enum ResultEnums {
        /* ===============================用户模块相关异常，10开头=======================*/
        _100000("未登录或登录超时，请重新登录"),
        _100001("登录用户名或密码错误"),
        _100002("要更新的用户信息不存在"),
        _100003("注册时用户手机号不能为空"),
        _100004("注册时密码不能为空"),
        _100005("注册时昵称、性别不能为空"),
        _100006("要查询的用户信息不存在"),
        _100007("用户ID不能空"),
        _100008("Token不能为空"),
        _100009("您输入的信息有误，请联系置业顾问进行修改."),
        _100010("手机号格式错误"),
        _100011("发送验证码错误"),
        _100012("验证码错误"),
        _100013("验证码错误，请重新输入"),
        _100014("输入超过指定错误次数"),
        _100015("用户已在其他设备登录"),
        _100016("此手机号码不存在此系统,请确认"),
        _100017("token无效"),
        _100018("验证码不能为空"),
        _100019("该用户无此权限"),
        _100020("该用户已存在"),
        _200001("该房源被选择中，还有机会哦"),
        _200002("其他客户正在锁定此房源中"),
        _200003("此房已售出，请选择其他房源"),
        _200004("其他用户正在预定此房源中"),
        _200005("已超出收藏限制数，最多每人收藏5套"),
        _200006("数据库异常"),
        _200007("不能收藏相同房源"),
        _200008("你已经选房，不能再选"),
        _200009("还没到开盘时间，请稍等"),
        _200010("已过公测时间。"),
        _200011("已过开盘时间。"),
        _200012("已过体验时间。"),
        _200013("此项目已被禁用。"),
        _200014("找不到对应的项目ID"),
        _200015("该住户已添加"),

        _200019("该住户未注册"),
        _200020("已发送钥匙"),
        _200021("用户还未初始化"),
        _200022("无此操作权限"),
        _200023("未进行抄表，不可发送账单"),
        _200024("账单未发送，请发送后再进行收租操作"),
        _200025("添加门禁失败,请检查门禁名是否重复"),
        _200026("添加门禁分组失败,请检查门禁分组名是否重复"),
        /* ===============================魔点对接相关异常，30开头=======================*/
        _300000("魔点-创建用户失败"),
        _300001("魔点-用户绑定项目失败"),
        _300002("魔点-用户绑定楼幢失败"),
        _300003("魔点- 注册回调失败"),
        _300004("魔点- 签名校验不通过"),
        _300005("魔点- 未找到楼幢或项目对应的群组"),

        _01030020029("授权时间配置无效或格式不正确"),
        _01010021003("面部图片质量不达标"),
        _01010021004("面部图片大小不达标"),
        _01010021005("用户状态不正确，不能进行相应的操作"),
        _01020021006("人脸图片保存失败"),
        _01020021007("授权详细时间设定无效"),
        _01120021011("不支持的操作"),
        _01020021012("操作失败"),
        _01010021013("未找到人脸"),
        _01010021014("人脸上下角度不达标"),
        _01010021015("人脸左右角度不达标"),
        _010170018("APP不存在"),
        _010170020("没有接口调用权限"),
        _010170022("token无效"),
        _010170023("模块没有授权"),
        _010170024("org没有授权"),
        _010170029("创建org超过限制"),
        /* ===============================设备状态=======================*/
        _400000("设备编辑成功，但当前警员已分配同类型设备，绑定失败！"),

        /* ===============================系统相关异常，99开头=========================*/
        _999975("非法的渠道参数。"),
        _999976("您的客户端需要升级之后才可以继续使用，请到AppStore上下载最新版本。"),
        _999977("缺少必填的http请求头或格式不正确"),
        _999978("非法的请求参数"),
        _999979("缺少必填参数"),
        _999980("接口的返回值不是BaseVO对象的子类，请联系接口开发人员处理"),
        _999981("远程服务调用超时"),
        _999982("远程服务未找到"),
        _999983("there is no handler method (\"action\" method) for a specific HTTP request"),
        _999984("request handler does not support the specific request method"),
        _999985(
                "client POSTs, PUTs, or PATCHes content of a type not supported by request handler"),
        _999986("the request handler cannot generate a response that is acceptable by the client"),
        _999987(
                "the URI template does not match the path variable name declared on the method parameter"),
        _999988("missing servlet request parameter"),
        _999989(
                "fatal binding exception, thrown when we want to treat binding exceptions as unrecoverable"),
        _999990("no suitable editor or converter can be found for a bean property"),
        _999991("type mismatch when trying to set a bean property"),
        _999992(
                "thrown by {@link HttpMessageConverter} implementations when the {@link HttpMessageConverter#read} method fails"),
        _999993(
                "thrown by {@link HttpMessageConverter} implementations when the {@link HttpMessageConverter#write} method fails"),
        _999994("validation on an argument annotated with {@code @Valid} fails"),
        _999995(
                "raised when the part of a \"multipart/form-data\" request identified by its name cannot be found"),
        _999996("thrown when binding errors are considered fatal"),
        _999997("后台空指针"),
        _999998("数据库异常"),
        _999999("其它系统异常");
        /* ===============================系统模块相关异常，99开头=======================*/
        private String error; // 错误信息

        ResultEnums(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

}
