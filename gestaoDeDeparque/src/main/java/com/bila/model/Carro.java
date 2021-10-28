package com.bila.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fabricante;
	private String modelo;
	private String cor;
	private double pesoBruto;
	private String matricula;
	public Carro() {

	}
	
	
	public Carro(int id, String modelo, String cor, double pesoBruto, String matricula) {
		
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.pesoBruto = pesoBruto;
		this.matricula = matricula;
	}


	public int getId() {
		return id;
	}
	
	
	


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public double getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Carro [id=" + id + ", modelo=" + modelo + ", cor=" + cor + ", pesoBruto="
				+ pesoBruto + ", matricula=" + matricula + "]";
	}
	
	

}
