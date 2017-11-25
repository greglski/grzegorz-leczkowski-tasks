package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*@NamedQuery(
        name = "Task.retrieveSingleTask",
        query = "FROM Task WHERE id = :ID"
)*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "NAME")
    private String title;

    @Column(name = "DESCRIPTION")
    private String content;
}

