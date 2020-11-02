package br.com.luisergio.cardealership.business;

import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.entity.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseBusiness<DTO,ENT> {

    protected List<DTO> iterableToList(Iterable<ENT> object) {
        Iterator<ENT> iterator = object.iterator();
        List<DTO> result = new ArrayList<DTO>();

        while (iterator.hasNext()) {
            ENT obj = iterator.next();
            result.add(this.getDto(obj));
        }

        return result;
    }

    public abstract DTO getDto(ENT obj);
}
