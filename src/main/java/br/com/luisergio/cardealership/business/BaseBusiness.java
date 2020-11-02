package br.com.luisergio.cardealership.business;

import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.entity.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Base business.
 *
 * @param <DTO> the type parameter
 * @param <ENT> the type parameter
 */
public abstract class BaseBusiness<DTO,ENT> {

    /**
     * Iterable to list list.
     *
     * @param object the object
     * @return the list
     */
    protected List<DTO> iterableToList(Iterable<ENT> object) {
        Iterator<ENT> iterator = object.iterator();
        List<DTO> result = new ArrayList<DTO>();

        while (iterator.hasNext()) {
            ENT obj = iterator.next();
            result.add(this.getDto(obj));
        }

        return result;
    }

    /**
     * Gets dto.
     *
     * @param obj the obj
     * @return the dto
     */
    public abstract DTO getDto(ENT obj);
}
