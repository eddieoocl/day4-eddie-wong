package oo;

import java.util.Objects;

public class Klass {
    private Integer number;

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Klass klass = (Klass) obj;
        return this.number.equals(klass.number);
    }
}
