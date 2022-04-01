package com.popper.daw.bean;

/**
 * @author dd8
 * @project DAW
 * @date 31/3/2022 3:40 下午
 * desc   :
 */
public class LoginResponseBean {
    private int code;
    private String msg;
    private String token;

    public LoginResponseBean(int code, String msg, String token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponseBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
