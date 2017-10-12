package com.tsunami.egou.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class EOrder {
    private Integer id;

    private String oid;

    private BigDecimal deliverFee;

    private Double payableFee;

    private Double totalPrice;

    private Boolean paymentWay;

    private Boolean paymentCash;

    private Boolean delivery;

    private Boolean isconfirm;

    private Boolean isPaiy;

    private Boolean state;

    private Date createDate;

    private String note;

    private String buyerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public BigDecimal getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }

    public Double getPayableFee() {
        return payableFee;
    }

    public void setPayableFee(Double payableFee) {
        this.payableFee = payableFee;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(Boolean paymentWay) {
        this.paymentWay = paymentWay;
    }

    public Boolean getPaymentCash() {
        return paymentCash;
    }

    public void setPaymentCash(Boolean paymentCash) {
        this.paymentCash = paymentCash;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getIsconfirm() {
        return isconfirm;
    }

    public void setIsconfirm(Boolean isconfirm) {
        this.isconfirm = isconfirm;
    }

    public Boolean getIsPaiy() {
        return isPaiy;
    }

    public void setIsPaiy(Boolean isPaiy) {
        this.isPaiy = isPaiy;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }
}