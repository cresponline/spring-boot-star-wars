package net.crespo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Sith extends ModelItem {

    private static final long serialVersionUID = 5348518077813233172L;

    public Sith(String name, String saber_color) {
        this.name = name;
        this.saber_color = saber_color;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String saber_color;

}
