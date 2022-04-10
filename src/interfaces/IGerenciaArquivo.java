package interfaces;

import entity.Voo;

import java.util.List;

public interface IGerenciaArquivo {

    List<Voo> listaDeVoos(String arquivo);
    void escreveLinhas(String caminhoArquivo, List<Voo> conteudoArquivo);

}
