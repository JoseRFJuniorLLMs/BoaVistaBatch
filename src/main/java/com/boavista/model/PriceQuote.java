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
@Table(name = "pricequote",schema = "public")
public class PriceQuote implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "tube_assembly_id")
    private String tubeassemblyid;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "quote_date")
    public String quotedate;

    @Column(name = "annual_usage")
    private String annualusage;

    @Column(name = "min_order_quantity")
    private String minorderquantity;

    @Column(name = "bracket_pricing")
    private String bracketpricing;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "cost")
    private String cost;

   public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PriceQuote{" +
                "id=" + id +
                ", tubeassemblyid='" + tubeassemblyid + '\'' +
                ", supplier='" + supplier + '\'' +
                ", quotedate='" + quotedate + '\'' +
                ", annualusage='" + annualusage + '\'' +
                ", minorderquantity='" + minorderquantity + '\'' +
                ", bracketpricing='" + bracketpricing + '\'' +
                ", quantity='" + quantity + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
