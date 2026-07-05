package com.E_market.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserEntity {
	
	@Id
	
	private Long id;

	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String username;
	@NonNull
	private String email;
	@NonNull
	private String password;
	@NonNull
	private String phoneNumber;

}
