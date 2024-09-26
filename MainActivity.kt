package br.unipar.churraspar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os campos de entrada e botões
        val homensInput = findViewById<EditText>(R.id.homensInput)
        val mulheresInput = findViewById<EditText>(R.id.mulheresInput)
        val criancasInput = findViewById<EditText>(R.id.criancasInput)
        val calcularBtn = findViewById<Button>(R.id.calcularBtn)
        val limparBtn = findViewById<Button>(R.id.limparBtn)
        val resultadoText = findViewById<TextView>(R.id.resultadoText)

        // Função para realizar o cálculo
        calcularBtn.setOnClickListener {
            val homens = homensInput.text.toString().toIntOrNull() ?: 0
            val mulheres = mulheresInput.text.toString().toIntOrNull() ?: 0
            val criancas = criancasInput.text.toString().toIntOrNull() ?: 0

            // Cálculo da carne
            val carneHomens = homens * 400
            val carneMulheres = mulheres * 300
            val carneCriancas = criancas * 200
            val carneTotal = (carneHomens + carneMulheres + carneCriancas) * 1.1 // Adiciona 10% de margem

            // Cálculo dos aperitivos
            val aperitivosHomens = homens * 150
            val aperitivosMulheres = mulheres * 100
            val aperitivosCriancas = criancas * 50
            val aperitivosTotal = (aperitivosHomens + aperitivosMulheres + aperitivosCriancas) * 1.1 // Adiciona 10% de margem

            // Cálculo da bebida alcoólica (apenas homens e mulheres)
            val cervejaHomens = homens * 4.0
            val cervejaMulheres = mulheres * 2.0
            val cervejaTotal = (cervejaHomens + cervejaMulheres) * 1.1 // Adiciona 10% de margem

            // Cálculo de água (apenas mulheres e crianças)
            val aguaMulheres = mulheres * 2.0
            val aguaCriancas = criancas * 2.0
            val aguaTotal = (aguaMulheres + aguaCriancas) * 1.1 // Adiciona 10% de margem

            // Cálculo de refrigerante (apenas mulheres e crianças)
            val refrigeranteMulheres = mulheres * 1.5
            val refrigeranteCriancas = criancas * 1.5
            val refrigeranteTotal = (refrigeranteMulheres + refrigeranteCriancas) * 1.1 // Adiciona 10% de margem

            // Exibindo os resultados
            resultadoText.text = """
                Carne Total: ${carneTotal.roundToInt()}g
                Aperitivos Total: ${aperitivosTotal.roundToInt()}g
                Cerveja Total: ${cervejaTotal.roundToInt()}L
                Água Total: ${aguaTotal.roundToInt()}L
                Refrigerante Total: ${refrigeranteTotal.roundToInt()}L
            """.trimIndent()
        }

        // Função para limpar os campos
        limparBtn.setOnClickListener {
            homensInput.text.clear()
            mulheresInput.text.clear()
            criancasInput.text.clear()
            resultadoText.text = ""
        }
    }
}
