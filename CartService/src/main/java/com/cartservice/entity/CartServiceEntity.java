package com.cartservice.entity;

import java.math.BigDecimal;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Audited.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="CartService")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartServiceEntity {
	
	@Id
	@SequenceGenerator(name="seller_id_gen", sequenceName="seller_id_seq", initialValue = 5001, allocationSize = 1)
    @GeneratedValue(generator="seller_id_gen", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	private  Long userid;
	@NotNull
	private Long productid;
	@NotNull
	private Integer quantity;
	@NotNull
	private BigDecimal totalPrice;
	

}
