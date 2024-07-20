package beans;

import java.util.Date;

public class emprestimo {
    
    private int id;
    private int exemplarId;
    private String UENome;
    private String titulo;
    private String UINome;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private int chancesDePrazo;
    private String status;

    public emprestimo() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(int exemplarId) {
        this.exemplarId = exemplarId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getUENome() {
        return UENome;
    }

    public void setUENome(String UENome) {
        this.UENome = UENome;
    }

    public String getUINome() {
        return UINome;
    }

    public void setUINome(String UINome) {
        this.UINome = UINome;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public int getChancesDePrazo() {
        return chancesDePrazo;
    }

    public void setChancesDePrazo(int chancesDePrazo) {
        this.chancesDePrazo = chancesDePrazo;
    }
    
    
    
}

