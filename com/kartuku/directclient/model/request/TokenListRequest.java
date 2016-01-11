package com.kartuku.directclient.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kartuku.directclient.model.Request;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenListRequest
  extends Request
{
  private String ˊ;
  
  public String getMerchantToken()
  {
    return this.merchantToken;
  }
  
  public String getMerchantUserCode()
  {
    return this.ˊ;
  }
  
  public void setMerchantToken(String paramString)
  {
    this.merchantToken = paramString;
  }
  
  public void setMerchantUserCode(String paramString)
  {
    this.ˊ = paramString;
  }
}


/* Location:              /Users/michael/Downloads/dex2jar-2.0/GO_JEK.jar!/com/kartuku/directclient/model/request/TokenListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */