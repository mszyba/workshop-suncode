package eu.michalszyba.suncode.repository;

import eu.michalszyba.suncode.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // TODO: needed modification to reduce code

    String FIND_DUPLICATES_COL_0 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.id = ou.id) > 1";

    String FIND_DUPLICATES_COL_1 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna1 = ou.kolumna1) > 1";

    String FIND_DUPLICATES_COL_2 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna2 = ou.kolumna2) > 1";

    String FIND_DUPLICATES_COL_3 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna3 = ou.kolumna3) > 1";

    String FIND_DUPLICATES_COL_4 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna4 = ou.kolumna4) > 1";

    String FIND_UNIQUE_COL_0 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.id = ou.id) = 1";

    String FIND_UNIQUE_COL_1 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna1 = ou.kolumna1) = 1";

    String FIND_UNIQUE_COL_2 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna2 = ou.kolumna2) = 1";

    String FIND_UNIQUE_COL_3 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna3 = ou.kolumna2) = 1";

    String FIND_UNIQUE_COL_4 = "select * from tabela_testowa ou where (select count(*)\n" +
            "from tabela_testowa inr where inr.kolumna4 = ou.kolumna4) = 1";

    @Query(value = FIND_DUPLICATES_COL_0, nativeQuery = true)
    List<Product> findDuplicatesCol0();

    @Query(value = FIND_DUPLICATES_COL_1, nativeQuery = true)
    List<Product> findDuplicatesCol1();

    @Query(value = FIND_DUPLICATES_COL_2, nativeQuery = true)
    List<Product> findDuplicatesCol2();

    @Query(value = FIND_DUPLICATES_COL_3, nativeQuery = true)
    List<Product> findDuplicatesCol3();

    @Query(value = FIND_DUPLICATES_COL_4, nativeQuery = true)
    List<Product> findDuplicatesCol4();

    @Query(value = FIND_UNIQUE_COL_0, nativeQuery = true)
    List<Product> findUniqueCol0();

    @Query(value = FIND_UNIQUE_COL_1, nativeQuery = true)
    List<Product> findUniqueCol1();

    @Query(value = FIND_UNIQUE_COL_2, nativeQuery = true)
    List<Product> findUniqueCol2();

    @Query(value = FIND_UNIQUE_COL_3, nativeQuery = true)
    List<Product> findUniqueCol3();

    @Query(value = FIND_UNIQUE_COL_4, nativeQuery = true)
    List<Product> findUniqueCol4();
}
