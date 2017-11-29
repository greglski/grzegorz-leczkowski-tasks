package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*@NamedQuery(
        name = "Task.retrieveSingleTask",
        query = "FROM Task WHERE title LIKE :TITLE"
)*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String title;

    @Column(name = "DESCRIPTION")
    private String content;
}

