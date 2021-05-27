package sk.fri.uniza.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

public class IotNode {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    // Swagger nebude zobrazovať atribút
    private Long id;

    @NotEmpty
    @ApiModelProperty(example = "Fero") // Príklad pre swagger doku.
    private String Name;

    @ManyToOne()
    private HouseHold houseHold;


    public Long getId() {

        return id;
    }


    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {

        Name = name;
    }

    public HouseHold getHouseHold() {

        return houseHold;
    }

    public void setHouseHold(HouseHold houseHold) {

        this.houseHold = houseHold;
    }
}
