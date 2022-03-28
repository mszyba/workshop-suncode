package eu.michalszyba.suncode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_testowa")
@Getter @Setter @NoArgsConstructor
public class Product {

    @Id
    private Long id;

    private String kolumna1;
    private String kolumna2;
    private String kolumna3;
    private Integer kolumna4;
}
