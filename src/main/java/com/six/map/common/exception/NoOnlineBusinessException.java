package com.six.map.common.exception;

/**
 * 自定义异常
 *
 * @author zcl<yczclcn@163.com>
 */
public class NoOnlineBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    private int code = 500;

    private Long systemCode;

    public NoOnlineBusinessException(String msg) {
        super(msg);
        this.msg = msg;


        systemCode = System.currentTimeMillis();
    }

    public NoOnlineBusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public NoOnlineBusinessException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public NoOnlineBusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
