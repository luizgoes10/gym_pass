package codeone.com.br.gympass.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.SupportMapFragment
import codeone.com.br.gympass.R
import codeone.com.br.gympass.models.Company
import codeone.com.br.gympass.models.Details
import codeone.com.br.gympass.utils.BundlesConstants
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private var map:GoogleMap? = null
    private var details:Details? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_maps, container, false)

        var mapFragment:SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragments_maps) as SupportMapFragment

        mapFragment.getMapAsync(this)

        details = arguments?.getParcelable(BundlesConstants.DETAILS_KEY)

        return view
    }


    override fun onMapReady(maps: GoogleMap?) {
        map = maps

        val location = LatLng(details?.result?.geometry?.location!!.lat, details?.result?.geometry?.location!!.lng)

        val update = CameraUpdateFactory.newLatLngZoom(location, 13f)

        map?.moveCamera(update)

        map?.addMarker(MarkerOptions()
                .title(details!!.result.name)
                .snippet(details!!.result.formattedAddress)
                .position(location))
        map?.mapType = GoogleMap.MAP_TYPE_NORMAL
    }
}
