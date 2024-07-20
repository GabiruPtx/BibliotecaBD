package beans;

public class emprestimo {
    
    private int id;
    private int exemplarId;
    private String UENome;
    private String titulo;
    private String UINome;
    private String dataEmprestimo;
    private String dataDevolucao;
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

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getChancesDePrazo() {
        return chancesDePrazo;
    }

    public void setChancesDePrazo(int chancesDePrazo) {
        this.chancesDePrazo = chancesDePrazo;
    }
    
    
    
}

