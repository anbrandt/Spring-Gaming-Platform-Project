package com.sda.gamingplatform.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "spins")
public class Spin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String user_id;
    private String user_bet;
    private String payback;
    private String field_drawn;

    public Spin(String user_id, String user_bet, String payback, String field_drawn) {
        this.user_id = user_id;
        this.user_bet = user_bet;
        this.payback = payback;
        this.field_drawn = field_drawn;
    }

    public Spin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_bet() {
        return user_bet;
    }

    public void setUser_bet(String user_bet) {
        this.user_bet = user_bet;
    }

    public String getPayback() {
        return payback;
    }

    public void setPayback(String payback) {
        this.payback = payback;
    }

    public String getField_drawn() {
        return field_drawn;
    }

    public void setField_drawn(String field_drawn) {
        this.field_drawn = field_drawn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spin spin = (Spin) o;

        return Objects.equals(user_id, spin.user_id) && Objects.equals(user_bet, spin.user_bet) &&
                Objects.equals(payback, spin.payback) && Objects.equals(field_drawn, spin.field_drawn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_bet, payback, field_drawn);
    }
}
