package com.github.dmitriylamzin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitriy_Lamzin on 5/12/2017.
 */
@Entity
public class Groups implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message="{groups.name}")
    private String name;

    @ManyToMany(mappedBy = "groupsList")
    @XmlTransient
    private List<Person> personList;

}
