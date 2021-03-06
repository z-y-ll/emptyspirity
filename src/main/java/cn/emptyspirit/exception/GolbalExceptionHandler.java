package cn.emptyspirit.exception;

import cn.emptyspirit.global.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GolbalExceptionHandler {

    /**
     * 处理自定义异常：参数异常
     * @return
     */
    @ExceptionHandler(ParamException.class)
    public R paramExceptionHandler(ParamException e) {
        e.printStackTrace();
        return R.error(e.getCode(), e.getMessage());
    }


    /**
     * 处理自定义异常：未登录异常
     * @return
     */
    @ExceptionHandler(UnLoginException.class)
    public R paramExceptionHandler(UnLoginException e) {
        e.printStackTrace();
        return R.error(e.getCode(), e.getMessage());
    }


    /**
     * 根异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R ExceptionHandler(Exception e) {
        e.printStackTrace();
        return R.error(-1, "发生异常");
    }

}
