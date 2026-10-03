package com.example.stud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "first_name", nullable = false)
private String firstName;

@Column(name = "last_name", nullable = false)
private String LastName;

@Column(name = "email", nullable = false, unique = true)
private String email;

@Column(name = "course")
private String course;

}
