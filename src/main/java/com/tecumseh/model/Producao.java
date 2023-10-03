package com.tecumseh.model;

import java.util.Objects;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PRODUCAO")
public class Producao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name="work_center")
	private String workCenter;
	private String porcento;
	private String item;
	private String descricao;
	private String ordem;
	private double qnt_original;
	private double qnt_restante;

	@ColumnDefault("0")
	private double fgexp;
	private double saldo_t1;
	private double saldo_t2;
	private double saldo_t3;
	
	
	public Producao(Integer id, String workCenter, String porcento, String item, String descricao, String ordem, double qnt_original, double qnt_restante, double fgexp, double saldo_t1, double saldo_t2, double saldo_t3) {
		this.id = id;
		this.workCenter = workCenter;
		this.porcento = porcento;
		this.item = item;
		this.descricao = descricao;
		this.ordem = ordem;
		this.qnt_original = qnt_original;
		this.qnt_restante = qnt_restante;
		this.fgexp = fgexp;
		this.saldo_t1 = saldo_t1;
		this.saldo_t2 = saldo_t2;
		this.saldo_t3 = saldo_t3;
	}

	public Producao(String workCenter, String porcento, String item, String descricao, String ordem, double qnt_original, double qnt_restante, double fgexp, double saldo_t1, double saldo_t2, double saldo_t3) {
		this.workCenter = workCenter;
		this.porcento = porcento;
		this.item = item;
		this.descricao = descricao;
		this.ordem = ordem;
		this.qnt_original = qnt_original;
		this.qnt_restante = qnt_restante;
		this.fgexp = fgexp;
		this.saldo_t1 = saldo_t1;
		this.saldo_t2 = saldo_t2;
		this.saldo_t3 = saldo_t3;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producao() {
	
	}

	public String getWorkCenter() {
		return workCenter;
	}

	public void setWork_center(String workCenter) {
		this.workCenter = workCenter;
	}

	public String getPorcento() {
		return porcento;
	}

	public void setPorcento(String porcento) {
		this.porcento = porcento;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public double getQnt_original() {
		return qnt_original;
	}

	public void setQnt_original(double qnt_original) {
		this.qnt_original = qnt_original;
	}

	public double getQnt_restante() {
		return qnt_restante;
	}

	public void setQnt_restante(double qnt_restante) {
		this.qnt_restante = qnt_restante;
	}

	public double getFgexp() {
		return fgexp;
	}

	public void setFgexp(double fgexp) {
		this.fgexp = fgexp;
	}

	public double getSaldo_t1() {
		return saldo_t1;
	}

	public void setSaldo_t1(double saldo_t1) {
		this.saldo_t1 = saldo_t1;
	}

	public double getSaldo_t2() {
		return saldo_t2;
	}

	public void setSaldo_t2(double saldo_t2) {
		this.saldo_t2 = saldo_t2;
	}

	public double getSaldo_t3() {
		return saldo_t3;
	}

	public void setSaldo_t3(double saldo_t3) {
		this.saldo_t3 = saldo_t3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, fgexp, id, item, ordem, porcento, qnt_original, qnt_restante, saldo_t1, saldo_t2,
				saldo_t3, workCenter);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producao other = (Producao) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(fgexp, other.fgexp)
				&& Objects.equals(id, other.id) && Objects.equals(item, other.item)
				&& Objects.equals(ordem, other.ordem) && Objects.equals(porcento, other.porcento)
				&& Objects.equals(qnt_original, other.qnt_original) && Objects.equals(qnt_restante, other.qnt_restante)
				&& Objects.equals(saldo_t1, other.saldo_t1) && Objects.equals(saldo_t2, other.saldo_t2)
				&& Objects.equals(saldo_t3, other.saldo_t3) && Objects.equals(workCenter, other.workCenter);
	}
	
	

	

}
