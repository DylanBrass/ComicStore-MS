package com.comicstore.storeservice.datalayer.Store;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Embeddable
public class Address {

    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;

    @SuppressWarnings("unused")
    public Address() {
    }

    public Address(@NotNull String streetAddress, @NotNull String city, @NotNull String province,  @NotNull String postalCode) {

        Objects.requireNonNull(this.streetAddress = streetAddress);
        Objects.requireNonNull(this.city = city);
        Objects.requireNonNull(this.province = province);
        Objects.requireNonNull(this.postalCode = postalCode);

    }


    public @NotNull String getStreetAddress() {
        return streetAddress;
    }

    public @NotNull String getCity() {
        return city;
    }

    public @NotNull String getProvince() {
        return province;
    }



    public @NotNull String getPostalCode() {
        return postalCode;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}