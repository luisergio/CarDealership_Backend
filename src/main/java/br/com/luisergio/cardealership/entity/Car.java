package br.com.luisergio.cardealership.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Car extends BaseEntity{

    private String name;
    private String brand;
    private Integer year;

    @Lob
    private String description;
    private boolean sold;
    private Timestamp created;
    private Timestamp updated;

    protected Car() {}

    @Override
    public String toString() {
        return String.format("car[id=%d, name='%s', brand='%s', year='%d']",getId(), name, brand, year);
    }

}
