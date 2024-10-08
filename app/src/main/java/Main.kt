import ListaRaca.Orc
import ListaRaca.Anao
import ListaRaca.Humano
import ListaRaca.Draconato
import ListaRaca.Elfo
import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)

    // Lista para armazenar as opções de raças disponíveis
    val racas = mapOf(
        "1" to Draconato(),
        "2" to Elfo(),
        "3" to Humano(),
        "4" to Orc(),
        "5" to Anao()
    )

    println("Escolha a raça do seu personagem:")
    println("1. Draconato")
    println("2. Elfo")
    println("3. Humano")
    println("4. Orc")
    println("5. Anão")

    val opcao = scanner.nextLine()

    val racaSelecionada = racas[opcao]

    if (racaSelecionada != null) {
        println("Digite o nome do personagem:")
        val nome = scanner.nextLine()

        // Cria o personagem com a raça selecionada
        val personagem = Personagem(nome, racaSelecionada)
        personagem.distribuirPontos()

        // Exibe os atributos do personagem após a distribuição dos pontos
        personagem.exibirAtributos()
    } else {
        println("Opção de raça inválida.")
    }
}
