package questao01.lapiseira;

import java.util.Locale;

public class Manual {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        //case inserindo grafites
        Lapiseira lapiseira = new Lapiseira(0.5f);
        System.out.println(lapiseira);
        //calibre: 0.5, grafite: null
        lapiseira.inserir(new Grafite(0.7f, "2B", 50));
        //fail: calibre incompatível
        lapiseira.inserir(new Grafite(0.5f, "2B", 50));
        System.out.println(lapiseira);
        //calibre: 0.5, grafite: [0.5:2B:50]

        //case inserindo e removendo
        lapiseira = new Lapiseira(0.3f);
        lapiseira.inserir(new Grafite(0.3f, "2B", 50));
        System.out.println(lapiseira);
        //calibre: 0.3, grafite: [0.3:2B:50]
        lapiseira.inserir(new Grafite(0.3f, "4B", 70));
        //fail: ja existe grafite
        System.out.println(lapiseira);
        //calibre: 0.3, grafite: [0.3:2B:50]
        lapiseira.remover();
        lapiseira.inserir(new Grafite(0.3f, "4B", 70));
        System.out.println(lapiseira);
        //calibre: 0.3, grafite: [0.3:4B:70]

        //case escrevendo 1
        lapiseira = new Lapiseira(0.9f);
        lapiseira.inserir(new Grafite(0.9f, "4B", 4));
        lapiseira.escrever();
        //warning: grafite acabou
        System.out.println(lapiseira);
        //calibre: 0.9, grafite: [0.9:4B:4]
        lapiseira.inserir(new Grafite(0.9f, "4B", 30));
        //fail: ja existe grafite
        lapiseira.escrever();
        //warning: grafite acabou
        System.out.println(lapiseira);
        //calibre: 0.9, grafite: [0.9:4B:4]
        lapiseira.remover();
        System.out.println(lapiseira);
        //calibre: 0.9, grafite: null
        lapiseira.inserir(new Grafite(0.9f, "4B", 30));
        System.out.println(lapiseira);
        //calibre: 0.9, grafite: [0.9:4B:30]
        lapiseira.escrever();
        lapiseira.escrever();
        lapiseira.escrever();
        System.out.println(lapiseira);
        //calibre: 0.9, grafite: [0.9:4B:18]

        //case escrevendo 2
        lapiseira = new Lapiseira(0.9f);
        lapiseira.inserir(new Grafite(0.9f, "2B", 15));
        System.out.println(lapiseira);
        //calibre: 0.9, grafite: [0.9:2B:15]
        lapiseira.escrever();
        System.out.println(lapiseira);
        lapiseira.escrever();
        System.out.println(lapiseira);
        lapiseira.escrever();
        //fail: folha incompleta
        //warning: grafite acabou
        System.out.println(lapiseira);
        //calibre: 0.9, grafite: [0,9:2B:10]
        lapiseira.escrever();
        //warning: grafite acabou
    }
}