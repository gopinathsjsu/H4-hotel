package com.cmpe202.hotels.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;

/**
 * AccountInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-22T20:24:30.862902-07:00[America/Los_Angeles]")
public class AccountInfo   {
  @JsonProperty("accountId")
  private UUID accountId;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  @JsonProperty("rewardsPoint")
  private Integer rewardsPoint;

  public AccountInfo accountId(UUID accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  */
  @ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", required = true, value = "")
  public UUID getAccountId() {
    return accountId;
  }

  public void setAccountId(UUID accountId) {
    this.accountId = accountId;
  }

  public AccountInfo username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  @ApiModelProperty(example = "Any acceptable Username", required = true, value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AccountInfo password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(required = true, value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AccountInfo rewardsPoint(Integer rewardsPoint) {
    this.rewardsPoint = rewardsPoint;
    return this;
  }

  /**
   * Get rewardsPoint
   * @return rewardsPoint
  */
  @ApiModelProperty(example = "230", required = true, value = "")
  public Integer getRewardsPoint() {
    return rewardsPoint;
  }

  public void setRewardsPoint(Integer rewardsPoint) {
    this.rewardsPoint = rewardsPoint;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountInfo accountInfo = (AccountInfo) o;
    return Objects.equals(this.accountId, accountInfo.accountId) &&
        Objects.equals(this.username, accountInfo.username) &&
        Objects.equals(this.password, accountInfo.password) &&
        Objects.equals(this.rewardsPoint, accountInfo.rewardsPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, username, password, rewardsPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountInfo {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    rewardsPoint: ").append(toIndentedString(rewardsPoint)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

