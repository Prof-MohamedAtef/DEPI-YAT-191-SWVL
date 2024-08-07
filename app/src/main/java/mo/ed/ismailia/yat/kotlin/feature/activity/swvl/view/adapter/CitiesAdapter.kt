package mo.ed.ismailia.yat.kotlin.feature.activity.swvl.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.feature.activity.swvl.model.City

class CitiesAdapter(private val citiesList: List<City>) :
    RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.cityImageView)
        val tvCityTitle: TextView = itemView.findViewById(R.id.tvCityTitle)
        val tvTripPrice: TextView = itemView.findViewById(R.id.tvTripPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return citiesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = citiesList[position]
        holder.tvCityTitle.text = city.cityName
        holder.tvTripPrice.text = city.tripPrice
        Picasso.get()
            .load(city.cityImage)
            .into(holder.imageView)
    }
}