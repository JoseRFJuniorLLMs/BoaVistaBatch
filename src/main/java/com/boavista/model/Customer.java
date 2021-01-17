package com.boavista.model;

import lombok.*;

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
@Table(name = "customer",schema = "public")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private String firstName;
	private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d , firstName='%s', lastName='%s']", id, firstName, lastName);
	}

}
