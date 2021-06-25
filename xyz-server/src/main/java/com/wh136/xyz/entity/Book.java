package com.wh136.xyz.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "TBL_BOOK")
public class Book {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BOOK_NAME")
    private String name;

    @Column(name = "IS_DELETE")
    private Boolean isDelete;

}
