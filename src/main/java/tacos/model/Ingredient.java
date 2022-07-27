package tacos.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Id;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;


import javax.persistence.Entity;

/**
 * todo Document type Ingredients
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
