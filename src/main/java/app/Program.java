package app;

import dominio.Pessoa;

import javax.persistence.*;
import java.sql.ResultSet;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Pessoa pessoa4 = new Pessoa(null, "Teste", "teste@gmail.com");

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("exemplo_jpa");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pessoa4);
        entityManager.getTransaction().commit();


        Pessoa pessoa = entityManager.find(Pessoa.class, 4);
        System.out.println(pessoa);

        //entityManager.getTransaction().begin();
        //entityManager.remove(pessoa);
        //entityManager.getTransaction().commit();

        managerFactory.close();
        entityManager.close();

    }

}
