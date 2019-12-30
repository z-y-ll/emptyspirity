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

}
