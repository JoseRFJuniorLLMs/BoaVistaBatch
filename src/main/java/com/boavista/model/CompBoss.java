package com.boavista.model;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "comp_boss",schema = "public")
@ToString(exclude="id")
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class CompBoss implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "component_type_id")
    private String componenttypeid;

    @Column(name = "type")
    private String type;

    @Column(name = "connection_type_id")
    private String connectiontypeid;

    @Column(name = "outside_shape")
    private String outsideshape;

    @Column(name = "base_type")
    private String basetype;

    @Column(name = "height_over_tube")
    private String heightovertube;

    @Column(name = "bolt_pattern_long")
    private String boltpatternlong;

    @Column(name = "bolt_pattern_wide")
    private String boltpatternwide;

    @Column(name = "groove")
    private String groove;

    @Column(name = "base_diameter")
    private String basediameter;

    @Column(name = "shoulder_diameter")
    private String shoulderdiameter;

    @Column(name = "unique_feature")
    private String uniquefeature;

    @Column(name = "orientation")
    private String orientation;

    @Column(name = "weight")
    private String weight;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CompBoss{" +
                "id=" + id +
                ", componenttypeid='" + componenttypeid + '\'' +
                ", type='" + type + '\'' +
                ", connectiontypeid='" + connectiontypeid + '\'' +
                ", outsideshape='" + outsideshape + '\'' +
                ", basetype='" + basetype + '\'' +
                ", heightovertube='" + heightovertube + '\'' +
                ", boltpatternlong='" + boltpatternlong + '\'' +
                ", boltpatternwide='" + boltpatternwide + '\'' +
                ", groove='" + groove + '\'' +
                ", basediameter='" + basediameter + '\'' +
                ", shoulderdiameter='" + shoulderdiameter + '\'' +
                ", uniquefeature='" + uniquefeature + '\'' +
                ", orientation='" + orientation + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
