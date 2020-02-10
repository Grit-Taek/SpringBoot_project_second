package com.example.project2.demo.domain;

import com.example.project2.demo.controller.dto.PersonDto;
import com.example.project2.demo.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Where(clause = "deleted = false")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(1)
    private int age;

    @ColumnDefault("0")
    private boolean deleted;

    private String hobby;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;

    private String address;

    private String job;


    @Valid
    @Embedded
    private Birthday birthday;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    private Block block;

    public void set(PersonDto personDto) {
        if(personDto.getAge() != 0)
            this.setAge(personDto.getAge());

        if(!StringUtils.isEmpty(personDto.getHobby()))
            this.setHobby(personDto.getHobby());

        if(!StringUtils.isEmpty(personDto.getBloodType()))
            this.setBloodType(personDto.getBloodType());

        if(!StringUtils.isEmpty(personDto.getAddress()))
            this.setAddress(personDto.getAddress());

        if(!StringUtils.isEmpty(personDto.getJob()))
            this.setJob(personDto.getJob());

        if(!StringUtils.isEmpty(personDto.getPhoneNumber()))
            this.setPhoneNumber(personDto.getPhoneNumber());
    }

}
