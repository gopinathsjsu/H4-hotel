package com.cmpe202.hotels.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;

/**
 * ReservationInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-22T20:24:30.862902-07:00[America/Los_Angeles]")
public class ReservationInfo   {
  @JsonProperty("reservationId")
  private UUID reservationId;

  @JsonProperty("roomId")
  private UUID roomId;

  @JsonProperty("hotelId")
  private UUID hotelId;

  @JsonProperty("accountId")
  private UUID accountId;

  @JsonProperty("roomInfo")
  private RoomInfo roomInfo;

  @JsonProperty("hotelInfo")
  private HotelInfo hotelInfo;

  public ReservationInfo reservationId(UUID reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * Get reservationId
   * @return reservationId
  */
  @ApiModelProperty(required = true, value = "")
  public UUID getReservationId() {
    return reservationId;
  }

  public void setReservationId(UUID reservationId) {
    this.reservationId = reservationId;
  }

  public ReservationInfo roomId(UUID roomId) {
    this.roomId = roomId;
    return this;
  }

  /**
   * Get roomId
   * @return roomId
  */
  @ApiModelProperty(required = true, value = "")
  public UUID getRoomId() {
    return roomId;
  }

  public void setRoomId(UUID roomId) {
    this.roomId = roomId;
  }

  public ReservationInfo hotelId(UUID hotelId) {
    this.hotelId = hotelId;
    return this;
  }

  /**
   * Get hotelId
   * @return hotelId
  */
  @ApiModelProperty(required = true, value = "")
  public UUID getHotelId() {
    return hotelId;
  }

  public void setHotelId(UUID hotelId) {
    this.hotelId = hotelId;
  }

  public ReservationInfo accountId(UUID accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  */
  @ApiModelProperty(required = true, value = "")
  public UUID getAccountId() {
    return accountId;
  }

  public void setAccountId(UUID accountId) {
    this.accountId = accountId;
  }

  public ReservationInfo roomInfo(RoomInfo roomInfo) {
    this.roomInfo = roomInfo;
    return this;
  }

  /**
   * Get roomInfo
   * @return roomInfo
  */
  @ApiModelProperty(required = true, value = "")
  public RoomInfo getRoomInfo() {
    return roomInfo;
  }

  public void setRoomInfo(RoomInfo roomInfo) {
    this.roomInfo = roomInfo;
  }

  public ReservationInfo hotelInfo(HotelInfo hotelInfo) {
    this.hotelInfo = hotelInfo;
    return this;
  }

  /**
   * Get hotelInfo
   * @return hotelInfo
  */
  @ApiModelProperty(required = true, value = "")
  public HotelInfo getHotelInfo() {
    return hotelInfo;
  }

  public void setHotelInfo(HotelInfo hotelInfo) {
    this.hotelInfo = hotelInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationInfo reservationInfo = (ReservationInfo) o;
    return Objects.equals(this.reservationId, reservationInfo.reservationId) &&
        Objects.equals(this.roomId, reservationInfo.roomId) &&
        Objects.equals(this.hotelId, reservationInfo.hotelId) &&
        Objects.equals(this.accountId, reservationInfo.accountId) &&
        Objects.equals(this.roomInfo, reservationInfo.roomInfo) &&
        Objects.equals(this.hotelInfo, reservationInfo.hotelInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservationId, roomId, hotelId, accountId, roomInfo, hotelInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationInfo {\n");
    
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
    sb.append("    hotelId: ").append(toIndentedString(hotelId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    roomInfo: ").append(toIndentedString(roomInfo)).append("\n");
    sb.append("    hotelInfo: ").append(toIndentedString(hotelInfo)).append("\n");
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

