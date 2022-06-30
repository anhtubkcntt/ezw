package com.anvui.ezw.model.dto.response;

import lombok.Data;

@Data
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String staffId;

    public JwtResponse(String accessToken, String staffId) {
        this.token = accessToken;
        this.staffId = staffId;
    }
}
