package ru.alinadorozhkina.tulasteelproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.alinadorozhkina.tulasteelproject.databinding.ActivityMainBinding
import ru.alinadorozhkina.tulasteelproject.databinding.ItemCardBinding
import ru.alinadorozhkina.tulasteelproject.entities.*

class MainActivity : AppCompatActivity() {

    private var vb: ActivityMainBinding? = null

    private val allProducts: List<Product> = listOf(
        ArmaturaGladkaia(),
        ArmaturaPeriodicheskaia(),
        UgolokRapnopolochnyi(),
        UgolokNerapnopolochnyi(),
        Shveller(),
        Dvutavra(),
        Krug(),
        Kvadrat(),
        Shestigrannik(),
        Polosa(),
        Katanka(),
        KvadratnaiaZagotovka()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        init()
    }

    private fun init() = with(vb) {
        this!!.rvAllProducts.adapter = BaseRVAdapter(
            allProducts,
            R.layout.item_card,
        )
        {view, data ->
            bind (view, data)
        }

    }

    private fun bind (view: View, data: Product) {
        val rvBinding = ItemCardBinding.bind(view)
        with (rvBinding) {
                tvTitle.text = data.name
                ivPicture.setImageResource(data.picture)
            }
    }
}