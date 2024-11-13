import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Interface extends JFrame {

    private ArrayList<Biblioteca> livros;
    private JTextField autorField, generoField, anoDeLancamentoField, codigoISBNField, quantidadeDeCopiasField, valorField, nomeField, prateleiraField, quantidadeDePaginasField, edicaoField;
    private JTextArea consultaArea;
    private Biblioteca livroAtual;

    public Interface() {
        livros = new ArrayList<>();

        setTitle("Cadastro de Livros");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para inserção de dados
        JPanel panelSuperior = new JPanel(new GridLayout(10, 2));

        panelSuperior.add(new JLabel("Autor:"));
        autorField = new JTextField();
        panelSuperior.add(autorField);

        panelSuperior.add(new JLabel("Gênero:"));
        generoField = new JTextField();
        panelSuperior.add(generoField);

        panelSuperior.add(new JLabel("Ano de Lançamento:"));
        anoDeLancamentoField = new JTextField();
        panelSuperior.add(anoDeLancamentoField);

        panelSuperior.add(new JLabel("Código ISBN:"));
        codigoISBNField = new JTextField();
        panelSuperior.add(codigoISBNField);

        panelSuperior.add(new JLabel("Quantidade de Cópias:"));
        quantidadeDeCopiasField = new JTextField();
        panelSuperior.add(quantidadeDeCopiasField);

        panelSuperior.add(new JLabel("Valor:"));
        valorField = new JTextField();
        panelSuperior.add(valorField);

        panelSuperior.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panelSuperior.add(nomeField);

        panelSuperior.add(new JLabel("Prateleira:"));
        prateleiraField = new JTextField();
        panelSuperior.add(prateleiraField);

        panelSuperior.add(new JLabel("Quantidade de Páginas:"));
        quantidadeDePaginasField = new JTextField();
        panelSuperior.add(quantidadeDePaginasField);

        panelSuperior.add(new JLabel("Edição:"));
        edicaoField = new JTextField();
        panelSuperior.add(edicaoField);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelBotoes = new JPanel();
        JButton incluirButton = new JButton("Incluir Livro");
        JButton consultarButton = new JButton("Consultar Livro");
        JButton alterarButton = new JButton("Alterar Livro");
        JButton excluirButton = new JButton("Excluir Livro");
        JButton sairButton = new JButton("Sair");

        panelBotoes.add(incluirButton);
        panelBotoes.add(consultarButton);
        panelBotoes.add(alterarButton);
        panelBotoes.add(excluirButton);
        panelBotoes.add(sairButton);

        add(panelBotoes, BorderLayout.CENTER);

        consultaArea = new JTextArea();
        consultaArea.setEditable(false);
        add(new JScrollPane(consultaArea), BorderLayout.SOUTH);


        incluirButton.addActionListener(e -> incluirLivro());
        consultarButton.addActionListener(e -> consultarLivro());
        alterarButton.addActionListener(e -> carregarLivroParaAlteracao());
        excluirButton.addActionListener(e -> excluirLivro());
        sairButton.addActionListener(e -> System.exit(0));
    }

    private void incluirLivro() {
        String autor = autorField.getText();
        String genero = generoField.getText();
        int anoDeLancamento = Integer.parseInt(anoDeLancamentoField.getText());
        String codigoISBN = codigoISBNField.getText();
        int quantidadeDeCopias = Integer.parseInt(quantidadeDeCopiasField.getText());
        float valor = Float.parseFloat(valorField.getText());
        String nome = nomeField.getText();
        String prateleira = prateleiraField.getText();
        int quantidadeDePaginas = Integer.parseInt(quantidadeDePaginasField.getText());
        String edicao = edicaoField.getText();

        livros.add(new Biblioteca(autor, genero, anoDeLancamento, codigoISBN, quantidadeDeCopias, valor, nome, prateleira, quantidadeDePaginas, edicao));
        consultaArea.setText("Livro incluído: " + nome);

        limparCampos();
    }

    private void consultarLivro() {
        StringBuilder sb = new StringBuilder("Livros cadastrados:\n");
        for (Biblioteca livro : livros) {
            sb.append("Nome: ").append(livro.getnome()).append("\n")
              .append("Autor: ").append(livro.getAutor()).append("\n")
              .append("Gênero: ").append(livro.getGenero()).append("\n")
              .append("Ano de Lançamento: ").append(livro.getAnoDeLancamento()).append("\n")
              .append("ISBN: ").append(livro.getCodigoISBN()).append("\n")
              .append("Quantidade de Cópias: ").append(livro.getQuantidadeDeCopias()).append("\n")
              .append("Valor: ").append(livro.getValor()).append("\n")
              .append("Prateleira: ").append(livro.getPrateleira()).append("\n")
              .append("Quantidade de Páginas: ").append(livro.getQuantidadeDePaginas()).append("\n")
              .append("Edição: ").append(livro.getEdicao()).append("\n\n");
        }
        consultaArea.setText(sb.toString());
    }

    private void carregarLivroParaAlteracao() {
        String codigoISBN = codigoISBNField.getText();
        for (Biblioteca livro : livros) {
            if (livro.getCodigoISBN().equals(codigoISBN)) {
                autorField.setText(livro.getAutor());
                generoField.setText(livro.getGenero());
                anoDeLancamentoField.setText(String.valueOf(livro.getAnoDeLancamento()));
                quantidadeDeCopiasField.setText(String.valueOf(livro.getQuantidadeDeCopias()));
                valorField.setText(String.valueOf(livro.getValor()));
                nomeField.setText(livro.getnome());
                prateleiraField.setText(livro.getPrateleira());
                quantidadeDePaginasField.setText(String.valueOf(livro.getQuantidadeDePaginas()));
                edicaoField.setText(livro.getEdicao());

                livroAtual = livro;
                consultaArea.setText("Livro pronto para alteração.");
                return;
            }
        }
        consultaArea.setText("Livro não encontrado.");
    }

    private void excluirLivro() {
        String codigoISBN = codigoISBNField.getText();
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getCodigoISBN().equals(codigoISBN)) {
                livros.remove(i);
                consultaArea.setText("Livro excluído com sucesso.");
                limparCampos();
                return;
            }
        }
        consultaArea.setText("Livro não encontrado.");
    }

    private void limparCampos() {
        autorField.setText("");
        generoField.setText("");
        anoDeLancamentoField.setText("");
        codigoISBNField.setText("");
        quantidadeDeCopiasField.setText("");
        valorField.setText("");
        nomeField.setText("");
        prateleiraField.setText("");
        quantidadeDePaginasField.setText("");
        edicaoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interface frame = new Interface();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }
}
