package com.popper.daw.bean;

/**
 * @author dd8
 * @project DAW
 * @date 30/3/2022 5:13 下午
 * desc   :
 */
public class LoginBean {
    private String username;
    private String code;

    public LoginBean(String username, String code) {
        this.username = username;
        this.code = code;
    }
}
