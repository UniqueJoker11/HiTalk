package colin.web.hitalkspace.constant;

/**
 * @author LinQiang on 2016/12/19.
 * @reviewer
 */
public class Constant {
    public static class AES {
        //是否需要AES加密
        public static boolean ISAES = true;
        //加密的私钥（16位）
        public static String SKEY="MIICdwIBCSFh1few";

    }
    public static class ERROR{
        //参数为空错误
        public static int PARAMS_EMPTY_ERROR=1001;
    }
}
