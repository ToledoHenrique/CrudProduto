package br.edu.atitus.pooavancado.CadUsuario.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto extends GenericEntity{

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private double valorUnitario;

    public Produto() {
        super();
    }

    public Produto(String nome, double valorUnitario) {
        super();
        this.setNome(nome);
        this.valorUnitario = valorUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
