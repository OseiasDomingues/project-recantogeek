package com.projectdl.recantogeek.utils;

import com.projectdl.recantogeek.models.ProductModel;
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

    @PostConstruct
    public void mock(){

        ProductModel p1 = new ProductModel(null, "Camiseta Nevermore – Insane Edition", BigDecimal.valueOf(79.90)
                ,"Depressão, terror, medo, desespero e a falta de folego são pequenos elementos de uma grande realidade, que fazia parte da vida do autor."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2018/12/camiseta-nevermore-01-nerdstore.jpg");

        ProductModel p2 = new ProductModel(null, "Camiseta Ruiva – É Melhor Estar Certa Do Que Ter Paz", BigDecimal.valueOf(79.90)
                ,"Todo mundo sabe que ao lado de um grande homem, existe uma grande mulher. E a Ruiva é a prova viva disso. Ela já assumiu o programa e aconselhou alguns nerds desesperados, isso porque além de ótima conselheira, ela convive diariamente com um clássico nerd, o Sr. K."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/camiseta-e-melhor-estar-certa-do-que-ter-paz-01.jpg");

        ProductModel p3 = new ProductModel(null, "Burst Shanks – One Piece", BigDecimal.valueOf(129.90)
                ,"Shanks é um personagem da série de mangá One Piece, escrita e ilustrada por Eiichiro Oda."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2020/11/shanks-one-piece-01.jpg");

        ProductModel p4 = new ProductModel(null, "Camiseta Nevermore – Insane Edition", BigDecimal.valueOf(79.90)
                ,"Depressão, terror, medo, desespero e a falta de folego são pequenos elementos de uma grande realidade, que fazia parte da vida do autor."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2018/12/camiseta-nevermore-01-nerdstore.jpg");

        ProductModel p5 = new ProductModel(null, "Camiseta Ruiva – É Melhor Estar Certa Do Que Ter Paz", BigDecimal.valueOf(79.90)
                ,"Todo mundo sabe que ao lado de um grande homem, existe uma grande mulher. E a Ruiva é a prova viva disso. Ela já assumiu o programa e aconselhou alguns nerds desesperados, isso porque além de ótima conselheira, ela convive diariamente com um clássico nerd, o Sr. K."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/camiseta-e-melhor-estar-certa-do-que-ter-paz-01.jpg");

        ProductModel p6 = new ProductModel(null, "Burst Shanks – One Piece", BigDecimal.valueOf(129.90)
                ,"Shanks é um personagem da série de mangá One Piece, escrita e ilustrada por Eiichiro Oda."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2020/11/shanks-one-piece-01.jpg");

        ProductModel p7 = new ProductModel(null, "Camiseta Nevermore – Insane Edition", BigDecimal.valueOf(79.90)
                ,"Depressão, terror, medo, desespero e a falta de folego são pequenos elementos de uma grande realidade, que fazia parte da vida do autor."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2018/12/camiseta-nevermore-01-nerdstore.jpg");

        ProductModel p8 = new ProductModel(null, "Camiseta Ruiva – É Melhor Estar Certa Do Que Ter Paz", BigDecimal.valueOf(79.90)
                ,"Todo mundo sabe que ao lado de um grande homem, existe uma grande mulher. E a Ruiva é a prova viva disso. Ela já assumiu o programa e aconselhou alguns nerds desesperados, isso porque além de ótima conselheira, ela convive diariamente com um clássico nerd, o Sr. K."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/camiseta-e-melhor-estar-certa-do-que-ter-paz-01.jpg");

        ProductModel p9 = new ProductModel(null, "Burst Shanks – One Piece", BigDecimal.valueOf(129.90)
                ,"Shanks é um personagem da série de mangá One Piece, escrita e ilustrada por Eiichiro Oda."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2020/11/shanks-one-piece-01.jpg");
        ProductModel p10 = new ProductModel(null, "Camiseta Nevermore – Insane Edition", BigDecimal.valueOf(79.90)
                ,"Depressão, terror, medo, desespero e a falta de folego são pequenos elementos de uma grande realidade, que fazia parte da vida do autor."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2018/12/camiseta-nevermore-01-nerdstore.jpg");

        ProductModel p11 = new ProductModel(null, "Camiseta Ruiva – É Melhor Estar Certa Do Que Ter Paz", BigDecimal.valueOf(79.90)
                ,"Todo mundo sabe que ao lado de um grande homem, existe uma grande mulher. E a Ruiva é a prova viva disso. Ela já assumiu o programa e aconselhou alguns nerds desesperados, isso porque além de ótima conselheira, ela convive diariamente com um clássico nerd, o Sr. K."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2021/10/camiseta-e-melhor-estar-certa-do-que-ter-paz-01.jpg");

        ProductModel p12 = new ProductModel(null, "Burst Shanks – One Piece", BigDecimal.valueOf(129.90)
                ,"Shanks é um personagem da série de mangá One Piece, escrita e ilustrada por Eiichiro Oda."
                ,"https://cdn.nerdstore.com.br/wp-content/uploads/2020/11/shanks-one-piece-01.jpg");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12));
    }
}
