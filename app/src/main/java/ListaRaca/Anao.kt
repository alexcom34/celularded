package ListaRaca

import Personagem

class Anao : Raca {
    override val nome = "Anão"

    override fun aplicarBonus(personagem: Personagem) {
        personagem.constituicao += 2
        personagem.forca += 2
    }
}
