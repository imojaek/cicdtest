package com.CodeSquad.IssueTracker.user.dto;

import lombok.Getter;

@Getter

public class LoginRequest {
    private String userId;
    private String userPassword;
}
