public class Biblioteca {

    private String autor;
    private String genero;
    private int anoDeLancamento;
    private String codigoISBN;
    private int quantidadeDeCopias;
    private float valor;
    private String nome;
    private String prateleira;
    private int quantidadeDePaginas;
    private String edicao;

    public Biblioteca(String autor, String genero, int anoDeLancamento, String codigoISBN, int quantidadeDeCopias, float valor, String nome, String prateleira, int quantidadeDePaginas, String edicao) {
        this.autor = autor;
        this.genero = genero;
        this.anoDeLancamento = anoDeLancamento;
        this.codigoISBN = codigoISBN;
        this.quantidadeDeCopias = quantidadeDeCopias;
        this.valor = valor;
        this.nome = nome;
        this.prateleira = prateleira;
        this.quantidadeDePaginas = quantidadeDePaginas;
        this.edicao = edicao;
    }

 
    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public int getQuantidadeDeCopias() {
        return quantidadeDeCopias;
    }

    public float getValor() {
        return valor;
    }

    public String getnome() {
        return nome;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public int getQuantidadeDePaginas() {
        return quantidadeDePaginas;
    }

    public String getEdicao() {
        return edicao;
    }
    /*setter */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setAnodeLancamento(int anoDeLancamento){
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setCodigoISBN(String codigoISBN){
        this.codigoISBN = codigoISBN;
    }

    public void setQuantidadeDeCopias(int quantidadeDeCopias){
        this.quantidadeDeCopias = quantidadeDeCopias;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public void setnome(String nome){
        this.nome = nome;
    }

    public void setPrateleira (String prateleira){
        this.prateleira = prateleira;
    }

    public void setQuantidadeDepaginas(int quantidadeDePaginas){
        this.quantidadeDePaginas = quantidadeDePaginas;
    }

    public void setEdicao(String edicao){
        this.edicao = edicao;
    }
    
}