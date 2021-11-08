package com.projectdl.recantogeek.utils;

import com.projectdl.recantogeek.models.CategoryModel;
import com.projectdl.recantogeek.models.ProductModel;
import com.projectdl.recantogeek.repositories.CategoryRepository;
import com.projectdl.recantogeek.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DummyData {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @PostConstruct
    public void mock() {

        CategoryModel c1 = new CategoryModel(null, "Livros");
        CategoryModel c2 = new CategoryModel(null, "Vestuario");
        CategoryModel c3 = new CategoryModel(null, "Colecionaveis");
        CategoryModel c4 = new CategoryModel(null, "Funkos");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));


        ProductModel p1 = new ProductModel(null, "Camiseta Nevermore – Insane Edition", BigDecimal.valueOf(79.90)
                , "Depressão, terror, medo, desespero e a falta de folego são pequenos elementos de uma grande realidade, que fazia parte da vida do autor."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2018/12/camiseta-nevermore-01-nerdstore.jpg", c2);

        ProductModel p2 = new ProductModel(null, "Camiseta Ruiva – É Melhor Estar Certa Do Que Ter Paz", BigDecimal.valueOf(79.90)
                , "Todo mundo sabe que ao lado de um grande homem, existe uma grande mulher. E a Ruiva é a prova viva disso. Ela já assumiu o programa e aconselhou alguns nerds desesperados, isso porque além de ótima conselheira, ela convive diariamente com um clássico nerd, o Sr. K."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/camiseta-e-melhor-estar-certa-do-que-ter-paz-01.jpg", c2);

        ProductModel p3 = new ProductModel(null, "Burst Shanks – One Piece", BigDecimal.valueOf(129.90)
                , "Shanks é um personagem da série de mangá One Piece, escrita e ilustrada por Eiichiro Oda."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2020/11/shanks-one-piece-01.jpg", c3);

        ProductModel p4 = new ProductModel(null, "Livro – Robbie", BigDecimal.valueOf(17.40)
                , "Um dos mais elogiados contos do escritor Isaac Asimov em edição exclusiva!"
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/9bf2b3727fb45b62f0fa16012b6b6e44-800x800.jpg", c1);

        ProductModel p5 = new ProductModel(null, "Livro 1984", BigDecimal.valueOf(41.90)
                , "A obra de maior destaque de George Orwell, que também virou ícone quando se fala de ficção científica, 1984 ganhou uma versão em quadrinhos ilustrada pelo artista paulistano Fido Nesti."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2020/10/livro-quadrinhos-1984-01-1.jpg", c1);

        ProductModel p6 = new ProductModel(null, "Burst Shanks – One Piece", BigDecimal.valueOf(129.90)
                , "Harley Quinn (Arlequina), surgiu originalmente na série animada Batman: The Animated Series, criada pela dupla Paul Dini e Bruce Timm em 1992."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2021/01/funko-movies-suicide-squad-harley-quinn-01.jpg", c4);

        ProductModel p7 = new ProductModel(null, "Funko POP! Movies Suicide Squad – Harley Quinn", BigDecimal.valueOf(159.90)
                , "Depressão, terror, medo, desespero e a falta de folego são pequenos elementos de uma grande realidade, que fazia parte da vida do autor."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2018/12/camiseta-nevermore-01-nerdstore.jpg", c2);

        ProductModel p8 = new ProductModel(null, "Camiseta Ruiva – É Melhor Estar Certa Do Que Ter Paz", BigDecimal.valueOf(79.90)
                , "Todo mundo sabe que ao lado de um grande homem, existe uma grande mulher. E a Ruiva é a prova viva disso. Ela já assumiu o programa e aconselhou alguns nerds desesperados, isso porque além de ótima conselheira, ela convive diariamente com um clássico nerd, o Sr. K."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/camiseta-e-melhor-estar-certa-do-que-ter-paz-01.jpg", c2);

        ProductModel p9 = new ProductModel(null, "Burst Shanks – One Piece", BigDecimal.valueOf(129.90)
                , "Shanks é um personagem da série de mangá One Piece, escrita e ilustrada por Eiichiro Oda."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2020/11/shanks-one-piece-01.jpg", c3);

        ProductModel p10 = new ProductModel(null, "Camiseta Nevermore – Insane Edition", BigDecimal.valueOf(79.90)
                , "Depressão, terror, medo, desespero e a falta de folego são pequenos elementos de uma grande realidade, que fazia parte da vida do autor."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2018/12/camiseta-nevermore-01-nerdstore.jpg", c2);

        ProductModel p11 = new ProductModel(null, "Camiseta Ruiva – É Melhor Estar Certa Do Que Ter Paz", BigDecimal.valueOf(79.90)
                , "Todo mundo sabe que ao lado de um grande homem, existe uma grande mulher. E a Ruiva é a prova viva disso. Ela já assumiu o programa e aconselhou alguns nerds desesperados, isso porque além de ótima conselheira, ela convive diariamente com um clássico nerd, o Sr. K."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/camiseta-e-melhor-estar-certa-do-que-ter-paz-01.jpg", c2);

        ProductModel p12 = new ProductModel(null, "Burst Shanks – One Piece - TESTE", BigDecimal.valueOf(129.90)
                , "Shanks é um personagem da série de mangá One Piece, escrita e ilustrada por Eiichiro Oda."
                , "https://cdn.nerdstore.com.br/wp-content/uploads/2020/11/shanks-one-piece-01.jpg", c3);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

    }
}
