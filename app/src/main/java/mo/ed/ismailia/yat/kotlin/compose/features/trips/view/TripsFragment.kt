package mo.ed.ismailia.yat.kotlin.compose.features.trips.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import mo.ed.ismailia.yat.kotlin.compose.features.trips.view.screen.tripsScreen
import mo.ed.ismailia.yat.kotlin.compose.features.trips.viewmodel.TripsViewModelFactory
import mo.ed.ismailia.yat.kotlin.data.repository.trips.TripsRepository

class TripsFragment : Fragment() {
    private lateinit var tripsViewModelFactory: TripsViewModelFactory
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                navController = NavHostFragment.findNavController(this@TripsFragment)
                // jetpack compose coding
                val tripsRepository = TripsRepository()
                tripsViewModelFactory = TripsViewModelFactory(tripsRepository)

                navController?.let {
                    tripsScreen(tripsViewModel = viewModel(factory = tripsViewModelFactory))
                }

            }
        }
    }
}