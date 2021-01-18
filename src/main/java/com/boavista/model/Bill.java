package com.boavista.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString(exclude="id")
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Entity
@Table(name = "bill",schema = "public")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "tube_assembly_id")
    private String tubeassemblyid;

    @Column(name = "component_id_1")
    private String componentid1;

    @Column(name = "quantity_1")
    private String quantity1;

    @Column(name = "component_id_2")
    private String componentid2;

    @Column(name = "quantity_2")
    private String quantity2;

    @Column(name = "component_id_3")
    private String componentid3;

    @Column(name = "quantity_3")
    private String quantity3;

    @Column(name = "component_id_4")
    private String componentid4;

    @Column(name = "quantity_4")
    private String quantity4;

    @Column(name = "component_id_5")
    private String componentid5;

    @Column(name = "quantity_5")
    private String quantity5;

    @Column(name = "component_id_6")
    private String componentid6;

    @Column(name = "quantity_6")
    private String quantity6;

    @Column(name = "component_id_7")
    private String componentid7;

    @Column(name = "quantity_7")
    private String quantity7;

    @Column(name = "component_id_8")
    private String componentid8;

    @Column(name = "quantity_8")
    private String quantity8;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", tubeassemblyid='" + tubeassemblyid + '\'' +
                ", componentid1='" + componentid1 + '\'' +
                ", quantity1='" + quantity1 + '\'' +
                ", componentid2='" + componentid2 + '\'' +
                ", quantity2='" + quantity2 + '\'' +
                ", componentid3='" + componentid3 + '\'' +
                ", quantity3='" + quantity3 + '\'' +
                ", componentid4='" + componentid4 + '\'' +
                ", quantity4='" + quantity4 + '\'' +
                ", componentid5='" + componentid5 + '\'' +
                ", quantity5='" + quantity5 + '\'' +
                ", componentid6='" + componentid6 + '\'' +
                ", quantity6='" + quantity6 + '\'' +
                ", componentid7='" + componentid7 + '\'' +
                ", quantity7='" + quantity7 + '\'' +
                ", componentid8='" + componentid8 + '\'' +
                ", quantity8='" + quantity8 + '\'' +
                '}';
    }
}
