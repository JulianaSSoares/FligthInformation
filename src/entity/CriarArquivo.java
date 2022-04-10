package entity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CriarArquivo {
    public static class CriaArquivo {
        public void escreveLinhas(String caminhoArquivo, List<Voo> conteudoArquivo) {
            Path caminho = Paths.get(caminhoArquivo);
            List<String> teste = conteudoArquivo.stream().map(voo -> voo.getOrigin() + ";"
                    + voo.getDestination() + ";" + voo.getAirline() + ";"
                    + voo.getDeparture() + ";" + voo.getArrival() + ";"
                    + voo.getPrice() + ";"
                    + voo.getDuration()).collect(Collectors.toList());
            teste.add(0, "origin;destination;airline;departure;arrival;price;time");
            try {
                Files.write(caminho, teste);
            } catch (IOException excecao) {
            }
        }
    }
}