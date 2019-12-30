package com.mikhailovskii.weatherandroid.ui.forecast


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mikhailovskii.weatherandroid.R
import kotlinx.android.synthetic.main.fragment_forecast.*
import java.util.*

class ForecastFragment : Fragment(), ForecastContract.ForecastView {

    private val presenter = ForecastPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.attachView(this)
        return inflater.inflate(R.layout.fragment_forecast, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar = Calendar.getInstance(TimeZone.getDefault())
        val date = "${calendar.getDisplayName(
            Calendar.DAY_OF_WEEK,
            Calendar.LONG, Locale.getDefault()
        )}," +
                " ${calendar.get(Calendar.DATE)}." +
                "${calendar.get(Calendar.MONTH) + 1}." +
                "${calendar.get(Calendar.YEAR)}"

        date_tv.text = date
    }

    override fun showEmptyState(value: Boolean) {

    }

    override fun showLoadingIndicator(value: Boolean) {

    }


}
