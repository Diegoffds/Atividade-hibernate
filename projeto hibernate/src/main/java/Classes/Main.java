package Classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static SessionFactory factory;

    public static void main(String[] args) {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Remover Produto");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> inserirProduto(sc);
                case 2 -> listarProdutos();
                case 3 -> atualizarProduto(sc);
                case 4 -> removerProduto(sc);
            }

        } while (opcao != 0);

        factory.close();
        sc.close();
    }

    // ==========================
    // INSERIR
    // ==========================
    private static void inserirProduto(Scanner sc) {

        Session session = factory.openSession();
        session.beginTransaction();

        System.out.println("1 - Eletrônico | 2 - Perecível");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Preço: ");
        Float preco = sc.nextFloat();

        System.out.print("Estoque: ");
        int estoque = sc.nextInt();
        sc.nextLine();

        if (tipo == 1) {
            System.out.print("Voltagem: ");
            int voltagem = sc.nextInt();

            ProdutoEletronico p = new ProdutoEletronico(id, nome, preco, estoque, voltagem);
            /*
             * p.setNome(nome);
             * p.setPreco(preco);
             * p.setEstoque(estoque);
             * p.setVoltagem(voltagem);
             */

            session.persist(p);

        } else {
            System.out.print("Data de validade YYYY/MM/DD: ");
            String dataString = sc.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            Date data = null;

            try {
                data = sdf.parse(dataString);
            } catch (Exception e) {
                System.out.println("Formato de data inválido!");
                return;
            }

            ProdutoPerecivel p = new ProdutoPerecivel(id, nome, preco, estoque, data);
            /*
             * p.setNome(nome);
             * p.setPreco(preco);
             * p.setEstoque(estoque);
             * p.setDataValidade(java.time.LocalDate.now().plusDays(dias));
             */

            session.persist(p);
        }

        session.getTransaction().commit();
        session.close();

        System.out.println("Produto inserido!");
    }

    // ==========================
    // LISTAR
    // ==========================
    private static void listarProdutos() {

        Session session = factory.openSession();

        List<Produto> produtos = session.createQuery("from Produto", Produto.class).list();

        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId() +
                    " | Nome: " + p.getNome() +
                    " | Preço: " + p.getPreco());
        }

        session.close();
    }

    // ==========================
    // ATUALIZAR
    // ==========================
    private static void atualizarProduto(Scanner sc) {

        Session session = factory.openSession();
        session.beginTransaction();

        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        sc.nextLine();

        Produto p = session.get(Produto.class, id);

        if (p != null) {
            System.out.print("Novo nome: ");
            p.alterarNome(sc.nextLine());

            System.out.print("Novo preço: ");
            p.alterarPreco(sc.nextFloat());

            session.merge(p);

            System.out.println("Atualizado!");
        } else {
            System.out.println("Produto não encontrado!");
        }

        session.getTransaction().commit();
        session.close();
    }

    // ==========================
    // REMOVER
    // ==========================
    private static void removerProduto(Scanner sc) {

        Session session = factory.openSession();
        session.beginTransaction();

        System.out.print("ID do produto: ");
        int id = sc.nextInt();

        Produto p = session.get(Produto.class, id);

        if (p != null) {
            session.remove(p);
            System.out.println("Removido!");
        } else {
            System.out.println("Produto não encontrado!");
        }

        session.getTransaction().commit();
        session.close();
    }
}