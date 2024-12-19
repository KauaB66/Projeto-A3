

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Interface extends JFrame {

    private JTextField autorField, generoField, anoDeLancamentoField, quantidadeDeCopiasField, valorField, nomeField, prateleiraField, quantidadeDePaginasField, edicaoField, idConsultaField;
    private JTextArea consultaArea;
    private Connection connection;

    public Interface() {
        setTitle("Cadastro de Livros");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(10, 2));

        panelSuperior.add(new JLabel("ID para Consulta:"));
        idConsultaField = new JTextField();
        panelSuperior.add(idConsultaField);

        panelSuperior.add(new JLabel("Autor:"));
        autorField = new JTextField();
        panelSuperior.add(autorField);

        panelSuperior.add(new JLabel("Gênero:"));
        generoField = new JTextField();
        panelSuperior.add(generoField);

        panelSuperior.add(new JLabel("Ano de Lançamento:"));
        anoDeLancamentoField = new JTextField();
        panelSuperior.add(anoDeLancamentoField);

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
        consultarButton.addActionListener(e -> consultarLivroPorId());
        alterarButton.addActionListener(e -> alterarLivro());
        excluirButton.addActionListener(e -> excluirLivro());
        sairButton.addActionListener(e -> System.exit(0));

        conectarBanco();
    }

    private void conectarBanco() {
        try {
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String user = "root";
            String password = "anjoeterno1820";
            connection = DriverManager.getConnection(url, user, password);
            consultaArea.setText("Conectado ao banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void incluirLivro() {
        try {
            String query = "INSERT INTO livros (autor, genero, ano_de_lancamento, quantidade_de_copias, valor, nome, prateleira, quantidade_de_paginas, edicao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, autorField.getText());
            stmt.setString(2, generoField.getText());
            stmt.setInt(3, Integer.parseInt(anoDeLancamentoField.getText()));
            stmt.setInt(4, Integer.parseInt(quantidadeDeCopiasField.getText()));
            stmt.setFloat(5, Float.parseFloat(valorField.getText()));
            stmt.setString(6, nomeField.getText());
            stmt.setString(7, prateleiraField.getText());
            stmt.setInt(8, Integer.parseInt(quantidadeDePaginasField.getText()));
            stmt.setString(9, edicaoField.getText());

            stmt.executeUpdate();
            consultaArea.setText("Livro incluído com sucesso.");
            limparCampos();
        } catch (SQLException e) {
            e.printStackTrace();
            consultaArea.setText("Erro ao incluir livro: " + e.getMessage());
        }
    }

    private void consultarLivroPorId() {
    try {
        
        String idTexto = idConsultaField.getText().trim();
        if (idTexto.isEmpty()) {
            consultaArea.setText("Por favor, insira um ID para consulta.");
            return;
        }

        int id = Integer.parseInt(idTexto);

        
        System.out.println("Consultando livro com ID: " + id);

        
        String query = "SELECT * FROM livros WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);

        
        ResultSet rs = stmt.executeQuery();

        
        if (rs.next()) {
            StringBuilder sb = new StringBuilder("Livro Encontrado:\n");
            sb.append("Nome: ").append(rs.getString("nome")).append("\n");
            sb.append("Autor: ").append(rs.getString("autor")).append("\n");
            sb.append("Gênero: ").append(rs.getString("genero")).append("\n");
            sb.append("Ano de Lançamento: ").append(rs.getInt("ano_de_lancamento")).append("\n");
            sb.append("Quantidade de Cópias: ").append(rs.getInt("quantidade_de_copias")).append("\n");
            sb.append("Valor: ").append(rs.getFloat("valor")).append("\n");
            sb.append("Prateleira: ").append(rs.getString("prateleira")).append("\n");
            sb.append("Quantidade de Páginas: ").append(rs.getInt("quantidade_de_paginas")).append("\n");
            sb.append("Edição: ").append(rs.getString("edicao")).append("\n");

            consultaArea.setText(sb.toString());
        } else {
            consultaArea.setText("Nenhum livro encontrado com o ID fornecido.");
        }
    } catch (NumberFormatException e) {
        consultaArea.setText("O ID deve ser um número válido.");
        e.printStackTrace();
    } catch (SQLException e) {
        consultaArea.setText("Erro ao consultar livro: " + e.getMessage());
        e.printStackTrace();
    }
}


    private void alterarLivro() {
         try {
        String idTexto = idConsultaField.getText();
        if (idTexto.isEmpty()) {
            consultaArea.setText("Por favor, insira um ID para alterar.");
            return;
        }

        int id = Integer.parseInt(idTexto);
        String query = "UPDATE livros SET autor = ?, genero = ?, ano_de_lancamento = ?, quantidade_de_copias = ?, valor = ?, nome = ?, prateleira = ?, quantidade_de_paginas = ?, edicao = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, autorField.getText());
        stmt.setString(2, generoField.getText());
        stmt.setInt(3, Integer.parseInt(anoDeLancamentoField.getText()));
        stmt.setInt(4, Integer.parseInt(quantidadeDeCopiasField.getText()));
        stmt.setFloat(5, Float.parseFloat(valorField.getText()));
        stmt.setString(6, nomeField.getText());
        stmt.setString(7, prateleiraField.getText());
        stmt.setInt(8, Integer.parseInt(quantidadeDePaginasField.getText()));
        stmt.setString(9, edicaoField.getText());
        stmt.setInt(10, id);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            consultaArea.setText("Livro alterado com sucesso.");
            limparCampos();
        } else {
            consultaArea.setText("Nenhum livro encontrado com o ID fornecido.");
        }
    } catch (NumberFormatException e) {
        consultaArea.setText("O ID deve ser um número.");
    } catch (SQLException e) {
        e.printStackTrace();
        consultaArea.setText("Erro ao alterar livro: " + e.getMessage());
    }
    }

    private void excluirLivro() {
         try {
        String idTexto = idConsultaField.getText();
        if (idTexto.isEmpty()) {
            consultaArea.setText("Por favor, insira um ID para excluir.");
            return;
        }

        int id = Integer.parseInt(idTexto);
        String query = "DELETE FROM livros WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            consultaArea.setText("Livro excluído com sucesso.");
            limparCampos();
        } else {
            consultaArea.setText("Nenhum livro encontrado com o ID fornecido.");
        }
    } catch (NumberFormatException e) {
        consultaArea.setText("O ID deve ser um número.");
    } catch (SQLException e) {
        e.printStackTrace();
        consultaArea.setText("Erro ao excluir livro: " + e.getMessage());
    }
    }

    private void limparCampos() {
        autorField.setText("");
        generoField.setText("");
        anoDeLancamentoField.setText("");
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
