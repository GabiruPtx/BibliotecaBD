package beans;

public class material {
    
    private int id;
    private String título;
    private String autor;
    private String editora;
    private String genero;
    private String AnoPublicacao;
    private String tipo;
    private int qntExemplares;
    private String revista;
    private String volume;
    private String resumo;
    
    
    public material(){
    
    }
    
    public material(String titulo, String autor, String editora, String genero, String AnoPublicacao, String tipo, int qntExemplares, String resumo){
        
        this.título = titulo;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.AnoPublicacao = AnoPublicacao;
        this.tipo = tipo;
        this.qntExemplares = qntExemplares;
        this.resumo = resumo;
        
    };
    
    public material(String titulo, String autor, String editora, String genero, String AnoPublicacao, String tipo, int qntExemplares, String revista, String volume, String resumo){
        
        this.título = titulo;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.AnoPublicacao = AnoPublicacao;
        this.tipo = tipo;
        this.qntExemplares = qntExemplares;
        this.revista = revista;
        this.volume = volume;
        this.resumo = resumo;
        
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnoPublicacao() {
        return AnoPublicacao;
    }

    public void setAnoPublicacao(String AnoPublicacao) {
        this.AnoPublicacao = AnoPublicacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQntExemplares() {
        return qntExemplares;
    }

    public void setQntExemplares(int qntExemplares) {
        this.qntExemplares = qntExemplares;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
    
}
