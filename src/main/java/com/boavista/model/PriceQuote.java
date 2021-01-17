package com.boavista.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "tube_assembly_id", unique = true, nullable = false)
    private String tubeassemblyid;

    @Column(name = "supplier", length = 100, nullable = false)
    private String supplier;

    @Column(name = "quote_date", length = 100, nullable = false)
    public String quotedate;

    @Column(name = "annual_usage", length = 100, nullable = false)
    private String annualusage;

    @Column(name = "min_order_quantity", length = 100, nullable = false)
    private String minorderquantity;

    @Column(name = "bracket_pricing", length = 100, nullable = false)
    private String bracketpricing;

    @Column(name = "quantity", length = 100, nullable = false)
    private String quantity;

    @Column(name = "cost", length = 100, nullable = false)
    private String cost;

    @Override
    public String toString() {
        return "PriceQuote{" +
                "tubeassemblyid='" + tubeassemblyid + '\'' +
                ", supplier='" + supplier + '\'' +
                ", quotedate=" + quotedate +
                ", annualusage='" + annualusage + '\'' +
                ", minorderquantity='" + minorderquantity + '\'' +
                ", bracketpricing='" + bracketpricing + '\'' +
                ", quantity='" + quantity + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }

}
