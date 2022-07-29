package com.sparta.northwingapi.dto;

import com.sparta.northwingapi.entity.OrderEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class OrderEntityDto implements Serializable {

    private OrderEntity order;

    private final Integer id;
    private final Instant orderDate;
    private final Instant requiredDate;
    private final Instant shippedDate;
    private final BigDecimal freight;
    private final String shipName;
    private final String shipAddress;
    private final String shipCity;
    private final String shipRegion;
    private final String shipPostalCode;
    private final String shipCountry;

    public OrderEntityDto(OrderEntity orderEntity) {
        this.id = orderEntity.getId();
        this.orderDate = orderEntity.getOrderDate();
        this.requiredDate = orderEntity.getRequiredDate();
        this.shippedDate = orderEntity.getShippedDate();
        this.freight = orderEntity.getFreight();
        this.shipName = orderEntity.getShipName();
        this.shipAddress = orderEntity.getShipAddress();
        this.shipCity = orderEntity.getShipCity();
        this.shipRegion = orderEntity.getShipRegion();
        this.shipPostalCode = orderEntity.getShipPostalCode();
        this.shipCountry = orderEntity.getShipCountry();
    }

    public Integer getId() {
        return id;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public Instant getRequiredDate() {
        return requiredDate;
    }

    public Instant getShippedDate() {
        return shippedDate;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public String getShipName() {
        return shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntityDto entity = (OrderEntityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.orderDate, entity.orderDate) &&
                Objects.equals(this.requiredDate, entity.requiredDate) &&
                Objects.equals(this.shippedDate, entity.shippedDate) &&
                Objects.equals(this.freight, entity.freight) &&
                Objects.equals(this.shipName, entity.shipName) &&
                Objects.equals(this.shipAddress, entity.shipAddress) &&
                Objects.equals(this.shipCity, entity.shipCity) &&
                Objects.equals(this.shipRegion, entity.shipRegion) &&
                Objects.equals(this.shipPostalCode, entity.shipPostalCode) &&
                Objects.equals(this.shipCountry, entity.shipCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, requiredDate, shippedDate, freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "orderDate = " + orderDate + ", " +
                "requiredDate = " + requiredDate + ", " +
                "shippedDate = " + shippedDate + ", " +
                "freight = " + freight + ", " +
                "shipName = " + shipName + ", " +
                "shipAddress = " + shipAddress + ", " +
                "shipCity = " + shipCity + ", " +
                "shipRegion = " + shipRegion + ", " +
                "shipPostalCode = " + shipPostalCode + ", " +
                "shipCountry = " + shipCountry + ")";
    }
}
