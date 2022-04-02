package com.cmpe202.hotels.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * HotelInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-22T20:24:30.862902-07:00[America/Los_Angeles]")
public class HotelInfo   {
  @JsonProperty("hotelId")
  private UUID hotelId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("zipcode")
  private String zipcode;

  @JsonProperty("address")
  private String address;

  @JsonProperty("rooms")
  
  private List<RoomInfo> rooms = new ArrayList<>();

  public HotelInfo hotelId(UUID hotelId) {
    this.hotelId = hotelId;
    return this;
  }

  /**
   * Get hotelId
   * @return hotelId
  */
  @ApiModelProperty(example = "d290f1ee-6c54-4b01-90e6-d701748f0851", required = true, value = "")
  public UUID getHotelId() {
    return hotelId;
  }

  public void setHotelId(UUID hotelId) {
    this.hotelId = hotelId;
  }

  public HotelInfo name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "Any acceptable name of the hotel", required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HotelInfo zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  /**
   * Get zipcode
   * @return zipcode
  */
  @ApiModelProperty(required = true, value = "")
  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public HotelInfo address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(required = true, value = "")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public HotelInfo rooms(List<RoomInfo> rooms) {
    this.rooms = rooms;
    return this;
  }

  public HotelInfo addRoomsItem(RoomInfo roomsItem) {
    if (this.rooms == null) {
      this.rooms = new ArrayList<>();
    }
    this.rooms.add(roomsItem);
    return this;
  }

  /**
   * Get rooms
   * @return rooms
  */
  @ApiModelProperty(required = true, value = "")
  public List<RoomInfo> getRooms() {
    return rooms;
  }

  public void setRooms(List<RoomInfo> rooms) {
    this.rooms = rooms;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HotelInfo hotelInfo = (HotelInfo) o;
    return Objects.equals(this.hotelId, hotelInfo.hotelId) &&
        Objects.equals(this.name, hotelInfo.name) &&
        Objects.equals(this.zipcode, hotelInfo.zipcode) &&
        Objects.equals(this.address, hotelInfo.address) &&
        Objects.equals(this.rooms, hotelInfo.rooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hotelId, name, zipcode, address, rooms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HotelInfo {\n");
    
    sb.append("    hotelId: ").append(toIndentedString(hotelId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    rooms: ").append(toIndentedString(rooms)).append("\n");
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

