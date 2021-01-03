package com.bootdo.domain;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tick implements Serializable, Cloneable {
    private LocalDateTime yK;
    private Double yL = 0.0D;
    private Double yM = 0.0D;
    private Double yN = 0.0D;
    private Double yO = 0.0D;
    private Long yP = 0L;
    private Double yQ = 0.0D;
    private Double yR = 0.0D;
    private Long yS = 0L;

    static {
        DateTimeFormatter.ofPattern("yyyy/MM/dd,HH:mm");
//        DateTimeFormatter.ofPattern("yyyy/MM/dd");
        new DecimalFormat("0.000");
//        new DecimalFormat("0.00");
    }

    public final LocalDateTime mf() {
        return this.yK;
    }

    public final void a(LocalDateTime date) {
        this.yK = date;
    }

    public final Double mg() {
        return this.yL;
    }

    public final void a(Double open) {
        this.yL = open;
    }

    public final Double mh() {
        return this.yM;
    }

    public final void b(Double high) {
        this.yM = high;
    }

    public final Double mi() {
        return this.yN;
    }

    public final void c(Double low) {
        this.yN = low;
    }

    public final Double mj() {
        return this.yO;
    }

    public final void d(Double close) {
        this.yO = close;
    }

    public final Long mk() {
        return this.yP;
    }

    public final void a(Long volume) {
        this.yP = volume;
    }

    public final Double ml() {
        return this.yQ;
    }

    public final void e(Double amount) {
        this.yQ = amount;
    }

    public final Double mm() {
        return this.yR;
    }

    public final void f(Double balance) {
        this.yR = balance;
    }

    public final int hashCode() {
        int result;
        return result = 31 + (this.yK == null ? 0 : this.yK.hashCode());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Tick other = (Tick) obj;
            if (this.yK == null) {
                if (other.yK != null) {
                    return false;
                }
            } else if (!this.yK.equals(other.yK)) {
                return false;
            }

            return true;
        }
    }

    public final String toString() {
        return String.format("%tF %tT, %.5f, %.5f, %.5f, %.5f, %d, %.5f, %d, %.2f", this.yK, this.yK, this.yL, this.yM, this.yN, this.yO, this.yP, this.yQ, this.yS, this.yR);
    }

}
