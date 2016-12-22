package colin.web.hitalkspace.controller.extend;

import colin.web.hitalkspace.controller.base.BaseController;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author LinQiang on 2016/12/16.
 * @reviewer
 */
public class ExtendController extends BaseController {

    /**
     * 返回统一成功的内容
     *
     * @param data
     * @return
     */
    public CommonResponseWrapper returnSuccessResponseInfo(Object data) {
        CommonResponseWrapper wrapper = new CommonResponseWrapper(true, data);
        return wrapper;
    }

    /**
     * 返回统一错误结果
     *
     * @param errorCode
     * @param msg
     * @return
     */
    public CommonResponseWrapper returnErrorResponseInfo(int errorCode, String msg) {
        CommonResponseWrapper wrapper = new CommonResponseWrapper(false, errorCode, msg);
        return wrapper;
    }

    public class CommonResponseWrapper {
        private boolean success;
        private int errorCode;
        private Object data;
        private String msg;

        public CommonResponseWrapper(boolean success, Object data) {
            this.success = success;
            this.data = data;
        }

        public CommonResponseWrapper(boolean success, int errorCode, String msg) {
            this.success = success;
            this.errorCode = errorCode;
            this.msg = msg;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
