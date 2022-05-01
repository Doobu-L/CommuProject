package com.ks.community.response;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseResponse {
  private String rspCode;
  private String rspMsg;

  public BaseResponse(){
    this.rspCode = String.valueOf(HttpStatus.OK.value());
  }

  public BaseResponse(String rspCode,String rspMsg){
    this.rspCode = rspCode;
    this.rspMsg  = rspMsg;
  }
}
