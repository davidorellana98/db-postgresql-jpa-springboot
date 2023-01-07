package com.davidorellana.dbpostgresql.user.model.data;

import com.davidorellana.dbpostgresql.purchase.model.data.Purchase;
import com.davidorellana.dbpostgresql.user.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "identification_card")
    @Size(min = 10, max = 10, message = "Your identification must have a maximum of 10 digits.")
    private String identificationCard;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Size(min = 10, max = 10, message = "The phone number must contain 10 digits.")
    private String phone;
    private String email;

    @OneToMany(mappedBy = "user")
    List<Purchase> purchase;

    public User() { }

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.identificationCard = userDto.getIdentificationCard();
        this.birthDate = userDto.getBirthDate();
        this.phone = userDto.getPhone();
        this.email = userDto.getEmail();
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(identificationCard, user.identificationCard) && Objects.equals(birthDate, user.birthDate) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(purchase, user.purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, lastName, identificationCard, birthDate, phone, email, purchase);
    }
}
