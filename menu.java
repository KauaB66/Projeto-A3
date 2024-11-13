import java.util.ArrayList;
import javax.swing.JOptionPane;

public class menu {
    public static void main(String[] args) {
        boolean menuLoop = true;
        ArrayList<Biblioteca> livros = new ArrayList<>();
        String opcao;

        /* painel */
        do {
            opcao = JOptionPane.showInputDialog(null,
                    "Escolha uma opção:\n1. Incluir Livro\n2. Alterar Livro\n3. Excluir Livro\n4. Consultar Livro\n0. Sair",
                    "Cadastro do livro", JOptionPane.QUESTION_MESSAGE);
            switch (opcao) {
                case "1" -> {
                    String autor = JOptionPane.showInputDialog("Digite o autor:");
                    String genero = JOptionPane.showInputDialog("Digite o gênero:");
                    int anoDeLancamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento:"));
                    String codigoISBN = JOptionPane.showInputDialog("Digite o código ISBN:");
                    int quantidadeDeCopias = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de cópias:"));
                    float valor = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do livro:"));
                    String nome = JOptionPane.showInputDialog("Digite o Nome:");
                    String prateleira = JOptionPane.showInputDialog("Digite a prateleira:");
                    int quantidadeDePaginas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de páginas:"));
                    String edicao = JOptionPane.showInputDialog("Digite a edição:");

                    Biblioteca livro = new Biblioteca(autor, genero, anoDeLancamento, codigoISBN, quantidadeDeCopias, valor, nome, prateleira, quantidadeDePaginas, edicao);
                    livros.add(livro);
                    JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                }

                /* alteração do livro */
                case "2" -> {
                    String codigoAlteracao = JOptionPane.showInputDialog("Digite o código ISBN do Livro a ser alterado:");
                    Biblioteca livroParaAlterar = null;

                    for (Biblioteca l : livros) {
                        if (l.getCodigoISBN().equals(codigoAlteracao)) {
                            livroParaAlterar = l;
                            break;
                        }
                    }

                    if (livroParaAlterar != null) {
                        String novoAutor = JOptionPane.showInputDialog("Digite o novo autor (Atual: " + livroParaAlterar.getAutor() + "):");
                        String novoGenero = JOptionPane.showInputDialog("Digite o novo gênero (Atual: " + livroParaAlterar.getGenero() + "):");
                        int novoAnoDeLancamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano de lançamento (Atual: " + livroParaAlterar.getAnoDeLancamento() + "):"));
                        int novaQuantidadeDeCopias = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de cópias (Atual: " + livroParaAlterar.getQuantidadeDeCopias() + "):"));
                        float novoValor = Float.parseFloat(JOptionPane.showInputDialog("Digite o novo valor do livro (Atual: " + livroParaAlterar.getValor() + "):"));
                        String novonome = JOptionPane.showInputDialog("Digite o novo Nome (Atual: " + livroParaAlterar.getnome() + "):");
                        String novaPrateleira = JOptionPane.showInputDialog("Digite a nova prateleira (Atual: " + livroParaAlterar.getPrateleira() + "):");
                        int novaQuantidadeDePaginas = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de páginas (Atual: " + livroParaAlterar.getQuantidadeDePaginas() + "):"));
                        String novaEdicao = JOptionPane.showInputDialog("Digite a nova edição (Atual: " + livroParaAlterar.getEdicao() + "):");

                        livroParaAlterar.setAutor(novoAutor);
                        livroParaAlterar.setGenero(novoGenero);
                        livroParaAlterar.setAnodeLancamento(novoAnoDeLancamento);
                        livroParaAlterar.setQuantidadeDeCopias(novaQuantidadeDeCopias);
                        livroParaAlterar.setValor(novoValor);
                        livroParaAlterar.setnome(novonome);
                        livroParaAlterar.setPrateleira(novaPrateleira);
                        livroParaAlterar.setQuantidadeDepaginas(novaQuantidadeDePaginas);
                        livroParaAlterar.setEdicao(novaEdicao);

                        JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Livro não encontrado!");
                    }
                    break;
                }

                /* livro a ser excluído */
                case "3" -> {
                    String codigoParaExcluir = JOptionPane.showInputDialog("Digite o código ISBN do Livro a ser excluído:");
                    boolean livroEncontrado = false;

                    for (Biblioteca l : livros) {
                        if (l.getCodigoISBN().equals(codigoParaExcluir)) {
                            livros.remove(l);
                            livroEncontrado = true;
                            JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
                            
                        }
                    }

                    if (!livroEncontrado) {
                        JOptionPane.showMessageDialog(null, "Livro não encontrado!");
                    }
                    break;
                }

                /* consultar livros */    //oi quem ta ai vendo esse codigo
                case "4" -> {
                    String consultarLivro = JOptionPane.showInputDialog("Digite o código ISBN do Livro!");

                    boolean livroEncontrado = false;

                    for (Biblioteca l : livros) {
                        if (l.getCodigoISBN().equals(consultarLivro)) {
                            livroEncontrado = true;
                            String info = "Autor: " + l.getAutor() +
                                    "\nGênero: " + l.getGenero() +
                                    "\nAno de lançamento: " + l.getAnoDeLancamento() +
                                    "\nCódigo ISBN: " + l.getCodigoISBN() +
                                    "\nQuantidade de Cópias: " + l.getQuantidadeDeCopias() +
                                    "\nValor: " + l.getValor() +
                                    "\nNome: " + l.getnome() +
                                    "\nPrateleira: " + l.getPrateleira() +
                                    "\nQuantidade de Páginas: " + l.getQuantidadeDePaginas() +
                                    "\nEdição: " + l.getEdicao();
                            JOptionPane.showMessageDialog(null, info);
                            break;
                        }
                    }
                }

                /* Sair */
                case "0" -> {
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    menuLoop = false;
                }

                default -> JOptionPane.showMessageDialog(null, "Escolha um número válido!");
            }
        } while (!opcao.equals("0"));
    }
}