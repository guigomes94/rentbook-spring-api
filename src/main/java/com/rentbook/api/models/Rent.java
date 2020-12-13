package com.rentbook.api.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idbook")
	private Book book;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "rentdate")
	private LocalDate rentDate;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "devolutiondate")
	private LocalDate devolutionDate;

	@Column(name = "paymentvalue")
	private Double paymentValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentLocalDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDate getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(LocalDate devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public Double getPaymentValue() {
		return paymentValue;
	}

	public void setPaymentValue(Double paymentValue) {
		this.paymentValue = paymentValue;
	}

	public Double calcRent(LocalDate rentDate, LocalDate devolutionDate) {
		Double diary = 2.5;
		Period rentDays = Period.between(rentDate, devolutionDate);
		return diary * rentDays.getDays();
	}

	public Double calcTicket(Double rentValue) {
		return rentValue * 0.3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rent other = (Rent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
