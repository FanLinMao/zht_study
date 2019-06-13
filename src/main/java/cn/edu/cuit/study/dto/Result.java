package cn.edu.cuit.study.dto;

/**
 * dto消息对象
 * @author hl
 * @param <T>
 */
public class Result<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 数据
     */
    private T data;

    /**
     * 信息
     */
    private String message;

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
