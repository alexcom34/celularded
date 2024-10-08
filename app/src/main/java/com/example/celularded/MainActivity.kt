import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import ListaRaca.*
import android.content.Intent
import com.example.celularded.R
import com.example.celularded.SecondActivity


class MainActivity : AppCompatActivity() {
    private var pontosRestantes = 27
    private var forca = 8
    private var destreza = 8
    private var inteligencia = 8
    private var constituicao = 8
    private var carisma = 8
    private var sabedoria = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomePersonagem = findViewById<EditText>(R.id.nomePersonagem)
        val racaSpinner = findViewById<Spinner>(R.id.racaSpinner)
        val txtForca = findViewById<TextView>(R.id.txtForca)
        val btnForcaMais = findViewById<Button>(R.id.btnForcaMais)
        val btnForcaMenos = findViewById<Button>(R.id.btnForcaMenos)
        val txtPontosRestantes = findViewById<TextView>(R.id.txtPontosRestantes)
        val btnCriarPersonagem = findViewById<Button>(R.id.btnCriarPersonagem)


        // Adiciona opções ao Spinner de raças
        val racas = arrayOf("Draconato", "Elfo", "Humano", "Orc", "Anão")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, racas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        racaSpinner.adapter = adapter


        val btnGoToSecondActivity = findViewById<Button>(R.id.btnGoToSecondActivity)
        btnGoToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Botões para aumentar e diminuir a Força
        btnForcaMais.setOnClickListener {
            if (pontosRestantes > 0 && forca < 15) {
                forca++
                pontosRestantes--
                txtForca.text = forca.toString()
                txtPontosRestantes.text = "Pontos Restantes: $pontosRestantes"
            } else {
                Toast.makeText(this, "Você não pode aumentar mais pontos em Força.", Toast.LENGTH_SHORT).show()
            }
        }

        btnForcaMenos.setOnClickListener {
            if (forca > 8) {
                forca--
                pontosRestantes++
                txtForca.text = forca.toString()
                txtPontosRestantes.text = "Pontos Restantes: $pontosRestantes"
            } else {
                Toast.makeText(this, "O valor mínimo é 8.", Toast.LENGTH_SHORT).show()
            }
        }

        // Repetir lógica para outros atributos: destreza, inteligência, etc.

        btnCriarPersonagem.setOnClickListener {
            val nome = nomePersonagem.text.toString()
            val racaSelecionada = racaSpinner.selectedItem.toString()

            if (nome.isEmpty()) {
                Toast.makeText(this, "Por favor, insira um nome.", Toast.LENGTH_SHORT).show()
            } else {
                // Aqui você pode criar o personagem usando sua classe Personagem
                val personagem = Personagem(nome, getRacaByNome(racaSelecionada))
                // Aplicar lógica de distribuição de pontos
                Toast.makeText(this, "Personagem criado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Função auxiliar para retornar a raça baseada no nome selecionado
    private fun getRacaByNome(nome: String): Raca {
        return when (nome) {
            "Draconato" -> Draconato()
            "Elfo" -> Elfo()
            "Humano" -> Humano()
            "Orc" -> Orc()
            "Anão" -> Anao()
            else -> Humano() // Valor padrão
        }
    }
}


