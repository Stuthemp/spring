package tacos.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * todo Document type TacoOrder
 */
@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date placedAt = new Date();
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @NotBlank(message = "Street is required")
    private String deliveryStreet;
    @NotBlank(message = "City is required")
    private String deliveryCity;
    @NotBlank(message="State is required")
    private String deliveryState;
    @NotBlank(message="Zip code is required")
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    @ManyToOne
    private TacoAppUser user;

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

}
