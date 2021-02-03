package com.udacity.jdnd.course3;

import java.io.Serializable;
import java.util.Objects;

public class PersonPK implements Serializable {
    private Double height;
    private String sockColor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonPK personPK = (PersonPK) o;
        return Objects.equals(height, personPK.height) && Objects.equals(sockColor, personPK.sockColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, sockColor);
    }
}
