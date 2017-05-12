package com.github.dmitriylamzin;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy_Lamzin on 5/12/2017.
 */
@Entity
public class Person implements Serializable {
    @JoinTable(name = "PERSON_GROUPS", joinColumns = {
            @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")}, inverseJoinColumns = {
            @JoinColumn(name = "GROUPS_ID", referencedColumnName = "ID")})
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER )
    private List<Groups> groupsList;


    @Pattern(regexp = ".+@.+\\.[a-z]+", message= "{person.email}")
    @Size(min=3, max=45, message= "{person.email}")
    @Basic(optional = false)
    @Id
    private String email;

    @Basic(optional = false)
    @Size(min=3, max=50, message="{person.firstname}")
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @Size(min=3, max=100, message="{person.lastname}")
    @Column(name = "LASTNAME")
    private String lastname;

    @Basic(optional = false)
    @Size(min=7, max=100, message= "{person.password}")
    @Column(name = "PASSWORD")
    private String password;

    public Person() {
        this.groupsList = new ArrayList<Groups>();
    }

    public Person(String email) {
        this.email = email;
        this.groupsList = new ArrayList<Groups>();
    }

    public Person(String firstName,
                  String lastName,
                  String email) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.groupsList = new ArrayList<Groups>();
    }

    public List<Groups> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<Groups> groupsList) {
        this.groupsList = groupsList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Add XmlTransient annotation to this field for security reasons.
     * @return the password
     */
    @XmlTransient
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (groupsList != null ? !groupsList.equals(person.groupsList) : person.groupsList != null) return false;
        if (!email.equals(person.email)) return false;
        if (!firstname.equals(person.firstname)) return false;
        if (!lastname.equals(person.lastname)) return false;
        return password.equals(person.password);
    }

    @Override
    public int hashCode() {
        int result = groupsList != null ? groupsList.hashCode() : 0;
        result = 31 * result + email.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                '}';
    }
}
