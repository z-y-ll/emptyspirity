package cn.emptyspirit.exception;

public class UnLoginException extends RuntimeException {

    // 错误信息
    private String message = "请先登录!";
    private Integer code = -2;

    public UnLoginException() {
    }

    public UnLoginException(String message) {
        this.message = message;
    }

    public UnLoginException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
