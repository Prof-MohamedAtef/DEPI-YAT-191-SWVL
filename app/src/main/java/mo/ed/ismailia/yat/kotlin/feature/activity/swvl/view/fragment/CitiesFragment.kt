package mo.ed.ismailia.yat.kotlin.feature.activity.swvl.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.activity.swvl.model.City
import mo.ed.ismailia.yat.kotlin.feature.activity.swvl.view.adapter.CitiesAdapter
import mo.ed.ismailia.yat.kotlin.feature.activity.swvl.viewmodel.CitiesViewModel

class CitiesFragment : Fragment() {

    lateinit var rvCities: RecyclerView
    val citiesList: List<City> = listOf(
        City(
            "Hurgada",
            "https://www.egiptoexclusivo.com/wp-content/uploads/2023/06/playas-de-hurghada.jpg",
            tripPrice = "300 EGP",
            "30.123456",
            "31.65416123"
        ),
        City(
            "Alexandria",
            "https://www.egiptoexclusivo.com/wp-content/uploads/2023/06/corniche-alejandria.jpg",
            tripPrice = "400 EGP",
            "30.123456",
            "31.65416123"
        ),
        City(
            "Dahab",
            "https://www.traveltoegypt.net/uploads/discover/topics/1644923855top-9-things-to-do-in-dahab.jpg",
            tripPrice = "500 EGP",
            "30.123456",
            "31.65416123"
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.travel_from_fragment, container, false)
        rvCities = view.findViewById(R.id.rvCities)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val citiesAdapter = CitiesAdapter(citiesList)
        val gridLayoutManager = GridLayoutManager(activity,1, GridLayoutManager.HORIZONTAL, false)
        rvCities.layoutManager = gridLayoutManager
        rvCities.adapter = citiesAdapter

    }
}