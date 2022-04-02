package com.cmpe202.hotels.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * RoomInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-22T20:24:30.862902-07:00[America/Los_Angeles]")
public class RoomInfo   {
  @JsonProperty("roomId")
  private UUID roomId;

  @JsonProperty("roomPhotoUrl")
  private String roomPhotoUrl;

  @JsonProperty("roomFeatures")
  
  private List<String> roomFeatures = new ArrayList<>();

  @JsonProperty("basePrice")
  private BigDecimal basePrice;

  public RoomInfo roomId(UUID roomId) {
    this.roomId = roomId;
    return this;
  }

  /**
   * Get roomId
   * @return roomId
  */
  @ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", required = true, value = "")
  public UUID getRoomId() {
    return roomId;
  }

  public void setRoomId(UUID roomId) {
    this.roomId = roomId;
  }

  public RoomInfo roomPhotoUrl(String roomPhotoUrl) {
    this.roomPhotoUrl = roomPhotoUrl;
    return this;
  }

  /**
   * Get roomPhotoUrl
   * @return roomPhotoUrl
  */
  @ApiModelProperty(required = true, value = "")
  public String getRoomPhotoUrl() {
    return roomPhotoUrl;
  }

  public void setRoomPhotoUrl(String roomPhotoUrl) {
    this.roomPhotoUrl = roomPhotoUrl;
  }

  public RoomInfo roomFeatures(List<String> roomFeatures) {
    this.roomFeatures = roomFeatures;
    return this;
  }

  public RoomInfo addRoomFeaturesItem(String roomFeaturesItem) {
    if (this.roomFeatures == null) {
      this.roomFeatures = new ArrayList<>();
    }
    this.roomFeatures.add(roomFeaturesItem);
    return this;
  }

  /**
   * Get roomFeatures
   * @return roomFeatures
  */
  @ApiModelProperty(required = true, value = "")
  public List<String> getRoomFeatures() {
    return roomFeatures;
  }

  public void setRoomFeatures(List<String> roomFeatures) {
    this.roomFeatures = roomFeatures;
  }

  public RoomInfo basePrice(BigDecimal basePrice) {
    this.basePrice = basePrice;
    return this;
  }

  /**
   * Get basePrice
   * @return basePrice
  */
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(BigDecimal basePrice) {
    this.basePrice = basePrice;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoomInfo roomInfo = (RoomInfo) o;
    return Objects.equals(this.roomId, roomInfo.roomId) &&
        Objects.equals(this.roomPhotoUrl, roomInfo.roomPhotoUrl) &&
        Objects.equals(this.roomFeatures, roomInfo.roomFeatures) &&
        Objects.equals(this.basePrice, roomInfo.basePrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roomId, roomPhotoUrl, roomFeatures, basePrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoomInfo {\n");
    
    sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
    sb.append("    roomPhotoUrl: ").append(toIndentedString(roomPhotoUrl)).append("\n");
    sb.append("    roomFeatures: ").append(toIndentedString(roomFeatures)).append("\n");
    sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
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

